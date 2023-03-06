/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Evenement;
import Entities.Participation;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import services.ParticipationService;

/**
 * FXML Controller class
 *
 * @author Meddeb sofien
 */
public class AfficherParticipationController implements Initializable {

    @FXML
    private HBox hbox;
    @FXML
    private Button retour_btn;
    @FXML
    private VBox vboxpar;
    
     Participation p;
    ParticipationService ps = new ParticipationService();
    private List<Participation> list = new VirtualFlow.ArrayLinkedList<>();
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
            list = ps.recuperer();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        
        
        this.AFFICHERAff();
    }    

    @FXML
    private void retournerHome(ActionEvent event) {
        
        try {
           

            Parent loader = FXMLLoader.load(getClass().getResource("AfficherEventFront.fxml"));
           hbox.getScene().setRoot(loader);
       
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
    }

    private void AFFICHERAff() {
          for(int i=0 ; i<list.size() ; i++)
    {
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("participationcontrol.fxml"));
        
        try {
            HBox hbox = fxmlloader.load();

          ParticipationcontrolController Lvc = fxmlloader.getController();
          Lvc.setParticipationn(list.get(i));
          
            vboxpar.getChildren().add(hbox);
            
            
        }
        catch(IOException e)
                {
                    e.printStackTrace();
                }


    }
    
}
}