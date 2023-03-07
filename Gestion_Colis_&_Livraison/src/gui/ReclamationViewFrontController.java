/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Reclamation;
import entities.Reponse;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import services.ReclamationService;
import services.ReponseService;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ReclamationViewFrontController implements Initializable {

    @FXML
    private HBox Hbox;
    @FXML
    private Label reclamation;
    @FXML
    private Label reponse;
    @FXML
    private Label Sujet;
    

    Reclamation Re = new Reclamation();
    ReclamationService RSE = new ReclamationService();
    Reponse RP = new Reponse();
    ReponseService RS = new ReponseService();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void Update (ActionEvent event) {
        
        ModifierReclamationController.getIdd(Re);
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierReclamation.fxml"));
            Parent root = loader.load();
            reponse.getScene().setRoot(root);

        } catch (Exception e) {
        }
        
    }

    @FXML
    private void Delete(ActionEvent event) {
        
           try {
               System.out.println(Re);
            RSE.supprimer(Re);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FrontOffice.fxml"));
            Parent root = (Parent)loader.load();
            FrontOfficeController controller = (FrontOfficeController)loader.getController(); 
            reponse.getScene().setRoot(root);
        } catch (Exception e) {
        
    }
    
    }
    
    
     public void SetReclamation(Reclamation R)
    {
       
       RP = RS.TrouverReponseByRecla(R.getId_rec());
       if (RP == null)
       {
        reclamation.setText(R.getText_rec());
        reponse.setText("En Cours");
        Sujet.setText(R.getSujet());
        Re=R;
       }
       else
       {
           reclamation.setText(R.getText_rec());
        reponse.setText(RP.getText_rep());
        Sujet.setText(R.getSujet());
        Re=R; 
           
       }
       
       
        
        
        
      
        
    }
    
    
    
}
    
