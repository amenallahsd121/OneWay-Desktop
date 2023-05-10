/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import entities.Colis;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import services.ColisService;
import services.LivraisonService;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class AfficherColisBackController implements Initializable {

    private ImageView logo;
    @FXML
    private VBox Vboxcolis;
    
     private List<Colis> Col = new ArrayList<>();
     ColisService CS = new ColisService();
     LivraisonService LS = new LivraisonService();
        
     private List<Integer> ColisIDs = new VirtualFlow.ArrayLinkedList<>();
     private List<Integer> LivraisonIDs = new VirtualFlow.ArrayLinkedList<>();
     private List<Integer> IndelevredIDList = new ArrayList<>();
     

    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        ColisIDs = CS.GetALLcolisID();
        LivraisonIDs=LS.GetALLColislivraisonID();


       for (int i=0 ; i<ColisIDs.size() ; i++)
       {
         boolean var=true;  
           for(int j=0 ; j<LivraisonIDs.size() && var==true; j++ )
           {
               if(ColisIDs.get(i) != LivraisonIDs.get(j))
                var=true;
               else
                   var=false;

           }
           if (var==true)
              
           
           IndelevredIDList.add(ColisIDs.get(i));   
       }
       
       
       
       
       
       
       
       try
       {
        Col=CS.ALLinDelevredColis(IndelevredIDList);
       }
        catch (SQLException ex) {
            Logger.getLogger(AfficherColisBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        System.out.println(Col);
        
       
             
               this.AFFICHERLESCOLISS();
    }    
    
    
    

    
    
    
    
    public void AFFICHERLESCOLISS(){
       
    for(int i=0 ; i<Col.size() ; i++)
    {
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("ColisViewBack.fxml"));
        
        try {
            HBox hbox = fxmlloader.load();
            ColisViewBackController Cvb = fxmlloader.getController();
            Cvb.SetColis(Col.get(i));
            Vboxcolis.getChildren().add(hbox);
        }
        catch(IOException e)
                {
                    e.printStackTrace();
                }
       
    }

} 

    private void affichercolis(ActionEvent event) {
        
        
        try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherLivraison.fxml"));
            Parent root = (Parent)loader.load();
            AfficherLivreurController controller = (AfficherLivreurController)loader.getController();
            logo.getScene().setRoot(root);
         
        
        } catch (Exception e) {
             System.out.println(e);
                
        }
        
        
    }

    private void afficherlivraison(ActionEvent event) {
        
        try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherLivraison.fxml"));
            Parent root = (Parent)loader.load();
            AfficherLivraisonController controller = (AfficherLivraisonController)loader.getController();
            logo.getScene().setRoot(root);
         
        
        } catch (Exception e) {
             System.out.println(e);
                
        }
        
    }

    private void afficherLivreur(ActionEvent event) {
        try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherLivreur.fxml"));
            Parent root = (Parent)loader.load();
            AfficherLivreurController controller = (AfficherLivreurController)loader.getController();
            logo.getScene().setRoot(root);
         
        
        } catch (Exception e) {
             System.out.println(e);
                
        }
        
        
    }
   
    
    
  
    
    
}
