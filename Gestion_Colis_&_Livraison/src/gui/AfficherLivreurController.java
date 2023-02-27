/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import entities.Livreur;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import static javax.swing.JOptionPane.showMessageDialog;
import services.LivreurService;
/**
 * FXML Controller class
 *
 * @author amens
 */
public class AfficherLivreurController implements Initializable {

    @FXML
    private ImageView logo;
    @FXML
    private VBox VboxLivreur;

    
    private List<Livreur> Liv = new VirtualFlow.ArrayLinkedList<>();
    LivreurService LS = new LivreurService();
    @FXML
    private Label tttt;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         // TODO
        try { 
            Liv = LS.recuperer();

        } catch (SQLException ex) {
            Logger.getLogger(AfficherLivreurController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        this.AFFICHERLESLIVREUR();
        
    }    
    
    
   
    
    
    
    
    

    @FXML
    private void AfficherAfeecterColis(ActionEvent event) {
        
           try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherLivraison.fxml"));
            Parent root = (Parent)loader.load();
            AfficherLivraisonController controller = (AfficherLivraisonController)loader.getController();
            tttt.getScene().setRoot(root);
         
        
        } catch (Exception e) {
             System.out.println(e);
                
        }
        
    }
    
    

    @FXML
    private void AfficherLivreur(ActionEvent event) {
          showMessageDialog(null, " Vous Etes Déjà Là-Bas " ); 
        
    }
    
    
    
    
public void AFFICHERLESLIVREUR(){
    for(int i=0 ; i<Liv.size() ; i++)
    {
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("LivreurView.fxml"));
        
        try {
            HBox hbox = fxmlloader.load();
            LivreurViewController Lvc = fxmlloader.getController();
            Lvc.SetLivreur(Liv.get(i));
            VboxLivreur.getChildren().add(hbox);
            
            
        }
        catch(IOException e)
                {
                    e.printStackTrace();
                }
       
    }

}


    @FXML
    private void Ajouter_Livreur(ActionEvent event) {
         try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterLivreur.fxml"));
            Parent root = (Parent)loader.load();
            AjouterLivreurController controller = (AjouterLivreurController)loader.getController();
            tttt.getScene().setRoot(root);
         
        
        } catch (Exception e) {
             System.out.println(e);
                
        }
    }





}







