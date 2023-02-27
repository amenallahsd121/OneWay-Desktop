/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.java.swing.plaf.windows.resources.windows;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import entities.Livreur;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import static javafx.scene.input.KeyCode.L;
import javafx.scene.layout.HBox;
import services.LivreurService;


/**
 * FXML Controller class
 *
 * @author amens
 */
public class LivreurViewController implements Initializable {

    @FXML
    private Label cintf;
    @FXML
    private Label prenomtf;
    @FXML
    private Label nomtf;
    @FXML
    private Label vehiculetf;

    Livreur livreur = new Livreur();
    LivreurService LS = new LivreurService();
    @FXML
    private HBox Hbox;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     
        
    }    

    
    
    
    ////////////////////////////////////////////////////// AJOUTER LIVREUR ////////////////////////////////////////////////////////////

    
    
    
    ////////////////////////////////////////////////////// MODIFIER LIVREUR ////////////////////////////////////////////////////////////
    
    
    @FXML
    private void UpdateLivreur(ActionEvent event) {
        
        ModifierLivreurController.getIdd(livreur);
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierLivreur.fxml"));
            Parent root = loader.load();
            vehiculetf.getScene().setRoot(root);

        } catch (Exception e) {
        }
        
    }

    
    ////////////////////////////////////////////////////// SUPPRIMER LIVREUR ////////////////////////////////////////////////////////////
    
    
    @FXML
    private void DeleteLivreur(ActionEvent event)  {
        
        try {
            LS.supprimer(livreur);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherLivreur.fxml"));
            Parent root = loader.load();
            vehiculetf.getScene().setRoot(root);
        
        } catch (Exception e) {
        }
        
   
    }
    
    
    /////////////////////////////////////////////////////// REMPLIR LIVREUR ///////////////////////////////////////////////////////////
    
    public void SetLivreur(Livreur L)
    {
       
        cintf.setText(L.getCin_livreur());
        prenomtf.setText(L.getPrenom());
        nomtf.setText(L.getNom());
        vehiculetf.setText(L.getVehicule());
        livreur=L;
        
    }
    
}
