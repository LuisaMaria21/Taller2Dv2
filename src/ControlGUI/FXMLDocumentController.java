/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlGUI;

import Modelo.punto2D;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Window;
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
    private void obtenerCoordenadas(MouseEvent event) {
        coordenadaX = event.getX();
        coordenadaY = event.getY();

        punto2D objp = new punto2D(coordenadaX, coordenadaY);

        System.out.println("Punto " + objp.toString());

    }

    @FXML
    private void file(ActionEvent event) {
//        Window stage=
    }

    @FXML
    private void open(ActionEvent event) {

    }

    @FXML
    private void help(ActionEvent event) {

        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "AYUDA \n"
                + "1.Escoja la figura que quiere realizar \n"
                + "2.Escoja el color de relleno de la figura \n"
                + "3.De ser una figura con contorno, escoja el relleno del contorno \n"               
                + "4.Haga clic en el lienzo en el lugar donde quiere que se dibuje la figura \n"
                + "5.Haga clic en X para guardar, escoja su carpeta de preferencia \n"
                + "6.Haga clic en X para recuperar un archivo guardado"); 

    }

    @FXML
    private void comboFigura(ActionEvent event) {
        ObservableList<String> figuras = FXCollections.observableArrayList();
        ComboBox comboFigura = new ComboBox();
        comboFigura.getItems().addAll("Estrella 5 puntas", "Estrella 6 puntas",
                "Hexagono", "Heptagono", "Octagono", "Decagono", "Pac-man",
                "Trazo curva");
        ComboBox<String> cbx = new ComboBox<>(figuras);

//        String figura = (String) comboFigura.getValue();
//        if (figura.equals("Estrella 5 puntas")) {
//
//        } else if (figura.equals("Estrella 6 puntas")) {
//
//        } else if (figura.equals("Hexagono")) {
//            x = new double[6];
//            y = new double[6];
//
//            listap = new LinkedList<>();
//            x[0] = (coordenadaX + r);
//            y[0] = coordenadaY;
//            x[1] = coordenadaX + (r * Math.cos(2 * Math.PI / 6));
//            y[1] = coordenadaY - (r * Math.sin(2 * Math.PI / 6));
//            x[2] = coordenadaX + (r * Math.cos(2 * 2 * Math.PI / 6));
//            y[2] = coordenadaY - (r * Math.sin(2 * 2 * Math.PI / 6));
//            x[3] = coordenadaX + (r * Math.cos(3 * 2 * Math.PI / 6));
//            y[3] = coordenadaY - (r * Math.sin(3 * 2 * Math.PI / 6));
//            x[4] = coordenadaX + (r * Math.cos(4 * 2 * Math.PI / 6));
//            y[4] = coordenadaY - (r * Math.sin(4 * 2 * Math.PI / 6));
//            x[5] = coordenadaX + (r * Math.cos(5 * 2 * Math.PI / 6));
//            y[5] = coordenadaY - (r * Math.sin(5 * 2 * Math.PI / 6));
//            g.setStroke(Color.BLUE);
//            g.setLineWidth(3);
//            g.strokePolygon(x, y, 6);
//        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        // TODO
//        filechooser.setInitialDirectory(new File(pathname "C:\\temp"));
        g = lienzo.getGraphicsContext2D();
        r = 100;
        mapaEjemplo = new HashMap<>();
        double w = lienzo.getWidth();
        double h = lienzo.getHeight();
    }

}
