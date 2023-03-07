/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Reclamation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import services.ReponseService;
import entities.Reponse;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import services.ReclamationService;



/**
 * FXML Controller class
 *
 * @author amens
 */
public class ReponseView2Controller implements Initializable {

    @FXML
    private HBox Hbox;
    @FXML
    private Label nomclient;
    @FXML
    private Label reclamation;
    @FXML
    private Label reponse;

    
    Reponse Rep = new Reponse();
    ReponseService RS = new ReponseService();
    Reclamation Re = new Reclamation();
    ReclamationService RSE = new ReclamationService();
        
    String Nclient;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void UpdateReponse(ActionEvent event) {
        
           ModifierReponseController.getIdd(Rep);
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierReponse.fxml"));
            Parent root = loader.load();
            reponse.getScene().setRoot(root);

        } catch (Exception e) {
        }
        
    }

    @FXML
    private void DeleteReponse(ActionEvent event) {
        
         try {
            RS.supprimer(Rep);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BackOffice.fxml"));
            Parent root = (Parent)loader.load();
            BackOfficeController controller = (BackOfficeController)loader.getController(); 
            reponse.getScene().setRoot(root);
        } catch (Exception e) {
        }
        
        
    }
    
    
    public void SetReponse(Reponse R)
    {
       
        Re=RSE.GetRec(R.getId_rec());
        Nclient = RSE.getClientNameById(Re.getId_user());         
        nomclient.setText(Nclient);
        reclamation.setText(Re.getText_rec());
        reponse.setText(R.getText_rep());
        Rep=R;
        
    }
    
}
