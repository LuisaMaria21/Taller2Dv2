/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import com.thoughtworks.xstream.XStream;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.*;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.*;
import java.nio.file.*;
import java.util.List;

/**
 *
 * @author andres_fel.acosta
 */
public class ManejoArchivo {

    public static void guardarFiguras(File archivoSeleccionado,
                                      GraphicsContext graphicsContext,
                                      List<Figura> figuras) {
        guardarEnPng(archivoSeleccionado.getParent(), archivoSeleccionado.getName(), graphicsContext);
        guardarXml(archivoSeleccionado.getParent(), archivoSeleccionado.getName(), figuras);
    }

    private static void guardarXml(String ruta, String name, List<Figura> figuras) {
        try {
            String stringDeObjetosEnXml = convertToXML(figuras);
            Files.write(Paths.get(ruta + File.separator + name + ".xml"), stringDeObjetosEnXml.getBytes());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static void guardarEnPng(String ruta, String name, GraphicsContext graphicsContext) {
        File file = new File(ruta + File.separator + name + ".png");
        try {
            Canvas canvas = graphicsContext.getCanvas();
            WritableImage writableImage = new WritableImage((int) canvas.getWidth(), (int) canvas.getHeight());
            canvas.snapshot(null, writableImage);
            RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
            ImageIO.write(renderedImage, "png", file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static String convertToXML(List<Figura> figuras) {
        XStream xstream = new XStream();
        xstream.alias("figura", Figura.class);
        xstream.alias("figuras", ListaFiguras.class);
        xstream.addImplicitCollection(ListaFiguras.class, "figuras");
        return xstream.toXML(new ListaFiguras(figuras));
    }

    public static List<Figura> recuperarFiguras(File archivoSeleccionado) {
        try {
            String objetosXml = new String (Files.readAllBytes( Paths.get(archivoSeleccionado.getAbsolutePath()) ));
            XStream xstream = new XStream();
            xstream.alias("figura", Figura.class);
            xstream.alias("figuras", ListaFiguras.class);
            xstream.addImplicitCollection(ListaFiguras.class, "figuras");
            xstream.allowTypesByWildcard(new String[]{"modelos.**"});
            ListaFiguras listaFiguras = (ListaFiguras) xstream.fromXML(objetosXml);
            return listaFiguras.getFiguras();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
