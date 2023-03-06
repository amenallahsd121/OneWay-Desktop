/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entities.Evenement;
import GUI.ModifierEvenementController;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import services.EvenementService;

/**
 * FXML Controller class
 *
 * @author Meddeb sofien
 */
public class EventS8iraControllor implements Initializable {

    @FXML
    private HBox Hbox;
    @FXML
    private Label nom;
    @FXML
    private Label duree;
    @FXML
    private Label awards;
    @FXML
    private Label description;
     Evenement e = new Evenement();
     EvenementService es = new EvenementService();
    @FXML
    private Label id_label;
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ModifierEvent(ActionEvent event) throws IOException {
            
         
            ModifierEvenementController.getIdd(e);
            
             try {
          Parent loader = FXMLLoader.load(getClass().getResource("ModifierEvenement.fxml"));
          //Parent root = loader.load();
         
              awards.getScene().setRoot(loader);
        
            
        } catch (NullPointerException ex) {
            System.out.println("error" + ex.getMessage());
        }
           
           
    }

    @FXML
    private void DeleteEvent(ActionEvent event) throws IOException {
      Evenement e =new Evenement();
    e.setId_event(Integer.parseInt(id_label.getText()));
        try {
            
              Alert alert = new Alert(Alert.AlertType.WARNING);

              alert.setTitle("confirmation Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Voulez vous supprimer cet Evenement!");
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
            Parent loader = FXMLLoader.load(getClass().getResource("afficherEvenement.fxml"));
            nom.getScene().setRoot(loader);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public void SetEvent(Evenement E)
    {
       
        nom.setText(E.getNom());
        awards.setText(E.getAwards());
        description.setText(E.getDescription());
        duree.setText(E.getDate_debut() + " -- " + E.getDate_fin());
         id_label.setText(String.valueOf(E.getId_event()));        
        e=E;
        
    }
    


    
    
   
    
}
