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
import javafx.scene.control.Alert;
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
public class ModifierVehiculeController implements Initializable {

    @FXML
    private TextField matricule;
    @FXML
    private TextField marque;
    @FXML
    private TextField idcatveh;
    
    
      private static int id;
      Vehicule Veh = new Vehicule();
    VehiculeService VS = new VehiculeService();
    Vehicule vehicule = new Vehicule();
      
       /////////////////////////////////////////////////////////////////// GET ID LIVREUR FUNCTION //////////////////////////////////////////////////////////////
    
     public static int getIdd(Vehicule v) {
        
        id = v.getId_vehicule();
          System.out.println(id);
   
        return id;
        
    }

    /**
     * Initializes the controller class.
     */
     
     // ****************************************************************** INITIALAISE **********************************************************************
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        Veh=VS.TrouverById(id);
        matricule.setText(Veh.getMatricule());
         marque.setText(Veh.getMarque());
         idcatveh.setText(Integer.toString(Veh.getId_categorie()));
//  
    }    

      /////////////////////////////////////////////////////////////////////// UPDATE VEHICULE///////////////////////////////////////////////////////
    
    @FXML
    private void ModifierVehicule(ActionEvent event) throws SQLException {
             // try {
           if (controleDeSaisie()) {
            vehicule.setId_vehicule(id);      
            vehicule.setMatricule(matricule.getText());
            vehicule.setMarque(marque.getText());
            vehicule.setId_categorie(Integer.parseInt(idcatveh.getText()));
          
        
            
            {
            VS.modifier(vehicule);
            //showMessageDialog(null, "Véhicule Modifiée Avec Succès");
            notification(vehicule.getMatricule(),"Votre vehicule a été modifié avec succès",NotificationType.SUCCESS);
            }
            
            }else{
         
            Alert al = new Alert(Alert.AlertType.ERROR);
             al.setAlertType(Alert.AlertType.ERROR);
             al.setHeaderText("erreur!");
             al.setContentText("verifier les champs!");
             al.show();
            
             /*} catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        }*/
            
    }
    }

    @FXML
    private void AnnulerVehicule(ActionEvent event) {
        
        try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BackOffice.fxml"));
              Parent root = (Parent)loader.load();
              BackOfficeController controller = (BackOfficeController)loader.getController();
                 marque.getScene().setRoot(root);
             
        
        } catch (Exception e) {
             System.out.println(e);
                
        }
        
    }
    
      private static void notification(String title,String message,NotificationType type){
        TrayNotification tray = null;
        tray = new TrayNotification(title,message,type);
        tray.setAnimationType(AnimationType.POPUP);
        tray.setRectangleFill(Paint.valueOf("#2A9A84"));
        tray.showAndDismiss(javafx.util.Duration.seconds(7));
    }
      
      
      private boolean controleDeSaisie() {
        if (matricule.getText().length()<7)
            return false;
        if (marque.getText().length()<3)
            return false;
        
        return true;
    }
      
      
    
}
