/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import entities.Reclamation;
import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import services.ReclamationService;
/**
 * FXML Controller class
 *
 * @author hp
 */
public class Ajouter_reclamationController implements Initializable {

    @FXML
    private TextField sujettf;
    @FXML
    private TextField texttf;
ReclamationService Rs = new ReclamationService();
    @FXML
    private Button modifiebtnn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Rs.recherche(idd);
    }    

    @FXML
    private void ajouter(ActionEvent event) throws SQLException {
       // try {
       
       if (controleDeSaisie()) {     /////////////// declaration controle se saisie /////////////////////////////
           Reclamation R = new Reclamation();
           //  R.setId_rec(idd);
           R.setText_rec(texttf.getText());
           R.setSujet(sujettf.getText());
          
            Rs.ajouter(R);
            System.out.println("Reclamation  Ajouté Avec Succès");
            
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
       
        /*catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
    }*/

       
       
    }
   
    

    @FXML
    private void afficher(ActionEvent event) {
         try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("afficher_reclamation.fxml"));
//            Parent root = (Parent)loader.load();
//            Afficher_reclamationController controller = (Afficher_reclamationController)loader.getController();
//           
//            sujettf.getScene().setRoot(root);
//            texttf.getScene().setRoot(root);

        Parent loader = FXMLLoader.load(getClass().getResource("afficher_reclamation.fxml"));
        texttf.getScene().setRoot(loader);
            
           
             }
         
         catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }
    private static int idd;
    public static int getid(int id){
        idd=id;
        return idd;
    }
    
    
    private boolean controleDeSaisie() {
        if (sujettf.getText().length()<3)
            return false;
        if (texttf.getText().length()<3)
            return false;
        return true;
    }

    @FXML
    private void modifierRec(ActionEvent event) {
        
        
        
       
          Reclamation e = new Reclamation();
          e.setId_rec(idd);
          e.setSujet(sujettf.getText());
          e.setText_rec(texttf.getText());
         
    //     id.setText(String.valueOf(idd)); 
         
        
          
   
          
           try {
               
               Rs.modifier(e);
               Alert alert = new Alert(AlertType.INFORMATION);

              alert.setTitle("Information Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Reclamation Modifier avec succés!");

              alert.show();
            
               
           } catch (SQLException ex) {
            System.out.println(ex.getMessage());
      }
        
        
    }
    
}
    

