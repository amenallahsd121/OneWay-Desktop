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
public class ModifierCategorieController implements Initializable {

    @FXML
    private TextField type;
    
    private static int id;
   
    Categorie Cat = new Categorie();
    CategorieService LS = new CategorieService();
    Categorie categorie = new Categorie();

    /**
     * Initializes the controller class.
     */
    
    
     /////////////////////////////////////////////////////////////////// GET ID Categorie FUNCTION //////////////////////////////////////////////////////////////
    
     public static int getIdd(Categorie c) {
        
        id = c.getId_categorie();
          System.out.println(id);
   
        return id;
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        Cat=LS.TrouverById(id);
         type.setText(Cat.getType());
        
    }    

    @FXML
    private void ModifierCategorie(ActionEvent event) {
        try {
           
            categorie.setId_categorie(id);      
            categorie.setType(type.getText());
            
            LS.modifier(categorie);
            //showMessageDialog(null, "Catégorie Modifiée Avec Succès");
            notification(categorie.getType(),"Votre categorie a été modifier avec succès",NotificationType.SUCCESS);

            
                
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        }
           
        
    }

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
