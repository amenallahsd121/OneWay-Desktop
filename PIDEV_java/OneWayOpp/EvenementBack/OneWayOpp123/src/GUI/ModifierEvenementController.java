/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Evenement;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.EvenementService;

/**
 * FXML Controller class
 *
 * @author Meddeb sofien
 */
public class ModifierEvenementController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField awards;
    @FXML
    private DatePicker mydatedebut;
    @FXML
    private DatePicker mydatefin;
    @FXML
    private TextField description;
    
    
    
    
    
    private static int idd;
    
        EvenementService es = new EvenementService();
        Evenement events = new Evenement();
        Evenement ev = new Evenement();
    
    @FXML
    private Label lbl1;
    
    public static int getIdd(Evenement l) {
        
        idd = l.getId_event();
          System.out.println(idd);
   
        return idd;
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ev= es.TrouverById(idd);
        awards.setText(ev.getAwards());
        description.setText(ev.getDescription());
        nom.setText(ev.getNom());
        mydatedebut.setValue(LocalDate.now());
        mydatefin.setValue(LocalDate.now());
    }  

    @FXML
    private void ModifierEvent(ActionEvent event) throws IOException {
        LocalDate date_debut,date_fin;
          date_debut = mydatedebut.getValue();
          date_fin = mydatefin.getValue();
          Evenement e = new Evenement();         
          e.setId_event(idd);
          e.setNom(nom.getText());
          e.setDate_debut(date_debut.format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
          e.setDate_fin(date_fin.format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
          e.setAwards(awards.getText());
          e.setDescription(description.getText());
         ///////////////////////////////////////////////
       //  id.setText(String.valueOf(idd)); 
         
        
          
   
          
           try {
               
               es.modifier(e);
               Alert alert = new Alert(Alert.AlertType.INFORMATION);

              alert.setTitle("Information Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Evenement Modifier avec succés!");

              alert.show();
               //reset();
               Parent loader = FXMLLoader.load(getClass().getResource("AfficherEvenement.fxml"));
           nom.getScene().setRoot(loader);
               
           } catch (SQLException ex) {
            System.out.println(ex.getMessage());
      }
    
    }

    @FXML
    private void AnnulerModification(ActionEvent event) throws IOException {
         Parent loader = FXMLLoader.load(getClass().getResource("AfficherEvenement.fxml"));
          nom.getScene().setRoot(loader);
    }
}
    
//    @FXML
//    private void ModifierEvent(ActionEvent event) throws IOException {
//        
//        LocalDate date_debut,date_fin;
//          date_debut = mydatedebut.getValue();
//          date_fin = mydatefin.getValue();
//          Evenement e = new Evenement();         
//          e.setId_event(idd);
//          e.setNom(nom.getText());
//          e.setDate_debut(date_debut.format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
//          e.setDate_fin(date_fin.format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
//          e.setAwards(awards.getText());
//          e.setDescription(description.getText());
//         ///////////////////////////////////////////////
//       //  id.setText(String.valueOf(idd)); 
//         
//        
//          
//   
//          
//           try {
//               
//               es.modifier(e);
//               Alert alert = new Alert(Alert.AlertType.INFORMATION);
//
//              alert.setTitle("Information Dialog");
//
//              alert.setHeaderText(null);
//
//              alert.setContentText("Evenement Modifier avec succés!");
//
//              alert.show();
//               //reset();
//               Parent loader = FXMLLoader.load(getClass().getResource("AfficherEvenement.fxml"));
//           nom.getScene().setRoot(loader);
//               
//           } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//      }
//    
//}
//
//    @FXML
//    private void AnnulerModification(ActionEvent event) throws IOException {
//        
//         Parent loader = FXMLLoader.load(getClass().getResource("AfficherEvenement.fxml"));
//           nom.getScene().setRoot(loader);
//    }
//}
//    
//    
//
