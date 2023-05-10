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
import services.ReponseService;
import entities.Reponse;
import services.ReclamationService;
import entities.Reclamation;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class AjouterReponseController implements Initializable {

    @FXML
    private TextField reponse;

          private static int id; 
          
          
          public static int getIdRec (Reclamation Rec) {
          id = Rec.getId_rec();
          System.out.println(id);
          return id;
        
          }
          
          ReponseService RS = new ReponseService();
          
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void repondre(ActionEvent event) {
        
        Reponse R = new Reponse();
        try {
             
            
            
            
            R.setId_rec(id);
            R.setText_rep(reponse.getText());
            
            RS.ajouter(R);
                     showMessageDialog(null, "Reponse Envoyé" );  
                     }
        
        catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
    }
        
        
    }

    @FXML
    private void Menu(ActionEvent event) {
         try {
         
              FXMLLoader loader = new FXMLLoader(getClass().getResource("BackOffice.fxml"));
              Parent root = (Parent)loader.load();
              BackOfficeController controller = (BackOfficeController)loader.getController();
                 reponse.getScene().setRoot(root);
        
        } catch (Exception e) {
             System.out.println(e);
        
        
        
    }
    
}
}

