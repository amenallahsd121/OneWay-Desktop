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
import javafx.scene.Parent;
import services.ReclamationService;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class Modifier_reclamationController implements Initializable {

    @FXML
    private TextField sujettf;
    @FXML
    private TextField texttf;
    @FXML
    private TextField IDFtf;
 ReclamationService RS = new ReclamationService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    

    @FXML
    private void modifier(ActionEvent event) {
        
        try {
            Reclamation r = new Reclamation();
           
           // r.setId_rec(Integer.parseInt(IDFtf.getText()));
            //r.setId_rec(idd);
            r.setSujet(sujettf.getText());
            r.setText_rec(texttf.getText());
            
            RS.modifier(r);
            System.out.println("reclamation Modifié Avec Succès");
        }
       
        catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
    }
        
    }

    @FXML
    private void afficher(ActionEvent event) {
        
             try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Afficher_reclamation.fxml"));
            Parent root = (Parent)loader.load();
            Afficher_reclamationController controller = (Afficher_reclamationController)loader.getController();
           
            texttf.getScene().setRoot(root);
            sujettf.getScene().setRoot(root);
            IDFtf.getScene().setRoot(root);
           
             }
         
         catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
       
       
    }
        
    }
    

