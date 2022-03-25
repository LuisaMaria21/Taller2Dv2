/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.jdom2.Document;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author andres_fel.acosta
 */
public class ManejoArchivo {

    public static boolean guardarArchivoXML(HashMap<String, LinkedList<punto2D>> mp, String ruta) {
        boolean t = false;

        Element figurasG = new Element("FigurasGeometricas");
        Document document = new Document(figurasG);

        Iterator<Map.Entry<String, LinkedList<punto2D>>> entries = mp.entrySet().iterator();

        while (entries.hasNext()) {
            Map.Entry<String, LinkedList<punto2D>> entry = entries.next();
            String nombreF = entry.getKey();
            Element fg = new Element("FiguraGeometrica");
            fg.setAttribute("nombreF", nombreF);
            LinkedList<punto2D> lp = entry.getValue();

            for (int i = 0; i < lp.size(); i++) {
                punto2D punto = entry.getValue().get(i);
                double x = punto.getX();
                double y = punto.getY();
                fg.addContent(new Element("Punto" + i).
                        setAttribute("X", String.valueOf(x)).
                        setAttribute("Y", String.valueOf(y)));

                //System.out.println("Puntos "+punto.toString()+"\n");
            }
            document.getRootElement().addContent(fg);
            t = true;
            try {
                FileWriter writer = new FileWriter(ruta + "figurasG.xml");
                XMLOutputter outputter = new XMLOutputter();

                outputter.setFormat(Format.getCompactFormat().getPrettyFormat());
                outputter.output(document, writer);
                outputter.output(document, System.out);

            } catch (Exception e) {
                System.out.println("Error " + e.toString());
            }
        }

        return t;

    }
    
    public static HashMap cargar(String ruta){
        HashMap Mp= new HashMap();
        
        try {
            File File= new File(ruta +"figurasG.xml");
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(File); 
            System.out.println("Root element :" + document.getRootElement().getName());
            Element classElement = document.getRootElement();
            
            
            
        } catch (Exception e) {
            System.out.println("Error " + e.toString());
        }
        
        return Mp;
    }

    public static String direccion() {

        String ruta = null;
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            ruta = selectedFile.getAbsolutePath();
        }

        return ruta;

    }

}
