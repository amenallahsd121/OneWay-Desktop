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
    @FXML
    private Label nomlivreurtf;
    @FXML
    private Label etattf;

    String NomLivreur;
    int id_client;
    float prixx; 
    String nomClient;
    LivraisonService LS = new LivraisonService();
    Livraison liv = new Livraison();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
    }    

    @FXML
    private void UpdateLivraison(ActionEvent event) {
    }

    @FXML
    private void DeleteLivraison(ActionEvent event) {
    }

    @FXML
    private void AddLivraison(ActionEvent event) {
    }
    
    
        public void SetLivraison(Livraison L)
    {
        
      NomLivreur=LS.TrouverLivreurNameByColisId(L.getId_livreur());
      prixx = LS.TrouverPrixByIdColis(L.getId_colis());
      id_client=LS.TrouverIdClientByColisId(L.getId_colis());
      nomClient=LS.TrouvernameClientById(id_client);
       
       ///////////////////////////////////////////
     //  System.out.println(NomLivreur);
      // System.out.println(prixx);
      // System.out.println(id_client);
      // System.out.println(nomClient);
        
        ////////////////////////////////////////////
        
        nomctf.setText(NomLivreur);
        nomlivreurtf.setText(nomClient);
        prixcolis.setText(Double.toString(prixx));
        etattf.setText(L.getEtat());
       
        liv=L;
        
    }
        
}
