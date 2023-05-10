/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Livreur;
import entities.Reclamation;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import static javax.swing.JOptionPane.showMessageDialog;
import services.ReclamationService;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class ModifierReclamationController implements Initializable {

    @FXML
    private TextField Texte_reclamation;
    @FXML
    private TextField Sujet;

    ReclamationService RS = new ReclamationService();
    Reclamation r = new Reclamation();
   int id_user;
    
    
     private static int id;
     public static int getIdd(Reclamation R) {
        
        id = R.getId_rec();
         
   
        return id;
        
    }
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         r=RS.recherche(id);
         Texte_reclamation.setText(r.getText_rec());
         Sujet.setText(r.getSujet());
         id_user=r.getId_user();
        
    }    

    @FXML
    private void ModifierReclamation(ActionEvent event) {
        
             Reclamation recla = new Reclamation();
         try {
            recla.setId_rec(id);   
             System.out.println(id_user);
            recla.setId_user(id_user);
            recla.setText_rec(Texte_reclamation.getText());
            recla.setSujet(Sujet.getText());
            RS.modifier(recla);
            showMessageDialog(null, "Reclamation Modifier Avec Succès");
            

        } catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        }
        
        
        
    }

    @FXML
    private void Listerec(ActionEvent event) {
        
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
