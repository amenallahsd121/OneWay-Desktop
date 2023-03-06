/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entities.AffectationOpColis;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import services.AffectationService;

/**
 * FXML Controller class
 *
 * @author Meddeb sofien
 */
public class AfficherAffController implements Initializable {

    @FXML
    private Label tttt;
    @FXML
    private VBox VboxLEvent;
    
     private List<AffectationOpColis> list = new VirtualFlow.ArrayLinkedList<>();
    
     AffectationService as = new AffectationService();
     AffectationOpColis e1 = new AffectationOpColis();
    @FXML
    private AnchorPane paneMain;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        GUI.switchmode button = new GUI.switchmode();
        SimpleBooleanProperty isOn = button.switchOnProperty();
        isOn.addListener(((observable, oldValue, newValue) -> {
            
            if(newValue){
                button.getScene().getRoot().getStylesheets().add(getClass().getResource("Style.css").toString());
                System.out.println("Ajouter le css");
            }
            else{
                button.getScene().getRoot().getStylesheets().remove(getClass().getResource("Style.css").toString());
                System.out.println("Supprimer le css");
                
            }
        }));
        
        paneMain.getChildren().add(button);
        
        
        try { 
            list = as.recuperer();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        
        
        this.AFFICHERAff();
    }    

    @FXML
    private void AjouterAff(ActionEvent event) {
        
          try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterAff.fxml"));
            Parent root = (Parent)loader.load();
            AjouterAffController controller = ( AjouterAffController)loader.getController();
            tttt.getScene().setRoot(root);
         
        
        } catch (Exception e) {
             System.out.println(e);
                
        }
    }

    private void AFFICHERAff() {

        for(int i=0 ; i<list.size() ; i++)
    {
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("AffS8ira.fxml"));
        
        try {
            HBox hbox = fxmlloader.load();
           // EventS8iraControllor Lvc = fxmlloader.getController();
           // Lvc.SetEvent(list.get(i));
           AffS8iraControllor l = fxmlloader.getController();
           l.setAff(list.get(i));
            VboxLEvent.getChildren().add(hbox);
            
            
        }
        catch(IOException e)
                {
                    e.printStackTrace();
                }
       
    }

    }
    
}
