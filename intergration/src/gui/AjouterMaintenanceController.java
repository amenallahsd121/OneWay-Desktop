/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Maintenance;
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
import services.MaintenanceService;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class AjouterMaintenanceController implements Initializable {

    @FXML
    private TextField etat;
    @FXML
    private TextField nomsoc;
    @FXML
    private TextField idvehmain;
MaintenanceService  MS = new MaintenanceService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterMaintenance(ActionEvent event) {
        
           try {
             
            Maintenance M = new Maintenance();
            M.setEtat(etat.getText());
            M.setNom_sos_rep(nomsoc.getText());
            M.setId_vehicule(Integer.parseInt(idvehmain.getText()));
            
             MS.ajouter(M);
             showMessageDialog(null, "Maintenance Ajoutée Avec Succès" ); 
             notification(M.getEtat(),"Votre Maintenance a été ajoutée avec succès",NotificationType.SUCCESS);
            }
        
        catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
    }
      
        
    }

    @FXML
    private void AnnulerMaintenance(ActionEvent event) {
        
        try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BackOffice.fxml"));
            Parent root = (Parent)loader.load();
            BackOfficeController controller = (BackOfficeController)loader.getController();
            nomsoc.getScene().setRoot(root);
         
        
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
