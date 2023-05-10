/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class SousBackOfficeController implements Initializable {

    
    @FXML
    private BorderPane bp2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    private void loadPage(String page)
    {
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(BackOfficeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        bp2.setCenter(root);
    }
    
    
    
    @FXML
    private void AfficherColis(ActionEvent event) {
        loadPage("AfficherColisBack");
    }

    @FXML
    private void AfficherLivraison(ActionEvent event) {
        loadPage("AfficherLivraison");
    }
    
}
