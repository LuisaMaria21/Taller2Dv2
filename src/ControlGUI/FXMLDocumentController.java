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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
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
    
    LinkedList<punto2D> listap;
    HashMap<String, LinkedList<punto2D>> mapaEjemplo;

    @FXML
    private Canvas lienzo;

    @FXML
    private Label labelContorno;

    @FXML
    private Label labelRelleno;

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
    private void edit(ActionEvent event) {

    }

    @FXML
    private void help(ActionEvent event) {

    }

    @FXML
    private void comboFigura(ActionEvent event) {
        ComboBox comboFigura = new ComboBox();
        comboFigura.getItems().addAll("Estrella 5 puntas", "Estrella 6 puntas",
                "Hexagono", "Heptagono", "Octagono", "Decagono", "Pac-man",
                "Trazo curva");
        
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        filechooser.setInitialDirectory(new File(pathname "C:\\temp"));
        g = lienzo.getGraphicsContext2D();
        mapaEjemplo = new HashMap<>();
        double w = lienzo.getWidth();
        double h = lienzo.getHeight();
    }

}
