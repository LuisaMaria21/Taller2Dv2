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
import javax.swing.JFileChooser;


/**
 *
 * @author andres_fel.acosta
 */
//public class ManejoArchivo {
//    public static boolean guardarArchivoXML(HashMap<String, LinkedList<Punto2D>> mp) {
//        boolean t = false;
//
//        Element figurasG = new Element("FigurasGeometricas");
//        Document document = new Document(figurasG);
//
//        Iterator<Map.Entry<String, LinkedList<Punto2D>>> entries = mp.entrySet().iterator();
//
//        while (entries.hasNext()) {
//            Map.Entry<String, LinkedList<Punto2D>> entry = entries.next();
//            String nombreF = entry.getKey();
//            Element fg = new Element("FiguraGeometrica");
//            fg.setAttribute("nombreF", nombreF);
//            LinkedList<Punto2D> lp = entry.getValue();
//
//            for (int i = 0; i < lp.size(); i++) {
//                Punto2D punto = entry.getValue().get(i);
//                double x = punto.getX();
//                double y = punto.getY();
//                fg.addContent(new Element("Punto" + i).
//                        setAttribute("X", String.valueOf(x)).
//                        setAttribute("Y", String.valueOf(y)));
//
//                //System.out.println("Puntos "+punto.toString()+"\n");
//            }
//            document.getRootElement().addContent(fg);
//            t = true;
//            try{
//                FileWriter writer = new FileWriter(ruta+"figurasG.xml");
//                XMLOutputter outputter = new XMLOutputter();
//                
//            outputter.setFormat(Format.getCompactFormat().getPrettyFormat());
//            outputter.output(document, writer);
//            outputter.output(document, System.out);
//                
//            }catch(Exception e){
//                System.out.println("Error "+e.toString());
//            }
//        }
//
//        return t;
//
//    }
    
//    public static boolean direccion(){
//        boolean t=false;
//        
//        JFileChooser fc= new JFileChooser();
//        fc.setCurrentDirectory(new File("."));
//        fc.setDialogTitle("Seleccione carpeta donde desea guardar el archivo");
//        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//        fc.setAcceptAllFileFilterUsed(false);
//        
//        if (fc.showOpenDialog()=JFileChooser.APPROVE_OPTION) {
//            
//            File carpetaSeleccionada= fc.getCurrentDirectory();
//            
//        }
//        
//        
//        
//        return=t;
//    }
//}
