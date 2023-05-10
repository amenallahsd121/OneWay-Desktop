/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entities.Evenement;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import services.EvenementService;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class EventviewController implements Initializable {

    @FXML
    private Label nom;
    @FXML
    private Label id_label;
    @FXML
    private Label awards;
    @FXML
    private Label description;
    @FXML
    private Label duree;

    Evenement e = new Evenement();
     EvenementService es = new EvenementService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void SetEvent(Evenement E)
    {
       
        nom.setText(E.getNom());
        awards.setText(E.getAwards());
        description.setText(E.getDescription());
        duree.setText(E.getDate_debut() + "<==>" + E.getDate_fin());
        id_label.setText(String.valueOf(E.getId_event()));        
        e=E;
        
    }

    @FXML
    private void Update(ActionEvent event) throws IOException {
        GUI.ModifierEvenementController.getIdd(e);
            
             try {
          Parent loader = FXMLLoader.load(getClass().getResource("ModifierEvenement.fxml"));
          //Parent root = loader.load();
         
              awards.getScene().setRoot(loader);
        
            
        } catch (NullPointerException ex) {
            System.out.println("error" + ex.getMessage());
        }
        
    }

    @FXML
    private void Delete(ActionEvent event) {
        
         try {
            
            
            Alert alert = new Alert(Alert.AlertType.WARNING);

              alert.setTitle("confirmation Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Voulez vous supprimer !");
              ButtonType cancelBtn = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
             alert.getButtonTypes().setAll(cancelBtn, ButtonType.OK);
              Optional<ButtonType> result = alert.showAndWait();
           
           if (result.isPresent() && result.get() == ButtonType.OK) {
    // User clicked OK 
            es.supprimer(e);
} else {
    // User clicked cancel or closed the dialog
               System.out.println("Suppression Annuler");
    
}
         
            Parent loader = FXMLLoader.load(getClass().getResource("BackOffice.fxml"));
            description.getScene().setRoot(loader);
      
        
        } catch (Exception e) {
        }
  
         
         
        
    }

     
}
