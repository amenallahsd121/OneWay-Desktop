/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.AffectationOpColis;
import Entities.Evenement;
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
import javafx.scene.control.Label;
import services.AffectationService;



/**
 * FXML Controller class
 *
 * @author Meddeb sofien
 */
public class ModifierAffController implements Initializable {

    /**
     * Initializes the controller class.
     */
     AffectationService as = new AffectationService();
     AffectationOpColis e = new AffectationOpColis();
        private static int idd;
    @FXML
    private Label id;

    
     public static int getIdd(AffectationOpColis l) {
        
        idd = l.getIdAff();
          System.out.println(idd);
   
        return idd;
        
    }
     
    @FXML
    private ComboBox<Integer> idcolis;
    @FXML
    private ComboBox<Integer> idopp;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        e = as.recherche(idd);
         ObservableList<Integer> list1 = FXCollections.observableArrayList();        
        list1 = as.idOpDisponible();

        idopp.setItems(list1);
        
        ObservableList<Integer> list2 = FXCollections.observableArrayList();
        list2 = as.idColisDisponible();
        idcolis.setItems(list2);
        
        
        idcolis.setValue(e.getIdcolis());
        idopp.setValue(e.getIdopp());
    }    

    @FXML
    private void modifierAff(ActionEvent event) throws IOException, SQLException {
         AffectationOpColis e = new AffectationOpColis();         
          e.setIdAff(idd);
          e.setIdcolis(idcolis.getValue());
          e.setIdopp(idopp.getValue());
         
        
          
   
          
           try {
               
               as.modifier(e);
               Alert alert = new Alert(Alert.AlertType.INFORMATION);

              alert.setTitle("Information Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Affectation Modifier avec succés!");

              alert.show();
               //reset();
               Parent loader = FXMLLoader.load(getClass().getResource("AfficherAff.fxml"));
           id.getScene().setRoot(loader);
               
           } catch (SQLException ex) {
            System.out.println(ex.getMessage());
      }
       
    }

    @FXML
    private void Annuler(ActionEvent event) throws IOException {
         Parent loader = FXMLLoader.load(getClass().getResource("AfficherAff.fxml"));
          id.getScene().setRoot(loader);
    }
    
}
