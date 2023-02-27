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
import javafx.scene.control.Alert;
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
    
    }    

   
    
    
        
    

    @FXML
    private void supprimerreponse(ActionEvent event) throws IOException {
        Reponse Rp =new Reponse();
    Rp.setId_rep(Integer.parseInt(IDlabel.getText()));
        try {
            RS.supprimer(Rp);
              Alert alert = new Alert(Alert.AlertType.INFORMATION);

              alert.setTitle("Information Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Reponse supprimer avec succés!");

              alert.show();
            Parent loader = FXMLLoader.load(getClass().getResource("Afficher_reponse.fxml"));
            Textlabel.getScene().setRoot(loader);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    

    @FXML
    private void modifierreponse(ActionEvent event) throws IOException {
                Reponse Rp =new Reponse();
    Rp.setId_rep(Integer.parseInt(IDlabel.getText()));
    Parent loader = FXMLLoader.load(getClass().getResource("Ajouter_reponse.fxml"));
    
            Textlabel.getScene().setRoot(loader);
        
    }

   /* @FXML
    private void modidierreponse(ActionEvent event) {
    }*/
    
}


