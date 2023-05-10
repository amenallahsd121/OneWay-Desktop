/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Reclamation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import entities.Reponse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import services.ReclamationService;
import services.ReponseService;


/**
 * FXML Controller class
 *
 * @author amens
 */
public class ReponseviewController implements Initializable {

    @FXML
    private HBox Hbox;
    @FXML
    private Label Nomclient;
    @FXML
    private Label Text_reclamation;
    @FXML
    private Label Textereponse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    Reclamation R = new Reclamation();
    ReponseService SerRepo = new ReponseService();
     
    Reclamation recla = new Reclamation();
    ReclamationService SerRec = new ReclamationService();
   
    String ClientName;
    
    public void SetReponse(Reclamation Rp)
    {  
     
        
       ClientName=SerRec.getClientNameById(Rp.getId_user()); 
       Nomclient.setText(ClientName);
       Text_reclamation.setText(Rp.getText_rec());
       Textereponse.setText("Pas Encore");
       R=Rp;
        
    }

    @FXML
    private void Repondre(ActionEvent event) {
        
         AjouterReponseController.getIdRec(R);
          try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterReponse.fxml"));
            Parent root = (Parent)loader.load();
            AjouterReponseController controller = (AjouterReponseController)loader.getController();
            Nomclient.getScene().setRoot(root);
         
        
        } catch (Exception e) {
             System.out.println(e);
                
        }
        
        
    }
    
}
