/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Reclamation;
import entities.Reponse;
import java.io.IOException;
import services.ReponseService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.R;


/**
 * FXML Controller class
 *
 * @author hp
 */
public class Ajouter_reponseController implements Initializable {

    @FXML
    private TextField id_reclamationtf;
    @FXML
    private TextField text_reponsetf;

    /**
     * Initializes the controller class.
     */
    
    ReponseService RS = new ReponseService();
    Reponse Rp = new Reponse();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void afficher(ActionEvent event) {
        
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Afficher_reponse.fxml"));
            Parent root = (Parent)loader.load();
            Afficher_reponseController controller = (Afficher_reponseController)loader.getController();
           
            text_reponsetf.getScene().setRoot(root);
         
            
           
             }
         
         catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }
    

    @FXML
    private void ajouter(ActionEvent event) throws SQLException {
       //  try {
           if (controleDeSaisie()) {        /////////////// declaration controle se saisie //////////////////////////

           Rp.setText_rep(text_reponsetf.getText());
           Rp.setId_rec(Integer.parseInt(id_reclamationtf.getText()));
           
            RS.ajouter(Rp);
            System.out.println("Reponse  Ajouté Avec Succès");
            ///////////////// trité le controle se saisie///////////
            Alert al = new Alert(Alert.AlertType.INFORMATION);
             al.setAlertType(Alert.AlertType.INFORMATION);
             al.setHeaderText("Valider");
             al.setContentText("les informations ont été ajoutées avec succès");
             al.show(); 
             //((Node)(event.getSource())).getScene().getWindow().hide();
             
             }else{
         
            Alert al = new Alert(Alert.AlertType.ERROR);
             al.setAlertType(Alert.AlertType.ERROR);
             al.setHeaderText("erreur!");
             al.setContentText("verifier les champs!");
             al.show();
            ///////////////// fin le controle se saisie///////////
        }
       
       /* catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
    }
*/ 
    
    }
    
    
    
    private boolean controleDeSaisie() {
        if (text_reponsetf.getText().length()<10)
            return false;
        /*if (marquetf.getText().length()<3)
            return false;*/
        return true;
    }
    
}

    

