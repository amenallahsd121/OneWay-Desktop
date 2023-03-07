/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Vehicule;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import static javax.swing.JOptionPane.showMessageDialog;
import services.VehiculeService;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class AjouterVehiculeController implements Initializable {

    @FXML
    private TextField matricule;
    @FXML
    private TextField marque;
    @FXML
    private TextField idcatveh;
    VehiculeService  VS = new VehiculeService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterVehicule(ActionEvent event) {
        
         try {
             
            Vehicule v = new Vehicule();
            v.setMatricule(matricule.getText());
            v.setMarque(marque.getText());
            v.setId_categorie(Integer.parseInt(idcatveh.getText()));
            
             VS.ajouter(v);
             //showMessageDialog(null, "Vehicule Ajoutée Avec Succès" );  
             notification(v.getMatricule(),"Votre Véhicule a été ajoutée avec succès",NotificationType.SUCCESS);
            }
        
        catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
    }
      
        
    }

    @FXML
    private void AnnulerVehicule(ActionEvent event) {
        
         try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BackOffice.fxml"));
            Parent root = (Parent)loader.load();
            BackOfficeController controller = (BackOfficeController)loader.getController();
            idcatveh.getScene().setRoot(root);
         
        
        } catch (Exception e) {
             System.out.println(e);
                
        }
        
    }
    
    private static void notification(String title,String message,NotificationType type){
        TrayNotification tray = null;
        tray = new TrayNotification(title,message,type);
        tray.setAnimationType(AnimationType.POPUP);
        tray.setRectangleFill(Paint.valueOf("#2A9A84"));
        tray.showAndDismiss(javafx.util.Duration.seconds(5));
    }
    
}
