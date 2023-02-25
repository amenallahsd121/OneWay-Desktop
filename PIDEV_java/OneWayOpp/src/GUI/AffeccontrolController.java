/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.AffectationOpColis;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import services.AffectationService;

/**
 * FXML Controller class
 *
 * @author Meddeb sofien
 */
public class AffeccontrolController implements Initializable {

    @FXML
    private Label idcolislabel;
    @FXML
    private Label idoplabel;
    @FXML
    private Button supbtn;
    @FXML
    private Button modifierbtn;
  AffectationService as = new AffectationService();
    /**
     * Initializes the controller class.
     */
    
    AffectationOpColis e = new AffectationOpColis();
    @FXML
    private Label id_label;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void setAff(AffectationOpColis  E) {
         id_label.setText(String.valueOf(E.getIdAff()));
         idcolislabel.setText(String.valueOf(E.getIdcolis()) );
         idoplabel.setText(String.valueOf(E.getIdopp()));
        
      e=E;
       
    }

    @FXML
    private void supprimerAffectation(ActionEvent event) throws IOException {
        
        AffectationOpColis a =new AffectationOpColis();
         a.setIdAff(Integer.parseInt(id_label.getText()));
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
           as.supprimer(a);
} else {
    // User clicked cancel or closed the dialog
               System.out.println("Suppression Annuler");
    
}
            Parent loader = FXMLLoader.load(getClass().getResource("AfficherAffectation.fxml"));
            id_label.getScene().setRoot(loader);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @FXML
    private void modifierAffectation(ActionEvent event) throws IOException {
        
        try {
          Parent loader = FXMLLoader.load(getClass().getResource("AjouterAffectation.fxml"));
         
          AjouterAffectationController.getIdd(e.getIdAff());
                         
                 

             id_label.getScene().setRoot(loader);
        
            
        } catch (NullPointerException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }
    
}
