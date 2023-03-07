/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Categorie;
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
import services.CategorieService;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class AjouterCategorieController implements Initializable {

    @FXML
    private TextField type;
    
      CategorieService CS = new CategorieService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
/////////////////////////////////////////////////////////////////////////////////// ADD CATEGORIE///////////////////////////////////////////////////////////////
    @FXML
    private void AjouterCategorie(ActionEvent event) {
        
         try {
             
            Categorie c = new Categorie();
            c.setType(type.getText());
            
        CS.ajouter(c);
             showMessageDialog(null, "Categorie Ajoutée Avec Succès" );  
             notification(c.getType(),"Votre Catégorie a été ajoutée avec succès",NotificationType.SUCCESS);
    }
         
        
        catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
    }
         
    }

    
      /////////////////////////////////////////////////////////////////////////////////// CATEGORIE LIST ///////////////////////////////////////////////////////////////
    
    @FXML
    private void AnnulerCategorie(ActionEvent event) {
        
        
         try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BackOffice.fxml"));
            Parent root = (Parent)loader.load();
              BackOfficeController controller = (BackOfficeController)loader.getController();
            type.getScene().setRoot(root);
         
        
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
