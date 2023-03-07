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
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import entities.Livraison;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import services.LivraisonService;
/**
 * FXML Controller class
 *
 * @author amens
 */
public class LivraisonViewController implements Initializable {

    @FXML
    private HBox Hbox;
    @FXML
    private Label nomctf;
    @FXML
    private Label prixcolis;
 

    String NomLivreur;
    int id_client;
    float prixx; 
    String nomClient;
    LivraisonService LS = new LivraisonService();
    Livraison liv = new Livraison();
    @FXML
    private Label livreurtf;
    @FXML
    private Label etattf;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
    }    

    @FXML
    private void UpdateLivraison(ActionEvent event) {
        
         ModifierLivraisonController.getIdd(liv);
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierLivraison.fxml"));
            Parent root = loader.load();
            etattf.getScene().setRoot(root);

        } catch (Exception e) {
        }
    }

    @FXML
    private void DeleteLivraison(ActionEvent event) {
        
         try {
            LS.supprimer(liv);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BackOffice.fxml"));
              Parent root = (Parent)loader.load();
              BackOfficeController controller = (BackOfficeController)loader.getController(); 
             prixcolis.getScene().setRoot(root);
        
        } catch (Exception e) {
        }
        
    }

    
    
        public void SetLivraison(Livraison L)
    {
        
        
        
      NomLivreur=LS.TrouverLivreurNameByColisId(L.getId_livreur());
      prixx = LS.TrouverPrixByIdColis(L.getId_colis());
      id_client=LS.TrouverIdClientByColisId(L.getId_colis());
      nomClient=LS.TrouverClientNameById(id_client);
       
       ///////////////////////////////////////////

       
        
        ////////////////////////////////////////////
        
        nomctf.setText(nomClient);
        livreurtf.setText(NomLivreur);
        prixcolis.setText(Double.toString(prixx)+" DT");
        etattf.setText(L.getEtat());
       
        liv=L;
        
    }
        
}
