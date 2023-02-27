/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import entities.Colis;
import services.ColisService;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


/**
 * FXML Controller class
 *
 * @author amens
 */
public class AfficherColisController implements Initializable {

    @FXML
    private ImageView logo;
    @FXML
    private VBox Vboxcolis;
    @FXML
    private Label ajcolis;

       private List<Colis> Col = new VirtualFlow.ArrayLinkedList<>();
       ColisService CS = new ColisService();
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try { 
            Col = CS.recuperer();

        } catch (SQLException ex) {
            Logger.getLogger(AfficherColisController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        
        this.AFFICHERLESCOLIS();
    }    

    
    
    
     @FXML
    private void AjouterColis(ActionEvent event) {
        
         try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterColis.fxml"));
            Parent root = (Parent)loader.load();
            AjouterColisController controller = (AjouterColisController)loader.getController();
            ajcolis.getScene().setRoot(root);
         
        
        } catch (Exception e) {
             System.out.println(e);
                
        }
    }
          
          
          

   public void AFFICHERLESCOLIS(){
    for(int i=0 ; i<Col.size() ; i++)
    {
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("ColisView.fxml"));
        
        try {
            HBox hbox = fxmlloader.load();
            ColisViewController Cvc = fxmlloader.getController();
            Cvc.SetColis(Col.get(i));
            Vboxcolis.getChildren().add(hbox);
            
            
        }
        catch(IOException e)
                {
                    e.printStackTrace();
                }
       
    }

} 
   
   

   
    }
    
    
    
    
    
    
    
    
    

