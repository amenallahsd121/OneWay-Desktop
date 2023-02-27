/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/*import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;*/




import entities.Reclamation;
import entities.Reponse;
import entities.Reponse;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import gui.Afficher_reclamationController;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import services.ReponseService;



/**
 * FXML Controller class
 *
 * @author hp
 */
public class REPController implements Initializable {

    
    ReponseService RS = new ReponseService();
    @FXML
    private Button modifierbtn;
    @FXML
    private Button supprimerbtn;
    
    @FXML
    private Label Textlabel;
    @FXML
    private Label IDlabel;
    @FXML
    private Label ID_reclabel;
    @FXML
    private Label labelUser;
    
   Reponse r =new Reponse();
   
    /**
     * Initializes the controller class.
     */
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setReponse(Reponse  Rp) {
     
       Textlabel.setText(Rp.getText_rep());
     ID_reclabel.setText(String.valueOf(Rp.getId_rec()));
    
       IDlabel.setText(String.valueOf(Rp.getId_rep()));
        labelUser.setText(String.valueOf(Rp.getId_user()));
        r=Rp;
    }    

   
    
    
        


    @FXML
    private void supprimerreponse(ActionEvent event) throws IOException, SQLException {
        Reponse Rp =new Reponse();
    Rp.setId_rep(Integer.parseInt(IDlabel.getText()));
        try {
            



      Alert alert = new Alert(Alert.AlertType.WARNING);

              alert.setTitle("confirmation Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Voulez vous supprimer cet Reponse!");
              ButtonType cancelBtn = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
             alert.getButtonTypes().setAll(cancelBtn, ButtonType.OK);
              Optional<ButtonType> result = alert.showAndWait();
           
           if (result.isPresent() && result.get() == ButtonType.OK) {
    // User clicked OK 
           RS.supprimer(Rp);
} else {
    // User clicked cancel or closed the dialog
               System.out.println("Suppression Annuler");
           }
           Parent loader = FXMLLoader.load(getClass().getResource("Afficher_reponse.fxml"));
           Textlabel.getScene().setRoot(loader);
           
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    

    @FXML
    private void modifierreponse(ActionEvent event) throws IOException {
                
    // Rp.setId_rep(Integer.parseInt(IDlabel.getText()));
    Parent loader = FXMLLoader.load(getClass().getResource("Ajouter_reponse.fxml"));
             // Ajouter_reclamationController.getid(r.getId_rec());
           Ajouter_reponseController.getid(r.getId_rep());
    
            Textlabel.getScene().setRoot(loader);
        
    }

   /* @FXML
    private void modidierreponse(ActionEvent event) {
    }*/
    
}


