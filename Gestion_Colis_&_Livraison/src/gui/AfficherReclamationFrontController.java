/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import entities.Reclamation;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import services.ReclamationService;
import services.ReponseService;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AfficherReclamationFrontController implements Initializable {
      private List<Reclamation> Rec = new VirtualFlow.ArrayLinkedList<>();

    @FXML
    private VBox Vboxrec;
     
   ReclamationService RS = new ReclamationService();
   ReponseService RepS = new ReponseService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          try {
              // TODO
              Rec=RS.recuperer();
              
          } catch (SQLException ex) {
              Logger.getLogger(AfficherReclamationFrontController.class.getName()).log(Level.SEVERE, null, ex);
          }
         
          this.AFFICHERLESRECLAMATION();
    }    
    
    
    
    
    public void AFFICHERLESRECLAMATION(){
    for(int i=0 ; i<Rec.size() ; i++)
    {
       
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("ReclamationViewFront.fxml"));
       
         try {
            
            HBox hbox = fxmlloader.load();
            ReclamationViewFrontController rvc = fxmlloader.getController();
            rvc.SetReclamation(Rec.get(i));
            
            Vboxrec.getChildren().add(hbox);  
        }
        catch(IOException e)
                {
                    e.printStackTrace();
                }
       
    }
    
    
    
    
    
    
    }

    @FXML
    private void AjouterReclamation(ActionEvent event) {
        
        
         try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterReclamation.fxml"));
            Parent root = (Parent)loader.load();
            AjouterReclamationController controller = (AjouterReclamationController)loader.getController();
            Vboxrec.getScene().setRoot(root);
         
        
        } catch (Exception e) {
             System.out.println(e);
                
        }
        
    }
}
