/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controls;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Moozu-a-Kun
 */
public class UiController implements Initializable {
    
    @FXML
    StackPane parent;
    
    private double x = 0, y = 0;
    
    Stage stage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        makeDragable();
    }    
    
    private void makeDragable() {
        parent.setOnMousePressed(((event) -> {
            
            x = event.getSceneX();
            
            y = event.getSceneY();
            
        }));
        
        parent.setOnMouseDragged(((event) -> {
            
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
            
            stage.setOpacity(0.7f);
            
        }));
        
        parent.setOnDragDone(((event) -> {
            
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            stage.setOpacity(1.0f);
            
        }));
        
        parent.setOnMouseReleased(((event) -> {
            
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            stage.setOpacity(1.0f);
            
        }));
    }
    
}
