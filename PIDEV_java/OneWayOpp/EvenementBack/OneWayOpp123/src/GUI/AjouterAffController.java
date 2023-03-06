/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entities.AffectationOpColis;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.controlsfx.control.Notifications;
import services.AffectationService;

/**
 * FXML Controller class
 *
 * @author Meddeb sofien
 */
public class AjouterAffController implements Initializable {

    @FXML
    private ComboBox<Integer> idopp;
    @FXML
    private ComboBox<Integer> idcolis;
    
     AffectationOpColis a = new AffectationOpColis();
    AffectationService as = new AffectationService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<Integer> list1 = FXCollections.observableArrayList();        
        list1 = as.idOpDisponible();

        idopp.setItems(list1);
        
        ObservableList<Integer> list2 = FXCollections.observableArrayList();
        list2 = as.idColisDisponible();
        idcolis.setItems(list2);
    }    
     private static int idd;
      
    public static int getIdd(int id) {
        idd = id;
        return idd;
        
        
    }

    @FXML
    private void AjouterAff(ActionEvent event) {
        AffectationOpColis e = new AffectationOpColis();
          e.setIdcolis(idcolis.getValue());
          e.setIdopp(idopp.getValue());
          int i=1;
          
          
           try {
               
               as.ajouter(e);
               i= 2 ;
                 } catch (SQLException ex) {
                
            System.out.println(ex.getMessage());
                 }
               
           if(i==1){
                Alert alert = new Alert(Alert.AlertType.ERROR);

              alert.setTitle("Information Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Colis deja  Affecter ");

              alert.show();
              
              Image image=new Image("GUI/error.png");

        Notifications notifications=Notifications.create();
        notifications.graphic(new ImageView(image));
        notifications.text("Hello there I'm Dilshan Rajika");
        notifications.title("Success Message");
        notifications.hideAfter(javafx.util.Duration.seconds(5));
        /*notifications.darkStyle();*/
     /*   notifications.position(Pos.BOTTOM_CENTER);*/
        notifications.show();
               
             
           }else  {
                 
               Alert alert = new Alert(Alert.AlertType.INFORMATION);

              alert.setTitle("Information Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Affectation insérée avec succés!");

              alert.show();
              Image image=new Image("GUI/ok.png");

        Notifications notifications=Notifications.create();
        notifications.graphic(new ImageView(image));
        notifications.text("Hello there I'm Dilshan Rajika");
        notifications.title("Success Message");
        notifications.hideAfter(javafx.util.Duration.seconds(5));
        /*notifications.darkStyle();*/
     /*   notifications.position(Pos.BOTTOM_CENTER);*/
        notifications.show();
              
           }
             //  reset();
               
         
    }

    @FXML
    private void AfficherAff(ActionEvent event) {
        
         try {
            //navigation
            Parent loader = FXMLLoader.load(getClass().getResource("AfficherAff.fxml"));
            idcolis.getScene().setRoot(loader);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
