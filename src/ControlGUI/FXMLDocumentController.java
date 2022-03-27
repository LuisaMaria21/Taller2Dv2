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
import javafx.scene.shape.FillRule;
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

    int contadorHexa;
    int contadorhep;
    int contadoroct; 
    int contadordeca; 

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
    private Label labelTamañoC;

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
    private RadioButton pacman;

    @FXML
    private RadioButton curva;

    @FXML
    private ToggleGroup tgFigura;

    @FXML
    private RadioButton contorno;

    @FXML
    private RadioButton relleno;

    @FXML
    private void obtenerCoordenadas(MouseEvent event) {
        coordenadaX = event.getX();
        coordenadaY = event.getY();

        punto2D objp = new punto2D(coordenadaX, coordenadaY);

        System.out.println("Punto " + objp.toString());

        if (estrella1.isSelected() == true) {

        } else if (estrella2.isSelected() == true) {

        } else if (hexa.isSelected() == true) {
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
//falta editar para que puedan escoger el tamaño del contorno 
            g.setLineWidth(3);

            if (contorno.isSelected() == true && relleno.isSelected() == true) {
                g.setStroke(colorContorno.getValue());
                g.setFill(colorRelleno.getValue());
                g.strokePolygon(x, y, 6);
                g.fillPolygon(x, y, 6);

            } else if (contorno.isSelected() == true) {
                g.setStroke(colorContorno.getValue());
                g.strokePolygon(x, y, 6);

            } else if (relleno.isSelected() == true) {
                g.setFill(colorRelleno.getValue());
                g.fillPolygon(x, y, 6);
            }

            for (int i = 0; i < x.length; i++) {
                listap.add(new punto2D(x[i], y[i]));
                contadorHexa = contadorHexa + 1;
            }

            mapaEjemplo.put("Hexagono" + contadorHexa, listap);

        } else if (hepta.isSelected() == true) {
            x = new double[7];
            y = new double[7];

            listap = new LinkedList<>();

            x[0] = (coordenadaX + r);
            y[0] = coordenadaY;
            x[1] = coordenadaX + (r * Math.cos(2 * Math.PI / 7));
            y[1] = coordenadaY - (r * Math.sin(2 * Math.PI / 7));
            x[2] = coordenadaX + (r * Math.cos(2 * 2 * Math.PI / 7));
            y[2] = coordenadaY - (r * Math.sin(2 * 2 * Math.PI / 7));
            x[3] = coordenadaX + (r * Math.cos(3 * 2 * Math.PI / 7));
            y[3] = coordenadaY - (r * Math.sin(3 * 2 * Math.PI / 7));
            x[4] = coordenadaX + (r * Math.cos(4 * 2 * Math.PI / 7));
            y[4] = coordenadaY - (r * Math.sin(4 * 2 * Math.PI / 7));
            x[5] = coordenadaX + (r * Math.cos(5 * 2 * Math.PI / 7));
            y[5] = coordenadaY - (r * Math.sin(5 * 2 * Math.PI / 7));
            x[6] = coordenadaX + (r * Math.cos(6 * 2 * Math.PI / 7));
            y[6] = coordenadaY - (r * Math.sin(6 * 2 * Math.PI / 7));

            g.setLineWidth(3);

            if (contorno.isSelected() == true && relleno.isSelected() == true) {
                g.setStroke(colorContorno.getValue());
                g.setFill(colorRelleno.getValue());
                g.strokePolygon(x, y, 7);
                g.fillPolygon(x, y, 7);

            } else if (contorno.isSelected() == true) {
                g.setStroke(colorContorno.getValue());
                g.strokePolygon(x, y, 7);

            } else if (relleno.isSelected() == true) {
                g.setFill(colorRelleno.getValue());
                g.fillPolygon(x, y, 7);
            }

            for (int i = 0; i < x.length; i++) {

                listap.add(new punto2D(x[i], y[i]));
                contadorhep = contadorhep + 1;
            }

            mapaEjemplo.put("Heptagono" + contadorhep, listap);

        } else if (octa.isSelected() == true) {
            x = new double[8];
            y = new double[8];

            listap = new LinkedList<>();

            x[0] = (coordenadaX + r);
            y[0] = coordenadaY;
            x[1] = coordenadaX + (r * Math.cos(2 * Math.PI / 8));
            y[1] = coordenadaY - (r * Math.sin(2 * Math.PI / 8));
            x[2] = coordenadaX + (r * Math.cos(2 * 2 * Math.PI / 8));
            y[2] = coordenadaY - (r * Math.sin(2 * 2 * Math.PI / 8));
            x[3] = coordenadaX + (r * Math.cos(3 * 2 * Math.PI / 8));
            y[3] = coordenadaY - (r * Math.sin(3 * 2 * Math.PI / 8));
            x[4] = coordenadaX + (r * Math.cos(4 * 2 * Math.PI / 8));
            y[4] = coordenadaY - (r * Math.sin(4 * 2 * Math.PI / 8));
            x[5] = coordenadaX + (r * Math.cos(5 * 2 * Math.PI / 8));
            y[5] = coordenadaY - (r * Math.sin(5 * 2 * Math.PI / 8));
            x[6] = coordenadaX + (r * Math.cos(6 * 2 * Math.PI / 8));
            y[6] = coordenadaY - (r * Math.sin(6 * 2 * Math.PI / 8));
            x[7] = coordenadaX + (r * Math.cos(7 * 2 * Math.PI / 8));
            y[7] = coordenadaY - (r * Math.sin(7 * 2 * Math.PI / 8));

            g.setLineWidth(3);

            if (contorno.isSelected() == true && relleno.isSelected() == true) {
                g.setStroke(colorContorno.getValue());
                g.setFill(colorRelleno.getValue());
                g.strokePolygon(x, y, 8);
                g.fillPolygon(x, y, 8);

            } else if (contorno.isSelected() == true) {
                g.setStroke(colorContorno.getValue());
                g.strokePolygon(x, y, 8);

            } else if (relleno.isSelected() == true) {
                g.setFill(colorRelleno.getValue());
                g.fillPolygon(x, y, 8);
            }

            for (int i = 0; i < x.length; i++) {

                listap.add(new punto2D(x[i], y[i]));
                contadoroct = contadoroct + 1;
            }

            mapaEjemplo.put("Octagono" + contadoroct, listap);

        } else if (deca.isSelected() == true) {
            x = new double[10];
            y = new double[10];

            listap = new LinkedList<>();

            x[0] = (coordenadaX + r);
            y[0] = coordenadaY;
            x[1] = coordenadaX + (r * Math.cos(2 * Math.PI / 10));
            y[1] = coordenadaY - (r * Math.sin(2 * Math.PI / 10));
            x[2] = coordenadaX + (r * Math.cos(2 * 2 * Math.PI / 10));
            y[2] = coordenadaY - (r * Math.sin(2 * 2 * Math.PI / 10));
            x[3] = coordenadaX + (r * Math.cos(3 * 2 * Math.PI / 10));
            y[3] = coordenadaY - (r * Math.sin(3 * 2 * Math.PI / 10));
            x[4] = coordenadaX + (r * Math.cos(4 * 2 * Math.PI / 10));
            y[4] = coordenadaY - (r * Math.sin(4 * 2 * Math.PI / 10));
            x[5] = coordenadaX + (r * Math.cos(5 * 2 * Math.PI / 10));
            y[5] = coordenadaY - (r * Math.sin(5 * 2 * Math.PI / 10));
            x[6] = coordenadaX + (r * Math.cos(6 * 2 * Math.PI / 10));
            y[6] = coordenadaY - (r * Math.sin(6 * 2 * Math.PI / 10));
            x[7] = coordenadaX + (r * Math.cos(7 * 2 * Math.PI / 10));
            y[7] = coordenadaY - (r * Math.sin(7 * 2 * Math.PI / 10));
            x[8] = coordenadaX + (r * Math.cos(8 * 2 * Math.PI / 10));
            y[8] = coordenadaY - (r * Math.sin(8 * 2 * Math.PI / 10));
            x[9] = coordenadaX + (r * Math.cos(9 * 2 * Math.PI / 10));
            y[9] = coordenadaY - (r * Math.sin(9 * 2 * Math.PI / 10));

            g.setLineWidth(3);

            if (contorno.isSelected() == true && relleno.isSelected() == true) {
                g.setStroke(colorContorno.getValue());
                g.setFill(colorRelleno.getValue());
                g.strokePolygon(x, y, 10);
                g.fillPolygon(x, y, 10);

            } else if (contorno.isSelected() == true) {
                g.setStroke(colorContorno.getValue());
                g.strokePolygon(x, y, 10);

            } else if (relleno.isSelected() == true) {
                g.setFill(colorRelleno.getValue());
                g.fillPolygon(x, y, 10);
            }

            for (int i = 0; i < x.length; i++) {

                listap.add(new punto2D(x[i], y[i]));
                contadordeca = contadordeca + 1;
            }

            mapaEjemplo.put("Decagono" + contadordeca, listap);

        } else if (pacman.isSelected() == true) {

        } else if (curva.isSelected() == true) {

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
        contadorHexa = 0;
        contadorhep = 0;
        contadoroct=0; 
        contadordeca=0; 
        mapaEjemplo = new HashMap<>();
        double w = lienzo.getWidth();
        double h = lienzo.getHeight();

        g.setStroke(Color.DARKCYAN);
        g.setLineWidth(3);
        g.strokeRect(0, 0, w, h);

    }

}
