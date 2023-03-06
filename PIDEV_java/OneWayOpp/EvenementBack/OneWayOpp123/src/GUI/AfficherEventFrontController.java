/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Evenement;
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
import services.EvenementService;

/**
 * FXML Controller class
 *
 * @author Meddeb sofien
 */
public class AfficherEventFrontController implements Initializable {

    @FXML
    private Label tttt;
    @FXML
    private VBox Vbox;
    
    private List<Evenement> list = new VirtualFlow.ArrayLinkedList<>();
     Evenement events = new Evenement();
     EvenementService es = new EvenementService();
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
            list = es.recuperer();

        } catch (SQLException ex) {
            Logger.getLogger(gui.AfficherEvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        this.AFFICHERLESEVENT();
        
    }    

    @FXML
    private void afficher(ActionEvent event) {
        
         try {
           

            Parent loader = FXMLLoader.load(getClass().getResource("AfficherParticipation.fxml"));
           tttt.getScene().setRoot(loader);
       
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
    }

  
public void AFFICHERLESEVENT() {
       
        
         for(int i=0 ; i<list.size() ; i++)
    {
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("FrontEventS8ira.fxml"));
        
        try {
            HBox hbox = fxmlloader.load();
//            EventS8iraControllor Lvc = fxmlloader.getController();
//            Lvc.SetEvent(list.get(i));
          FrontEventS8iraController Lvc = fxmlloader.getController();
          Lvc.SetEvent(list.get(i));
          
            Vbox.getChildren().add(hbox);
            
            
        }
        catch(IOException e)
                {
                    e.printStackTrace();
                }
       
    }

    }    
    
}
