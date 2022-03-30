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
 * Clase Para Guardar/Recuperar
 * 
 ** @author andres_fel.acosta@uao.edu.co Andres Felipe Acosta lozada 2201212
 * luisa_maria.cuero@uao.edu.co Luisa María Cuero Ampudia 2195064
 * julieta.lara@uao.edu.co Julieta Lara Romero 2200619
 * juan_fernando.aldana@uao.edu.co Juan Fernando Aldana 2201173
 * @date 29 Marzo 2022
 * @version 1.0
 */
public class ManejoArchivo {

    public static void guardarFiguras(File archivoSeleccionado,
                                      GraphicsContext graphicsContext,
                                      List<Figura> figuras) {
        //Metodo para guardar las figuras en el cual se ponen los metodos
        guardarEnPng(archivoSeleccionado.getParent(), archivoSeleccionado.getName(), graphicsContext);
        guardarXml(archivoSeleccionado.getParent(), archivoSeleccionado.getName(), figuras);
    }

    private static void guardarXml(String ruta, String name, List<Figura> figuras) {
        //Metodo para guardar el archivo en formato XML
        try {
            String stringDeObjetosEnXml = convertToXML(figuras);
            Files.write(Paths.get(ruta + File.separator + name + ".xml"), stringDeObjetosEnXml.getBytes());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static void guardarEnPng(String ruta, String name, GraphicsContext graphicsContext) {
        //Metodo para guardar las figuras en Formato PNG 
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
        //metodo para convertir con la libreria a xml
        XStream xstream = new XStream();
        xstream.alias("figura", Figura.class);
        xstream.alias("figuras", ListaFiguras.class);
        xstream.addImplicitCollection(ListaFiguras.class, "figuras");
        return xstream.toXML(new ListaFiguras(figuras));
    }

    public static List<Figura> recuperarFiguras(File archivoSeleccionado) {
        //Metodo para recuperar los archivos para que el usuario los pueda usar
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
