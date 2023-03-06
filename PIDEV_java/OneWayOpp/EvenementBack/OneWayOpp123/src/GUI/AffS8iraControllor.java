/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entities.AffectationOpColis;
import GUI.ModifierAffController;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.layout.HBox;
import services.AffectationService;

/**
 * FXML Controller class
 *
 * @author Meddeb sofien
 */
public class AffS8iraControllor implements Initializable {

    @FXML
    private HBox Hbox;
    @FXML
    private Label colis;
    @FXML
    private Label opp;
    @FXML
    private Label id_label;
    @FXML
    private Label lbl1;
    
    AffectationService as = new AffectationService();
    AffectationOpColis e = new AffectationOpColis();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    
    
     public void setAff(AffectationOpColis  E) {
         lbl1.setText(String.valueOf(E.getIdAff()));
         colis.setText(String.valueOf(E.getIdcolis()) );
         opp.setText(String.valueOf(E.getIdopp()));
        
      e=E;
       
    }

    @FXML
    private void ModifierAff(ActionEvent event) throws IOException {
        ModifierAffController.getIdd(e);
            
             try {
          Parent loader = FXMLLoader.load(getClass().getResource("ModifierAff.fxml"));
          //Parent root = loader.load();
         
              lbl1.getScene().setRoot(loader);
        
            
        } catch (NullPointerException ex) {
            System.out.println("error" + ex.getMessage());
        }
           
    }

    @FXML
    private void DeleteAff(ActionEvent event) throws IOException {
        AffectationOpColis a =new AffectationOpColis();
         a.setIdAff(Integer.parseInt(lbl1.getText()));
        try {
            
              Alert alert = new Alert(Alert.AlertType.WARNING);

              alert.setTitle("confirmation Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Voulez vous supprimer cet Affectation!");
              ButtonType cancelBtn = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
             alert.getButtonTypes().setAll(cancelBtn, ButtonType.OK);
              Optional<ButtonType> result = alert.showAndWait();
           
           if (result.isPresent() && result.get() == ButtonType.OK) {
    // User clicked OK 
           as.supprimer(a);
} else {
    // User clicked cancel or closed the dialog
               System.out.println("Suppression Annuler");
    
}
            Parent loader = FXMLLoader.load(getClass().getResource("AfficherAff.fxml"));
            id_label.getScene().setRoot(loader);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
