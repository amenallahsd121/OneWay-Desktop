/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FrontOfficeController implements Initializable {

    @FXML
    private BorderPane bp;
    private AnchorPane paneMain;
    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
       
    }  
    
    
    
    
    
      private static int id;
      public static int getIdd(utilisateur user ) {
        
        id = user.getId();
   
   
        return id;
         
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
    private void GoReclamation(ActionEvent event) {
        
        gui.AfficherReclamationFrontController.getIdd(id);
         loadPage("AfficherReclamationFront");
    }

    @FXML
    private void GoOffreDemande(ActionEvent event) {
         loadPage("OffreFront");
    }

    @FXML
    private void GoEvenement(ActionEvent event) {
       loadPage("AfficherEventFront"); 
    }

    @FXML
    private void GoOpportunité(ActionEvent event) {
              loadPage("AfficherOpFront");
    }


    @FXML
    private void GoColis(ActionEvent event) {
         gui.AfficherColisFrontController.getIdd(id);
        loadPage("AfficherColisFront"); 
        
        
    }

    @FXML
    private void GoSignOut(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("interface.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root,900,610);
                stage.setScene(scene);
                stage.show();  
    }
    
}
