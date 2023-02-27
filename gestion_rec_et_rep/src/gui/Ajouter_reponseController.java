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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.R;


/**
 * FXML Controller class
 *
 * @author hp
 */
public class Ajouter_reponseController implements Initializable {

    //private TextField id_reclamationtf;
    @FXML
    private TextField text_reponsetf;

     @FXML
    private ComboBox<Integer> id_reclamation;
    @FXML
    private ComboBox<Integer> id_client;
    
    /**
     * Initializes the controller class.
     */
    
    ReponseService RS = new ReponseService();
    Reponse Rp = new Reponse();
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<Integer> list = FXCollections.observableArrayList();
        list = RS.getidclient();
        id_client.setItems(list);
        ObservableList<Integer> l = FXCollections.observableArrayList();
        l= RS.getidRec();
        id_reclamation.setItems(l);
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
           Rp.setId_user(id_client.getValue());
           Rp.setId_rec(id_reclamation.getValue());
           
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
        if (text_reponsetf.getText().length()<3)
            return false;
       
        return true;
    }
    private static int idd;
    public static int getid(int id){
        idd=id;
        return idd;
    }

    @FXML
    private void Modifier(ActionEvent event) {
     //    ReponseService RS = new ReponseService();
    Reponse e = new Reponse();
          e.setId_rep(idd);
          e.setId_rec(id_reclamation.getValue());
          e.setId_user(id_client.getValue());
         e.setText_rep(text_reponsetf.getText());
    //     id.setText(String.valueOf(idd)); 
         
        
          
   
          
           try {
               
               RS.modifier(e);
               Alert alert = new Alert(Alert.AlertType.INFORMATION);

              alert.setTitle("Information Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Reponse Modifier avec succés!");

              alert.show();
            
               
           } catch (SQLException ex) {
            System.out.println(ex.getMessage());
      }
        
        
    }
    }
    


    

