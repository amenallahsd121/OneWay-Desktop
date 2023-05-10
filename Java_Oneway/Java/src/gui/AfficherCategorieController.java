/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import entities.Categorie;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import services.CategorieService;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class AfficherCategorieController implements Initializable {

    @FXML
    private Label tttt;
    @FXML
    private VBox VboxLivreur;
    private List<Categorie> Cat = new VirtualFlow.ArrayLinkedList<>();
    CategorieService CS = new CategorieService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        try { 
            Cat = CS.recuperer();

        } catch (SQLException ex) {
            Logger.getLogger(AfficherCategorieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
       this.AFFICHERLESCATEGORIES();
        
    }


public void AFFICHERLESCATEGORIES(){
    for(int i=0 ; i<Cat.size() ; i++)
    {
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("CategorieView.fxml"));
        
        try {
            
            HBox hbox = fxmlloader.load();
            CategorieViewController Lvc = fxmlloader.getController();
            Lvc.SetCategorie(Cat.get(i));
            VboxLivreur.getChildren().add(hbox);
            
            
        }
        catch(IOException e)
                {
                    e.printStackTrace();
                }
       
    }

}    

    @FXML
    private void Ajouter_Categorie(ActionEvent event) {
        
        try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterCategorie.fxml"));
            Parent root = (Parent)loader.load();
            AjouterCategorieController controller = (AjouterCategorieController)loader.getController();
            tttt.getScene().setRoot(root);
         
        
        } catch (Exception e) {
             System.out.println(e);
                
        }
        
    }
    
}
