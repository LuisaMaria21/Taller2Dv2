/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import modelos.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.image.RenderedImage;
import java.io.*;
import java.net.URL;
import java.util.*;

/**
 *
 * @author luisa
 */
public class FXMLDocumentController implements Initializable {

    GraphicsContext g;

    Figura curvaTemp = new Figura();
    List<Figura> figuras = new ArrayList<>();

    @FXML
    private Canvas lienzo;

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
    private Slider sliderTamaño;

    @FXML
    private Slider sliderContorno;

    @FXML
    private void obtenerCoordenadas(MouseEvent event) {
        Punto punto = new Punto(event.getX(), event.getY());

        Figura figura = new Figura();
        figura.agregarCoordenada(punto);
        figura.setTamanioFigura(sliderTamaño.getValue());

        if (contorno.isSelected() && relleno.isSelected()) {
            figura.setColorContorno(colorContorno.getValue().toString());
            figura.setTamanioContorno(sliderContorno.getValue());
            figura.setColorRelleno(colorRelleno.getValue().toString());
        } else if (contorno.isSelected()) {
            figura.setColorContorno(colorContorno.getValue().toString());
            figura.setTamanioContorno(sliderContorno.getValue());
        } else if (relleno.isSelected()) {
            figura.setColorRelleno(colorRelleno.getValue().toString());
        }

        if (estrella1.isSelected()) {
            figura.setTipo("estrella1");
            figura.setTamanioFigura(sliderTamaño.getValue() / 2);
        }
        if (estrella2.isSelected()) {
            figura.setTipo("estrella2");
            figura.setTamanioFigura(sliderTamaño.getValue() / 2);
        }
        if (hexa.isSelected()) {
            figura.setTipo("hexa");
        }
        if (hepta.isSelected()) {
            figura.setTipo("hepta");
        }
        if (octa.isSelected()) {
            figura.setTipo("octa");
        }
        if (deca.isSelected()) {
            figura.setTipo("deca");
        }
        if (pacman.isSelected()) {
            figura.setTipo("pacman");
            figura.setTamanioFigura(sliderTamaño.getValue() * 2);
        }
        if (curva.isSelected()) {
            figura.setTipo("curva");
            if (curvaTemp.getCoordenadas().isEmpty()) {
                curvaTemp = figura;
            } else {
                curvaTemp.agregarCoordenada(figura.getCoordenadas().get(0));
                figura = curvaTemp;
            }
        }

        dibujarFigura(figura);
    }

