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
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
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

    int contadorE1;
    int contadorE2;
    int contadorHexa;
    int contadorhep;
    int contadoroct;
    int contadordeca;
    int contadorpacman;

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
    private RadioButton contorno;

    @FXML
    private RadioButton relleno;

    @FXML
    private ToggleGroup tgFigura;

    @FXML
    private Slider sliderTamaño;

    @FXML
    private Slider sliderContorno;

    @FXML
    private void obtenerCoordenadas(MouseEvent event) {
        coordenadaX = event.getX();
        coordenadaY = event.getY();

        punto2D objp = new punto2D(coordenadaX, coordenadaY);

        System.out.println("Punto " + objp.toString());

        if (estrella1.isSelected() == true) {
            x = new double[10];
            y = new double[10];
            r = sliderTamaño.getValue()/2; 

            listap = new LinkedList<>();
            x[0] = (coordenadaX + r * 2);
            y[0] = coordenadaY;
            x[1] = coordenadaX + (r * Math.cos(2 * Math.PI / 10));
            y[1] = coordenadaY - (r * Math.sin(2 * Math.PI / 10));
            x[2] = coordenadaX + (r * Math.cos(2 * 2 * Math.PI / 10) * 2);
            y[2] = coordenadaY - (r * Math.sin(2 * 2 * Math.PI / 10) * 2);
            x[3] = coordenadaX + (r * Math.cos(3 * 2 * Math.PI / 10));
            y[3] = coordenadaY - (r * Math.sin(3 * 2 * Math.PI / 10));
            x[4] = coordenadaX + (r * Math.cos(4 * 2 * Math.PI / 10) * 2);
            y[4] = coordenadaY - (r * Math.sin(4 * 2 * Math.PI / 10) * 2);
            x[5] = coordenadaX + (r * Math.cos(5 * 2 * Math.PI / 10));
            y[5] = coordenadaY - (r * Math.sin(5 * 2 * Math.PI / 10));
            x[6] = coordenadaX + (r * Math.cos(6 * 2 * Math.PI / 10) * 2);
            y[6] = coordenadaY - (r * Math.sin(6 * 2 * Math.PI / 10) * 2);
            x[7] = coordenadaX + (r * Math.cos(7 * 2 * Math.PI / 10));
            y[7] = coordenadaY - (r * Math.sin(7 * 2 * Math.PI / 10));
            x[8] = coordenadaX + (r * Math.cos(8 * 2 * Math.PI / 10) * 2);
            y[8] = coordenadaY - (r * Math.sin(8 * 2 * Math.PI / 10) * 2);
            x[9] = coordenadaX + (r * Math.cos(9 * 2 * Math.PI / 10));
            y[9] = coordenadaY - (r * Math.sin(9 * 2 * Math.PI / 10));

            if (contorno.isSelected() == true && relleno.isSelected() == true) {
                g.setStroke(colorContorno.getValue());
                g.setFill(colorRelleno.getValue());
                g.setLineWidth(sliderContorno.getValue());
                g.strokePolygon(x, y, 10);
                g.fillPolygon(x, y, 10);

            } else if (contorno.isSelected() == true) {
                g.setStroke(colorContorno.getValue());
                g.setLineWidth(sliderContorno.getValue());
                g.strokePolygon(x, y, 10);

            } else if (relleno.isSelected() == true) {
                g.setFill(colorRelleno.getValue());
                g.fillPolygon(x, y, 10);
            }

            for (int i = 0; i < x.length; i++) {
                listap.add(new punto2D(x[i], y[i]));
                contadorE1 = contadorE1 + 1;
            }

            mapaEjemplo.put("Estrella 5 puntas" + contadorE1, listap);

        } else if (estrella2.isSelected() == true) {
            x = new double[12];
            y = new double[12];
            r = sliderTamaño.getValue()/2;

            listap = new LinkedList<>();
            x[0] = (coordenadaX + r * 2);
            y[0] = coordenadaY;
            x[1] = coordenadaX + (r * Math.cos(2 * Math.PI / 12));
            y[1] = coordenadaY - (r * Math.sin(2 * Math.PI / 12));
            x[2] = coordenadaX + (r * Math.cos(2 * 2 * Math.PI / 12) * 2);
            y[2] = coordenadaY - (r * Math.sin(2 * 2 * Math.PI / 12) * 2);
            x[3] = coordenadaX + (r * Math.cos(3 * 2 * Math.PI / 12));
            y[3] = coordenadaY - (r * Math.sin(3 * 2 * Math.PI / 12));
            x[4] = coordenadaX + (r * Math.cos(4 * 2 * Math.PI / 12) * 2);
            y[4] = coordenadaY - (r * Math.sin(4 * 2 * Math.PI / 12) * 2);
            x[5] = coordenadaX + (r * Math.cos(5 * 2 * Math.PI / 12));
            y[5] = coordenadaY - (r * Math.sin(5 * 2 * Math.PI / 12));
            x[6] = coordenadaX + (r * Math.cos(6 * 2 * Math.PI / 12) * 2);
            y[6] = coordenadaY - (r * Math.sin(6 * 2 * Math.PI / 12) * 2);
            x[7] = coordenadaX + (r * Math.cos(7 * 2 * Math.PI / 12));
            y[7] = coordenadaY - (r * Math.sin(7 * 2 * Math.PI / 12));
            x[8] = coordenadaX + (r * Math.cos(8 * 2 * Math.PI / 12) * 2);
            y[8] = coordenadaY - (r * Math.sin(8 * 2 * Math.PI / 12) * 2);
            x[9] = coordenadaX + (r * Math.cos(9 * 2 * Math.PI / 12));
            y[9] = coordenadaY - (r * Math.sin(9 * 2 * Math.PI / 12));
            x[10] = coordenadaX + (r * Math.cos(10 * 2 * Math.PI / 12) * 2);
            y[10] = coordenadaY - (r * Math.sin(10 * 2 * Math.PI / 12)) * 2;
            x[11] = coordenadaX + (r * Math.cos(11 * 2 * Math.PI / 12));
            y[11] = coordenadaY - (r * Math.sin(11 * 2 * Math.PI / 12));
            
             if (contorno.isSelected() == true && relleno.isSelected() == true) {
                g.setStroke(colorContorno.getValue());
                g.setFill(colorRelleno.getValue());
                g.setLineWidth(sliderContorno.getValue());
                g.strokePolygon(x, y, 12);
                g.fillPolygon(x, y, 12);

            } else if (contorno.isSelected() == true) {
                g.setStroke(colorContorno.getValue());
                g.setLineWidth(sliderContorno.getValue());
                g.strokePolygon(x, y, 12);

            } else if (relleno.isSelected() == true) {
                g.setFill(colorRelleno.getValue());
                g.fillPolygon(x, y, 12);
            }

            for (int i = 0; i < x.length; i++) {
                listap.add(new punto2D(x[i], y[i]));
                contadorE2 = contadorE2 + 1;
            }

            mapaEjemplo.put("Estrella 6 puntas" + contadorE2, listap);

        } else if (hexa.isSelected() == true) {
            x = new double[6];
            y = new double[6];
            r = sliderTamaño.getValue();

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

            if (contorno.isSelected() == true && relleno.isSelected() == true) {
                g.setStroke(colorContorno.getValue());
                g.setFill(colorRelleno.getValue());
                g.setLineWidth(sliderContorno.getValue());
                g.strokePolygon(x, y, 6);
                g.fillPolygon(x, y, 6);

            } else if (contorno.isSelected() == true) {
                g.setStroke(colorContorno.getValue());
                g.setLineWidth(sliderContorno.getValue());
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
            r = sliderTamaño.getValue();

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

            if (contorno.isSelected() == true && relleno.isSelected() == true) {
                g.setStroke(colorContorno.getValue());
                g.setFill(colorRelleno.getValue());
                g.setLineWidth(sliderContorno.getValue());
                g.strokePolygon(x, y, 7);
                g.fillPolygon(x, y, 7);

            } else if (contorno.isSelected() == true) {
                g.setStroke(colorContorno.getValue());
                g.setLineWidth(sliderContorno.getValue());
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
            r = sliderTamaño.getValue();

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

            if (contorno.isSelected() == true && relleno.isSelected() == true) {
                g.setStroke(colorContorno.getValue());
                g.setLineWidth(sliderContorno.getValue());
                g.setFill(colorRelleno.getValue());
                g.strokePolygon(x, y, 8);
                g.fillPolygon(x, y, 8);

            } else if (contorno.isSelected() == true) {
                g.setStroke(colorContorno.getValue());
                g.setLineWidth(sliderContorno.getValue());
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
            r = sliderTamaño.getValue();

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

            if (contorno.isSelected() == true && relleno.isSelected() == true) {
                g.setStroke(colorContorno.getValue());
                g.setFill(colorRelleno.getValue());
                g.setLineWidth(sliderContorno.getValue());
                g.strokePolygon(x, y, 10);
                g.fillPolygon(x, y, 10);

            } else if (contorno.isSelected() == true) {
                g.setStroke(colorContorno.getValue());
                g.setLineWidth(sliderContorno.getValue());
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
            r = sliderTamaño.getValue()*2;

            if (contorno.isSelected() == true && relleno.isSelected() == true) {
                g.setStroke(colorContorno.getValue());
                g.setFill(colorRelleno.getValue());
                g.setLineWidth(sliderContorno.getValue());
                g.fillArc(coordenadaX + 2, coordenadaY, r, r, 370, 320, ArcType.ROUND);
                g.strokeArc(coordenadaX, coordenadaY, r, r, 370, 320, ArcType.ROUND);

            } else if (contorno.isSelected() == true) {
                g.setStroke(colorContorno.getValue());
                g.setLineWidth(sliderContorno.getValue());
                g.strokeArc(coordenadaX, coordenadaY, r, r, 370, 320, ArcType.ROUND);

            } else if (relleno.isSelected() == true) {
                g.setFill(colorRelleno.getValue());
                g.fillArc(coordenadaX + 2, coordenadaY, r, r, 370, 320, ArcType.ROUND);
            }

            for (int i = 0; i < x.length; i++) {

                listap.add(new punto2D(x[i], y[i]));
                contadorpacman = contadorpacman + 1;
            }

            mapaEjemplo.put("Pac-Man" + contadorpacman, listap);

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
                + "3.De ser una figura con contorno, escoja el color del contorno. \n"
                + "4.Escoja el tamaño de la figura y del contorno (de ser necesario).\n"
                + "5.Haga clic en el lienzo en el lugar donde quiere que se dibuje la figura. \n"
                + "6.Haga clic en -Guardar- para guardar, escoja su carpeta de preferencia. \n"
                + "7.Haga clic en -Recuperar-  para recuperar un archivo guardado.");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        // TODO
//        filechooser.setInitialDirectory(new File(pathname "C:\\temp"));
        g = lienzo.getGraphicsContext2D();
        r = 0;
        contadorE1 = 0;
        contadorE2 = 0;
        contadorHexa = 0;
        contadorhep = 0;
        contadoroct = 0;
        contadordeca = 0;
        contadorpacman = 0;

        mapaEjemplo = new HashMap<>();
        double w = lienzo.getWidth();
        double h = lienzo.getHeight();

        g.setStroke(Color.DARKCYAN);
        g.setLineWidth(3);
        g.strokeRect(0, 0, w, h);

    }

}
