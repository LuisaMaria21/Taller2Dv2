/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlGUI;import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 *
 * @author luisa
 */
public class FXMLDocumentController implements Initializable {
    
    
    
    @FXML
    private Canvas lienzo;
    
    GraphicsContext g;
    FileChooser filechooser=new FileChooser();
    
    @FXML
    private void File(ActionEvent event) {
//        Window stage=
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        filechooser.setInitialDirectory(new File(pathname "C:\\temp"));
        g = lienzo.getGraphicsContext2D();
    }    
    
}