    private void dibujarFigura(Figura figura) {
        double[] xPoints;
        double[] yPoints;
        if (!figura.getTipo().equals("curva")) {
            figuras.add(figura);
        }

        if (figura.getTipo().equals("estrella1")) {
            xPoints = new double[10];
            yPoints = new double[10];

            xPoints[0] = (figura.getCoordenadaX() + figura.getTamanioFigura() * 2);
            yPoints[0] = figura.getCoordenadaY();
            xPoints[1] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(2 * Math.PI / 10));
            yPoints[1] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(2 * Math.PI / 10));
            xPoints[2] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(2 * 2 * Math.PI / 10) * 2);
            yPoints[2] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(2 * 2 * Math.PI / 10) * 2);
            xPoints[3] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(3 * 2 * Math.PI / 10));
            yPoints[3] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(3 * 2 * Math.PI / 10));
            xPoints[4] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(4 * 2 * Math.PI / 10) * 2);
            yPoints[4] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(4 * 2 * Math.PI / 10) * 2);
            xPoints[5] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(5 * 2 * Math.PI / 10));
            yPoints[5] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(5 * 2 * Math.PI / 10));
            xPoints[6] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(6 * 2 * Math.PI / 10) * 2);
            yPoints[6] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(6 * 2 * Math.PI / 10) * 2);
            xPoints[7] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(7 * 2 * Math.PI / 10));
            yPoints[7] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(7 * 2 * Math.PI / 10));
            xPoints[8] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(8 * 2 * Math.PI / 10) * 2);
            yPoints[8] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(8 * 2 * Math.PI / 10) * 2);
            xPoints[9] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(9 * 2 * Math.PI / 10));
            yPoints[9] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(9 * 2 * Math.PI / 10));

            if (figura.getColorContorno() != null && figura.getColorRelleno() != null) {
                g.setStroke(Color.valueOf(figura.getColorContorno()));
                g.setFill(Color.valueOf(figura.getColorRelleno()));
                g.setLineWidth(figura.getTamanioContorno());
                g.strokePolygon(xPoints, yPoints, 10);
                g.fillPolygon(xPoints, yPoints, 10);

            } else if (figura.getColorContorno() != null) {
                g.setStroke(Color.valueOf(figura.getColorContorno()));
                g.setLineWidth(figura.getTamanioContorno());
                g.strokePolygon(xPoints, yPoints, 10);

            } else if (figura.getColorRelleno() != null) {
                g.setFill(Color.valueOf(figura.getColorRelleno()));
                g.fillPolygon(xPoints, yPoints, 10);
            }
        } else if (figura.getTipo().equals("estrella2")) {
            xPoints = new double[12];
            yPoints = new double[12];

            xPoints[0] = (figura.getCoordenadaX() + figura.getTamanioFigura() * 2);
            yPoints[0] = figura.getCoordenadaY();
            xPoints[1] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(2 * Math.PI / 12));
            yPoints[1] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(2 * Math.PI / 12));
            xPoints[2] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(2 * 2 * Math.PI / 12) * 2);
            yPoints[2] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(2 * 2 * Math.PI / 12) * 2);
            xPoints[3] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(3 * 2 * Math.PI / 12));
            yPoints[3] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(3 * 2 * Math.PI / 12));
            xPoints[4] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(4 * 2 * Math.PI / 12) * 2);
            yPoints[4] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(4 * 2 * Math.PI / 12) * 2);
            xPoints[5] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(5 * 2 * Math.PI / 12));
            yPoints[5] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(5 * 2 * Math.PI / 12));
            xPoints[6] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(6 * 2 * Math.PI / 12) * 2);
            yPoints[6] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(6 * 2 * Math.PI / 12) * 2);
            xPoints[7] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(7 * 2 * Math.PI / 12));
            yPoints[7] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(7 * 2 * Math.PI / 12));
            xPoints[8] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(8 * 2 * Math.PI / 12) * 2);
            yPoints[8] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(8 * 2 * Math.PI / 12) * 2);
            xPoints[9] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(9 * 2 * Math.PI / 12));
            yPoints[9] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(9 * 2 * Math.PI / 12));
            xPoints[10] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(10 * 2 * Math.PI / 12) * 2);
            yPoints[10] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(10 * 2 * Math.PI / 12)) * 2;
            xPoints[11] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(11 * 2 * Math.PI / 12));
            yPoints[11] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(11 * 2 * Math.PI / 12));

            if (figura.getColorContorno() != null && figura.getColorRelleno() != null) {
                g.setStroke(Color.valueOf(figura.getColorContorno()));
                g.setFill(Color.valueOf(figura.getColorRelleno()));
                g.setLineWidth(figura.getTamanioContorno());
                g.strokePolygon(xPoints, yPoints, 12);
                g.fillPolygon(xPoints, yPoints, 12);

            } else if (figura.getColorContorno() != null) {
                g.setStroke(Color.valueOf(figura.getColorContorno()));
                g.setLineWidth(figura.getTamanioContorno());
                g.strokePolygon(xPoints, yPoints, 12);

            } else if (figura.getColorRelleno() != null) {
                g.setFill(Color.valueOf(figura.getColorRelleno()));
                g.fillPolygon(xPoints, yPoints, 12);
            }

        } else if (figura.getTipo().equals("hexa")) {
            xPoints = new double[6];
            yPoints = new double[6];

            xPoints[0] = (figura.getCoordenadaX() + figura.getTamanioFigura());
            yPoints[0] = figura.getCoordenadaY();
            xPoints[1] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(2 * Math.PI / 6));
            yPoints[1] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(2 * Math.PI / 6));
            xPoints[2] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(2 * 2 * Math.PI / 6));
            yPoints[2] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(2 * 2 * Math.PI / 6));
            xPoints[3] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(3 * 2 * Math.PI / 6));
            yPoints[3] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(3 * 2 * Math.PI / 6));
            xPoints[4] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(4 * 2 * Math.PI / 6));
            yPoints[4] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(4 * 2 * Math.PI / 6));
            xPoints[5] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(5 * 2 * Math.PI / 6));
            yPoints[5] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(5 * 2 * Math.PI / 6));

            if (figura.getColorContorno() != null && figura.getColorRelleno() != null) {
                g.setStroke(Color.valueOf(figura.getColorContorno()));
                g.setFill(Color.valueOf(figura.getColorRelleno()));
                g.setLineWidth(figura.getTamanioContorno());
                g.strokePolygon(xPoints, yPoints, 6);
                g.fillPolygon(xPoints, yPoints, 6);

            } else if (figura.getColorContorno() != null) {
                g.setStroke(Color.valueOf(figura.getColorContorno()));
                g.setLineWidth(figura.getTamanioContorno());
                g.strokePolygon(xPoints, yPoints, 6);

            } else if (figura.getColorRelleno() != null) {
                g.setFill(Color.valueOf(figura.getColorRelleno()));
                g.fillPolygon(xPoints, yPoints, 6);
            }
        } else if (figura.getTipo().equals("hepta")) {
            xPoints = new double[7];
            yPoints = new double[7];

            xPoints[0] = (figura.getCoordenadaX() + figura.getTamanioFigura());
            yPoints[0] = figura.getCoordenadaY();
            xPoints[1] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(2 * Math.PI / 7));
            yPoints[1] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(2 * Math.PI / 7));
            xPoints[2] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(2 * 2 * Math.PI / 7));
            yPoints[2] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(2 * 2 * Math.PI / 7));
            xPoints[3] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(3 * 2 * Math.PI / 7));
            yPoints[3] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(3 * 2 * Math.PI / 7));
            xPoints[4] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(4 * 2 * Math.PI / 7));
            yPoints[4] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(4 * 2 * Math.PI / 7));
            xPoints[5] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(5 * 2 * Math.PI / 7));
            yPoints[5] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(5 * 2 * Math.PI / 7));
            xPoints[6] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(6 * 2 * Math.PI / 7));
            yPoints[6] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(6 * 2 * Math.PI / 7));

            if (figura.getColorContorno() != null && figura.getColorRelleno() != null) {
                g.setStroke(Color.valueOf(figura.getColorContorno()));
                g.setFill(Color.valueOf(figura.getColorRelleno()));
                g.setLineWidth(figura.getTamanioContorno());
                g.strokePolygon(xPoints, yPoints, 7);
                g.fillPolygon(xPoints, yPoints, 7);

            } else if (figura.getColorContorno() != null) {
                g.setStroke(Color.valueOf(figura.getColorContorno()));
                g.setLineWidth(figura.getTamanioContorno());
                g.strokePolygon(xPoints, yPoints, 7);

            } else if (figura.getColorRelleno() != null) {
                g.setFill(Color.valueOf(figura.getColorRelleno()));
                g.fillPolygon(xPoints, yPoints, 7);
            }
        } else if (figura.getTipo().equals("octa")) {
            xPoints = new double[8];
            yPoints = new double[8];

            xPoints[0] = (figura.getCoordenadaX() + figura.getTamanioFigura());
            yPoints[0] = figura.getCoordenadaY();
            xPoints[1] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(2 * Math.PI / 8));
            yPoints[1] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(2 * Math.PI / 8));
            xPoints[2] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(2 * 2 * Math.PI / 8));
            yPoints[2] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(2 * 2 * Math.PI / 8));
            xPoints[3] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(3 * 2 * Math.PI / 8));
            yPoints[3] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(3 * 2 * Math.PI / 8));
            xPoints[4] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(4 * 2 * Math.PI / 8));
            yPoints[4] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(4 * 2 * Math.PI / 8));
            xPoints[5] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(5 * 2 * Math.PI / 8));
            yPoints[5] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(5 * 2 * Math.PI / 8));
            xPoints[6] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(6 * 2 * Math.PI / 8));
            yPoints[6] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(6 * 2 * Math.PI / 8));
            xPoints[7] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(7 * 2 * Math.PI / 8));
            yPoints[7] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(7 * 2 * Math.PI / 8));

            if (figura.getColorContorno() != null && figura.getColorRelleno() != null) {
                g.setStroke(Color.valueOf(figura.getColorContorno()));
                g.setFill(Color.valueOf(figura.getColorRelleno()));
                g.setLineWidth(figura.getTamanioContorno());
                g.strokePolygon(xPoints, yPoints, 8);
                g.fillPolygon(xPoints, yPoints, 8);

            } else if (figura.getColorContorno() != null) {
                g.setStroke(Color.valueOf(figura.getColorContorno()));
                g.setLineWidth(figura.getTamanioContorno());
                g.strokePolygon(xPoints, yPoints, 8);

            } else if (figura.getColorRelleno() != null) {
                g.setFill(Color.valueOf(figura.getColorRelleno()));
                g.fillPolygon(xPoints, yPoints, 8);
            }
        } else if (figura.getTipo().equals("deca")) {
            xPoints = new double[10];
            yPoints = new double[10];

            xPoints[0] = (figura.getCoordenadaX() + figura.getTamanioFigura());
            yPoints[0] = figura.getCoordenadaY();
            xPoints[1] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(2 * Math.PI / 10));
            yPoints[1] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(2 * Math.PI / 10));
            xPoints[2] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(2 * 2 * Math.PI / 10));
            yPoints[2] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(2 * 2 * Math.PI / 10));
            xPoints[3] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(3 * 2 * Math.PI / 10));
            yPoints[3] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(3 * 2 * Math.PI / 10));
            xPoints[4] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(4 * 2 * Math.PI / 10));
            yPoints[4] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(4 * 2 * Math.PI / 10));
            xPoints[5] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(5 * 2 * Math.PI / 10));
            yPoints[5] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(5 * 2 * Math.PI / 10));
            xPoints[6] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(6 * 2 * Math.PI / 10));
            yPoints[6] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(6 * 2 * Math.PI / 10));
            xPoints[7] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(7 * 2 * Math.PI / 10));
            yPoints[7] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(7 * 2 * Math.PI / 10));
            xPoints[8] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(8 * 2 * Math.PI / 10));
            yPoints[8] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(8 * 2 * Math.PI / 10));
            xPoints[9] = figura.getCoordenadaX() + (figura.getTamanioFigura() * Math.cos(9 * 2 * Math.PI / 10));
            yPoints[9] = figura.getCoordenadaY() - (figura.getTamanioFigura() * Math.sin(9 * 2 * Math.PI / 10));

            if (figura.getColorContorno() != null && figura.getColorRelleno() != null) {
                g.setStroke(Color.valueOf(figura.getColorContorno()));
                g.setFill(Color.valueOf(figura.getColorRelleno()));
                g.setLineWidth(figura.getTamanioContorno());
                g.strokePolygon(xPoints, yPoints, 10);
                g.fillPolygon(xPoints, yPoints, 10);

            } else if (figura.getColorContorno() != null) {
                g.setStroke(Color.valueOf(figura.getColorContorno()));
                g.setLineWidth(figura.getTamanioContorno());
                g.strokePolygon(xPoints, yPoints, 10);

            } else if (figura.getColorRelleno() != null) {
                g.setFill(Color.valueOf(figura.getColorRelleno()));
                g.fillPolygon(xPoints, yPoints, 10);
            }
        } else if (figura.getTipo().equals("pacman")) {

            if (figura.getColorContorno() != null && figura.getColorRelleno() != null) {
                g.setStroke(Color.valueOf(figura.getColorContorno()));
                g.setFill(Color.valueOf(figura.getColorRelleno()));
                g.setLineWidth(figura.getTamanioContorno());
                g.fillArc(figura.getCoordenadaX() + 2, figura.getCoordenadaY(), figura.getTamanioFigura(), figura.getTamanioFigura(), 370, 320, ArcType.ROUND);
                g.strokeArc(figura.getCoordenadaX(), figura.getCoordenadaY(), figura.getTamanioFigura(), figura.getTamanioFigura(), 370, 320, ArcType.ROUND);

            } else if (figura.getColorContorno() != null) {
                g.setStroke(Color.valueOf(figura.getColorContorno()));
                g.setLineWidth(figura.getTamanioContorno());
                g.strokeArc(figura.getCoordenadaX(), figura.getCoordenadaY(), figura.getTamanioFigura(), figura.getTamanioFigura(), 370, 320, ArcType.ROUND);

            } else if (figura.getColorRelleno() != null) {
                g.setFill(Color.valueOf(figura.getColorRelleno()));
                g.fillArc(figura.getCoordenadaX() + 2, figura.getCoordenadaY(), figura.getTamanioFigura(), figura.getTamanioFigura(), 370, 320, ArcType.ROUND);
            }
        } else if (figura.getTipo().equals("curva")) {
            if (figura.getCoordenadas().size() == 4) {
                List<Punto> puntosLineaCurva = figura.getCoordenadas();
                g.moveTo(puntosLineaCurva.get(0).getX(), puntosLineaCurva.get(0).getY());
                g.bezierCurveTo(
                        puntosLineaCurva.get(1).getX(), puntosLineaCurva.get(1).getY(),
                        puntosLineaCurva.get(2).getX(), puntosLineaCurva.get(2).getY(),
                        puntosLineaCurva.get(3).getX(), puntosLineaCurva.get(3).getY()
                );
                g.setStroke(Color.valueOf(figura.getColorContorno()));
                g.stroke();
                figuras.add(figura);
                curvaTemp = new Figura();
            }
        }
    }

    @FXML
    private void guardar(ActionEvent event) {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = jfc.getSelectedFile();
            ManejoArchivo.guardarFiguras(archivoSeleccionado, g, figuras);
        }
    }

    @FXML
    private void limpiar(ActionEvent event) {
        double width = g.getCanvas().getWidth();
        double height = g.getCanvas().getHeight();
        g.clearRect(0, 0, width, height);
        g.setStroke(Color.DARKCYAN);
        g.setLineWidth(3);
        g.strokeRect(0, 0, width, height);
        figuras = new ArrayList<>();
    }

    @FXML
    private void open(ActionEvent event) {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = jfc.getSelectedFile();
            List<Figura> figurasGuardas = ManejoArchivo.recuperarFiguras(archivoSeleccionado);
            for (Figura figura : figurasGuardas) {
                dibujarFigura(figura);
            }
        }
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
        g = lienzo.getGraphicsContext2D();
        double w = lienzo.getWidth();
        double h = lienzo.getHeight();

        g.setStroke(Color.DARKCYAN);
        g.setLineWidth(3);
        g.strokeRect(0, 0, w, h);
        figuras = new ArrayList<>();
    }

}
