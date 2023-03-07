/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Colis;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import services.ColisService;
   
/**
 * FXML Controller class
 *
 * @author amens
 */
public class ColisViewBackController implements Initializable {

    @FXML
    private HBox Hbox;
    @FXML
    private Label NomClient_tf;
    @FXML
    private Label typetf;
    @FXML
    private Label poidstf;
    @FXML
    private Label prixtf;
    @FXML
    private Label lieudtf;
    @FXML
    private Label lieuatf;

     private String name;
     
     
     
      Colis C = new Colis();
    ColisService CS = new ColisService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
    }    

    
    
    
     public void SetColis(Colis c)
    {
       
        name=CS.TrouvernameById(c.getId_client());
        NomClient_tf.setText(name);
        prixtf.setText(Double.toString(c.getPrix())+" DT");
        poidstf.setText(Double.toString(c.getPoids())+ " Kg");
        typetf.setText(c.getType());
        lieudtf.setText(c.getLdepart());
        lieuatf.setText(c.getLarrive());
        C=c;
        
    }

    @FXML
    private void AffecterColis(ActionEvent event) {
        AjouterLivraisonController.getIdColis(C);
         try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterLivraison.fxml"));
            Parent root = (Parent)loader.load();
            AjouterLivraisonController controller = (AjouterLivraisonController)loader.getController();
            typetf.getScene().setRoot(root);
         
        
        } catch (Exception e) {
             System.out.println(e);
                
        }
        
        
    }

     
    
}
