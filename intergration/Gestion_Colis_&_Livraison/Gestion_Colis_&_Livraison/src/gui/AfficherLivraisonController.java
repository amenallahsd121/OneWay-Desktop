/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import entities.Livraison;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import static javax.swing.JOptionPane.showMessageDialog;
import services.LivraisonService;
import services.ColisService;
import entities.Colis;



/**
 * FXML Controller class
 *
 * @author amens
 */
public class AfficherLivraisonController implements Initializable {

    private ImageView logo;

     private List<Livraison> livraison = new VirtualFlow.ArrayLinkedList<>();
    LivraisonService LS = new LivraisonService();
    
    
//     private List<Colis> colis = new VirtualFlow.ArrayLinkedList<>();
//     ColisService CS = new ColisService();
    
    
    @FXML
    private VBox Vboxlivraison;
    
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        try { 
            livraison = LS.recuperer();
            
        } catch (SQLException ex) {
            Logger.getLogger(AfficherLivraisonController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        this.AFFICHERLESLIVRAISONS();
        
        
      

       
    }    
    
    
    
    
    
    
    public void AFFICHERLESLIVRAISONS(){
    for(int i=0 ; i<livraison.size() ; i++)
    {
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("LivraisonView.fxml"));
        
        try {
            
            HBox hbox = fxmlloader.load();
            LivraisonViewController LVC = fxmlloader.getController();
            LVC.SetLivraison(livraison.get(i));
            Vboxlivraison.getChildren().add(hbox);
             
        }
        
        catch(IOException e)
                {
                    e.printStackTrace();
                }
       
    }

}

    private void afficherlivraison(ActionEvent event) {
        
         showMessageDialog(null, " Vous Etes Déjà Là-Bas " ); 
        
    }

    private void afficherlivreur(ActionEvent event) {
        
         try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherLivreur.fxml"));
            Parent root = (Parent)loader.load();
            AfficherLivreurController controller = (AfficherLivreurController)loader.getController();
            logo.getScene().setRoot(root);
         
        
        } catch (Exception e) {
             System.out.println(e);
                
        }
        
        
    }

    private void affichercolisback(ActionEvent event) {
        
        try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherColisBack.fxml"));
            Parent root = (Parent)loader.load();
            AfficherColisBackController controller = (AfficherColisBackController)loader.getController();
            logo.getScene().setRoot(root);
         
        
        } catch (Exception e) {
             System.out.println(e);
                
        }
        
    }
}
