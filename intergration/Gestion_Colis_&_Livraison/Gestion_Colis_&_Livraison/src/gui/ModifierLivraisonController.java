/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Livraison;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import services.ColisService;
import services.LivraisonService;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class ModifierLivraisonController implements Initializable {

    @FXML
    private ImageView logo;
    @FXML
    private ChoiceBox<String> livreurtf;
    @FXML
    private ComboBox<String> etattf;
    @FXML
    private Label etat;

    int idColis;
    Livraison liv = new Livraison();
    LivraisonService LS = new LivraisonService();
    ColisService CS = new ColisService();
    private static int id;
    private String [] ETAT = {"En Cours","Terminé"};
    
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
        liv=LS.TrouverLivraisonById(id);
        CS.TrouverColisById(liv.getId_colis());
        String ll = LS.TrouverLivreurNameByColisId(liv.getId_colis());
        
        livreurtf.setValue(ll);
        etattf.setValue(liv.getEtat());
        
        
        
        
    }    

     public static int getIdd(Livraison l) {
        
        id = l.getId_livraison();
          System.out.println(id);
   
        return id;
        
    }
     
     
    
    @FXML
    private void ModifierColis(ActionEvent event) {
        
        int ok;
            ok=LS.TrouverLivreurIDByName(livreurtf.getValue());
           Livraison Livr = new Livraison();
            Livr.setId_livraison(id);      
            Livr.setId_livreur(ok);
            Livr.setId_colis(liv.getId_colis());
            Livr.setEtat(etattf.getValue());
           
            try {
                LS.modifier(Livr);
                    showMessageDialog(null, "Livreur Modifier Avec Succès");
            } catch (SQLException ex) {
                Logger.getLogger(ModifierLivraisonController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
            
        }
        
            
            
        
        
        
    

    @FXML
    private void Voirlivraison(ActionEvent event) {
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
