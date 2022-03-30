/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase Main de la aplicacion
 * 
 ** @author andres_fel.acosta@uao.edu.co Andres Felipe Acosta lozada 2201212
 * luisa_maria.cuero@uao.edu.co Luisa María Cuero Ampudia 2195064
 * julieta.lara@uao.edu.co Julieta Lara Romero 2200619
 * juan_fernando.aldana@uao.edu.co Juan Fernando Aldana 2201173
 * @date 29 Marzo 2022
 * @version 1.0
 */
public class Taller2Dv2 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
