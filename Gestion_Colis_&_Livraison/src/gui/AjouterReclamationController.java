/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Reclamation;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import static javax.swing.JOptionPane.showMessageDialog;
import services.ReclamationService;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class AjouterReclamationController implements Initializable {

    @FXML
    private TextField Texte_reclamation;
    @FXML
    private ChoiceBox<String> Sujet;
    
    ReclamationService RS = new ReclamationService();
     
     List<String> grosmot = Arrays.asList("merde","fuck","shit","con","connart","putain","pute","chier","bitch","bèullshit","bollocks","damn","putin");
     List<String> sujiette = Arrays.asList  ("Service","Livreur","Retard de livraison","Autres ");
     
      
      
      
      
private Reclamation  V;
Reclamation REC = new Reclamation();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Sujet.getItems().addAll(sujiette);
    
    }    

    @FXML
    private void AjouterRedclamation(ActionEvent event) throws SQLException {
          
        try {
             
         
           Reclamation r = new Reclamation();
           
            
            r.setId_user(1);
            r.setSujet(Sujet.getValue());
            r.setText_rec(Texte_reclamation.getText());
           
            RS.ajouter(r);
            
            
            V= RS.Verifrec(grosmot);        
                     if (V != null )
                    {
                        
                        RS.supprimer (V);
                        showMessageDialog(null, "Reclamation contient des mots agressifs" );
                        
                    }
                    else 
                        
                     showMessageDialog(null, "Reclamation Ajoutée Avec Succès" );    
            
            } 
            

        catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
            
           
    }
         
        
    }

    @FXML
    private void listeREC(ActionEvent event) {
         try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FrontOffice.fxml"));
            Parent root = (Parent)loader.load();
            FrontOfficeController controller = (FrontOfficeController)loader.getController();
            Sujet.getScene().setRoot(root);
         
        
        } catch (Exception e) {
             System.out.println(e);
                
        }
    }
    
}
