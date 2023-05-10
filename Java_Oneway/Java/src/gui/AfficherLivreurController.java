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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
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
    private VBox VboxLivreur;

    
    private List<Livreur> Liv = new VirtualFlow.ArrayLinkedList<>();
    LivreurService LS = new LivreurService();
    @FXML
    private Label tttt;
    int aux =0;
    @FXML
    private TextField search;
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

    private void AfficherColisNonAffectés(ActionEvent event) {
        
         try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherColisBack.fxml"));
            Parent root = (Parent)loader.load();
            AfficherColisBackController controller = (AfficherColisBackController)loader.getController();
            tttt.getScene().setRoot(root);
         
        
        } catch (Exception e) {
             System.out.println(e);
                
        }
        
        
    }

@FXML
    private void searchhh(KeyEvent event) throws SQLException {


        System.out.println(aux);
        //System.out.println(word.charAt(1) + " chhh");
        String x = search.getText();
        aux = x.length();
        System.out.println(x);
        System.out.println(aux); 
 
        Liv=LS.recuperer(aux, x);
        VboxLivreur.getChildren().clear();
        this.AFFICHERLESLIVREUR();
    }

    private void up(ActionEvent event) throws SQLException {
        Liv=LS.triUp();
        VboxLivreur.getChildren().clear();
        this.AFFICHERLESLIVREUR();
    }

    private void down(ActionEvent event) throws SQLException {
        Liv=LS.triDown();
        VboxLivreur.getChildren().clear();
        this.AFFICHERLESLIVREUR();
    }



}







