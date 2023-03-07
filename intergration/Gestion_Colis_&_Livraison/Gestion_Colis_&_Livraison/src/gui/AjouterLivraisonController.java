/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import static javax.swing.JOptionPane.showMessageDialog;
import services.LivraisonService;
import entities.Livraison;
import entities.Colis;


/**
 * FXML Controller class
 *
 * @author amens
 */
public class AjouterLivraisonController implements Initializable {

    @FXML
    private ChoiceBox<String> livreurtf;
    @FXML
    private ComboBox<String> etattf;
    @FXML
    private Label etat;
    
    
    private String [] ETAT = {"En Cours","Terminé"};
    private static int id; 
    Livraison liv = new Livraison();
    LivraisonService LS = new LivraisonService();
         
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////
    
    
         public static int getIdColis(Colis l) {
        
          id = l.getId();
          System.out.println(id);
   
        return id;
        
    }
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         etattf.getItems().addAll(ETAT);
         ObservableList<String> listlivreur = FXCollections.observableArrayList();
        listlivreur=LS.getlivreurname();
        livreurtf.setItems(listlivreur);  
         
         
         
                 }    

    @FXML
    private void AffecterColis(ActionEvent event) {
         int a = LS.TrouverLivreurIDByName(livreurtf.getValue());
         try {
             
            
            
            liv.setId_livreur(a);
            liv.setId_colis(id); 
            liv.setEtat(etattf.getValue());
            LS.ajouter(liv);
                     showMessageDialog(null, "Colis Affecté Avec Succès" );  
                     }
        
        catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
    }
        
    }

    @FXML
    private void VoirColis(ActionEvent event) {
         try {
         
              FXMLLoader loader = new FXMLLoader(getClass().getResource("BackOffice.fxml"));
              Parent root = (Parent)loader.load();
              BackOfficeController controller = (BackOfficeController)loader.getController();
                 etat.getScene().setRoot(root);
        
        } catch (Exception e) {
             System.out.println(e);
                
        }
    }
    
}
