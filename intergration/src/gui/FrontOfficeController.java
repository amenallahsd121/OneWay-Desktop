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
 * @author hp
 */
public class FrontOfficeController implements Initializable {

    @FXML
    private BorderPane bp;

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
            Logger.getLogger(FrontOfficeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        bp.setCenter(root);
    }
    
    

    @FXML
    private void GoClient(ActionEvent event) {
    }

    @FXML
    private void GoAdmins(ActionEvent event) {
    }

    @FXML
    private void GoRelais(ActionEvent event) {
    }

    @FXML
    private void GoReclamation(ActionEvent event) {
         loadPage("AfficherReclamationFront");
    }

    @FXML
    private void GoOffreDemande(ActionEvent event) {
    }

    @FXML
    private void GoEvenement(ActionEvent event) {
    }

    @FXML
    private void GoOpportunité(ActionEvent event) {
    }

    @FXML
    private void GoVehicule(ActionEvent event) {
    }

    @FXML
    private void GoLivreur(ActionEvent event) {
    }

    @FXML
    private void GoColis(ActionEvent event) {
        
        loadPage("AfficherColisFront"); 
        
    }

    @FXML
    private void GoSignOut(ActionEvent event) {
    }
    
}
