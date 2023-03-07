 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Categorie;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import services.CategorieService;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class CategorieViewController implements Initializable {

    @FXML
    private HBox Hbox;
    @FXML
    private Label type;
    Categorie c = new Categorie (); 
    CategorieService CS = new CategorieService (); 


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    ////////////////////////////////////////////////////// MODIFIER Categorie ////////////////////////////////////////////////////////////
    @FXML
    private void UpdateCategorie(ActionEvent event) {
        
            ModifierCategorieController.getIdd(c);
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierCategorie.fxml"));
            Parent root = loader.load();
            type.getScene().setRoot(root);
        } catch (Exception e) {
        }
        
    }

    
     ////////////////////////////////////////////////////// SUPPRIMER Categorie ////////////////////////////////////////////////////////////
    @FXML
    private void DeleteCategorie(ActionEvent event) {
        
         try {
            CS.supprimer(c);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BackOffice.fxml"));
              Parent root = (Parent)loader.load();
              BackOfficeController controller = (BackOfficeController)loader.getController();
                 type.getScene().setRoot(root);
        
        } catch (Exception e) {
        }
        
        
        
    }
    
    public void SetCategorie (Categorie C){
        type.setText(C.getType());
        c=C;
    
    }
    
}
