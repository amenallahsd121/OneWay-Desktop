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
public class ModifierMaintenanceController implements Initializable {

    @FXML
    private TextField etat;
    @FXML
    private TextField nomsos;
    @FXML
    private TextField idvehmain;
    
     private static int id;
      Maintenance Main = new Maintenance();
    MaintenanceService MS = new MaintenanceService();
      /////////////////////////////////////////////////////////////////// GET ID LIVREUR FUNCTION //////////////////////////////////////////////////////////////
    
     public static int getIdd(Maintenance v) {
        
        id = v.getId_maintenance();
          System.out.println(id);
   
        return id;
        
    } 
    
    
      

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
          Main=MS.TrouverById(id);
        etat.setText(Main.getEtat());
         nomsos.setText(Main.getNom_sos_rep());
         idvehmain.setText(Integer.toString(Main.getId_vehicule()));
        
    }    

    @FXML
    private void ModifierMaintenance(ActionEvent event) {
        try {
           
            Main.setId_vehicule(id);      
            Main.setEtat(etat.getText());
            Main.setNom_sos_rep(nomsos.getText());
            Main.setId_vehicule(Integer.parseInt(idvehmain.getText()));
          
        
            
            {
            MS.modifier(Main);
            //showMessageDialog(null, "Maintenance Modifiée Avec Succès");
            notification(Main.getEtat(),"Votre Maintenance a été modifier avec succès",NotificationType.SUCCESS);

            }
            
             } catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        }
        
    }

    @FXML
    private void AnnulerMaintenance(ActionEvent event) {
        
        try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BackOffice.fxml"));
              Parent root = (Parent)loader.load();
              BackOfficeController controller = (BackOfficeController)loader.getController();
                 nomsos.getScene().setRoot(root);
             
        
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
