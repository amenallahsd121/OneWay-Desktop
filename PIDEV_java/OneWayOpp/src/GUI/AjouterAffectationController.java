/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.AffectationOpColis;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import services.AffectationService;

/**
 * FXML Controller class
 *
 * @author Meddeb sofien
 */
public class AjouterAffectationController implements Initializable {

    @FXML
    private ComboBox<Integer> comboOp;
    @FXML
    private Button ajouterbtn;
    @FXML
    private Button afficherbtn;
    @FXML
    private ComboBox<Integer> comboColis;

    /**
     * Initializes the controller class.
     */
    
    AffectationOpColis a = new AffectationOpColis();
    AffectationService as = new AffectationService();
    @FXML
    private Button modifierbtnn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       ObservableList<Integer> list1 = FXCollections.observableArrayList();        
        list1 = as.idOpDisponible();

        comboOp.setItems(list1);
        
        ObservableList<Integer> list2 = FXCollections.observableArrayList();
        list2 = as.idColisDisponible();
        comboColis.setItems(list2);
        
    }    
    
     private static int idd;
      
    public static int getIdd(int id) {
        idd = id;
        return idd;
        
        
    }

    @FXML
    private void AjouterAffectation(ActionEvent event) {
       
         AffectationOpColis e = new AffectationOpColis();
          e.setIdcolis(comboColis.getValue());
          e.setIdopp(comboOp.getValue());
          
          
          
           try {
               as.ajouter(e);
               Alert alert = new Alert(AlertType.INFORMATION);

              alert.setTitle("Information Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Evenement insérée avec succés!");

              alert.show();
             //  reset();
               
           } catch (SQLException ex) {
                
            System.out.println(ex.getMessage());
      }
    }

    @FXML
    private void AfficherAffectation(ActionEvent event) {
        
        try {
            //navigation
            Parent loader = FXMLLoader.load(getClass().getResource("AfficherAffectation.fxml"));
            comboColis.getScene().setRoot(loader);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void modifierAff(ActionEvent event) throws IOException {
      
        AffectationOpColis e = new AffectationOpColis();          
          e.setIdAff(idd);
          e.setIdcolis(comboColis.getValue());
          e.setIdopp(comboOp.getValue());          
           try {
               
               as.modifier(e);
               Alert alert = new Alert(AlertType.INFORMATION);

              alert.setTitle("Information Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Evenement Modifier avec succés!");

              alert.show();
              Parent loader = FXMLLoader.load(getClass().getResource("AfficherAffectation.fxml"));
            comboColis.getScene().setRoot(loader);
               
           } catch (SQLException ex) {
            System.out.println(ex.getMessage());
      }
    }
    
}
