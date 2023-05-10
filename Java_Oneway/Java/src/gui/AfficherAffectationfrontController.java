/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.AffectationOpColis;
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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import services.AffectationService;

/**
 * FXML Controller class
 *
 * @author Meddeb sofien
 */
public class AfficherAffectationfrontController implements Initializable {

    @FXML
    private VBox Vbox;
     AffectationService as = new AffectationService();
     AffectationOpColis e1 = new AffectationOpColis();
     private List<AffectationOpColis> list = new VirtualFlow.ArrayLinkedList<>();
    @FXML
    private AnchorPane paneMain;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
//        switchmode button = new switchmode();
//        SimpleBooleanProperty isOn = button.switchOnProperty();
//        isOn.addListener(((observable, oldValue, newValue) -> {
//            
//            if(newValue){
//                button.getScene().getRoot().getStylesheets().add(getClass().getResource("Style.css").toString());
//                System.out.println("Ajouter le css");
//            }
//            else{
//                button.getScene().getRoot().getStylesheets().remove(getClass().getResource("Style.css").toString());
//                System.out.println("Supprimer le css");
//                
//            }
//        }));
//        
//        paneMain.getChildren().add(button);
        
        try { 
            list = as.recuperer();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        
        
        this.AFFICHERAff();
    }    


     private void AFFICHERAff() {
      for(int i=0 ; i<list.size() ; i++)
    {
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("Affs8irafront.fxml"));
        
        try {
            HBox hbox = fxmlloader.load();
           Affs8irafrontController l = fxmlloader.getController();
           l.setAff(list.get(i));
            Vbox.getChildren().add(hbox);
            
            
        }
        catch(IOException e)
                {
                    e.printStackTrace();
                }
       
    } 

    }

    @FXML
    private void retour(ActionEvent event) {
        
           try {
           

            Parent loader = FXMLLoader.load(getClass().getResource("FrontOffice.fxml"));
           Vbox.getScene().setRoot(loader);
       
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
    }
    
}
