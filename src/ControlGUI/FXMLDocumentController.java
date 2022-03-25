/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlGUI;

import Modelo.ManejoArchivo;
import Modelo.punto2D;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author luisa
 */
public class FXMLDocumentController implements Initializable {

    double coordenadaX;
    double coordenadaY;

    GraphicsContext g;
    FileChooser filechooser = new FileChooser();

    double[] x;
    double[] y;
    double r;

    int contadorH;
    int contadorP;

    LinkedList<punto2D> listap;
    HashMap<String, LinkedList<punto2D>> mapaEjemplo;

    @FXML
    private Canvas lienzo;

    @FXML
    private Label labelContorno;

    @FXML
    private Label labelRelleno;

    @FXML
    private Label labelTamaño;

    @FXML
    private ColorPicker colorContorno;

    @FXML
    private ColorPicker colorRelleno;

    @FXML
    private RadioButton estrella1;

    @FXML
    private RadioButton estrella2;

    @FXML
    private RadioButton hexa;

    @FXML
    private RadioButton hepta;

    @FXML
    private RadioButton octa;

    @FXML
    private RadioButton deca;

    @FXML
    private RadioButton contorno;

    @FXML
    private RadioButton relleno;

    @FXML
    private ToggleGroup tgFigura;
    
    @FXML
    private void obtenerCoordenadas(MouseEvent event) {
        coordenadaX = event.getX();
        coordenadaY = event.getY();

        punto2D objp = new punto2D(coordenadaX, coordenadaY);

        System.out.println("Punto " + objp.toString());

        boolean star1 = estrella1.isSelected();
        System.out.println(star1);

        boolean star2 = estrella2.isSelected();
        System.out.println(star2);

        boolean hexagon = hexa.isSelected();
        System.out.println(hexagon);

        boolean heptagon = hepta.isSelected();
        System.out.println(heptagon);

        boolean octagon = octa.isSelected();
        System.out.println(octagon);

        boolean decagon = deca.isSelected();
        System.out.println(decagon);
        
        boolean stroke = contorno.isSelected();
        System.out.println(stroke);
        
        boolean fill = relleno.isSelected();
        System.out.println(fill); 
        
        

        if (star1 == true) {

        } else if (star2 == true) {

        } else if (hexagon == true) {
            x = new double[6];
            y = new double[6];

            listap = new LinkedList<>();
            x[0] = (coordenadaX + r);
            y[0] = coordenadaY;
            x[1] = coordenadaX + (r * Math.cos(2 * Math.PI / 6));
            y[1] = coordenadaY - (r * Math.sin(2 * Math.PI / 6));
            x[2] = coordenadaX + (r * Math.cos(2 * 2 * Math.PI / 6));
            y[2] = coordenadaY - (r * Math.sin(2 * 2 * Math.PI / 6));
            x[3] = coordenadaX + (r * Math.cos(3 * 2 * Math.PI / 6));
            y[3] = coordenadaY - (r * Math.sin(3 * 2 * Math.PI / 6));
            x[4] = coordenadaX + (r * Math.cos(4 * 2 * Math.PI / 6));
            y[4] = coordenadaY - (r * Math.sin(4 * 2 * Math.PI / 6));
            x[5] = coordenadaX + (r * Math.cos(5 * 2 * Math.PI / 6));
            y[5] = coordenadaY - (r * Math.sin(5 * 2 * Math.PI / 6));
            
            if (stroke==true) {
              //  g.setStroke(ColorPicker.colorContorno);     
            }
            
            g.setLineWidth(3);
            g.strokePolygon(x, y, 6);
            for (int i = 0; i < x.length; i++) {

                listap.add(new punto2D(x[i], y[i]));
                contadorH = contadorH + 1;
            }

            mapaEjemplo.put("Hexagono" + contadorH, listap);
        }

    }

    @FXML
    private void file(ActionEvent event) {
//       
        String ruta = ManejoArchivo.direccion();
        boolean t = ManejoArchivo.guardarArchivoXML(mapaEjemplo, ruta);
        if (t == true) {
            System.out.println("Guardo con exito");
        } else {
            System.out.println("No Guardo");
        }
    }

    @FXML
    private void open(ActionEvent event) {

    }

    @FXML
    private void help(ActionEvent event) {

        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "AYUDA \n"
                + "1.Escoja la figura que quiere realizar. \n"
                + "2.Escoja el color de relleno de la figura \n"
                + "3.De ser una figura con contorno, escoja el relleno del contorno. \n"
                + "4.Haga clic en el lienzo en el lugar donde quiere que se dibuje la figura. \n"
                + "5.Haga clic en -Guardar- para guardar, escoja su carpeta de preferencia. \n"
                + "6.Haga clic en -Recuperar-  para recuperar un archivo guardado.");

    }

 

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        // TODO
//        filechooser.setInitialDirectory(new File(pathname "C:\\temp"));
        g = lienzo.getGraphicsContext2D();
        r = 100;
        contadorH = 0;
        contadorP = 0;
        mapaEjemplo = new HashMap<>();
        double w = lienzo.getWidth();
        double h = lienzo.getHeight();
        
        g.setStroke(Color.DARKCYAN);
        g.setLineWidth(3);
        g.strokeRect(0, 0, w, h);

    }

}
