/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Evenement;
import Entities.Opportunite;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.OpporuniteService;

/**
 * FXML Controller class
 *
 * @author Meddeb sofien
 */
public class AjouterOpController implements Initializable {

    @FXML
    private TextField depart;
    @FXML
    private TextField arrivee;
    @FXML
    private TextField descriptionn;
    @FXML
    private DatePicker datee;
    @FXML
    private Button updatebtn;
    @FXML
    private Label lbl1;
    @FXML
    private TextField heurdep;
    @FXML
    private TextField heurArr;

    
    OpporuniteService os = new OpporuniteService();
    Opportunite oppp = new Opportunite();
    @FXML
    private TextField id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        oppp = os.recherche(idd);
    }    

    @FXML
    private void ajouterOpportunite(ActionEvent event) {
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        LocalDate dateee;
          dateee = datee.getValue();
          
          
          
          
          Opportunite e = new Opportunite();
          e.setDepart(depart.getText());
          e.setDate(Date.valueOf(dateee));
          e.setArrivee(arrivee.getText());
          e.setDescription(descriptionn.getText());
          e.setHeur_depart(Float.parseFloat(heurdep.getText()));
          e.setHeure_arrivee(Float.parseFloat(heurArr.getText()));
          
          
           try {
               os.ajouter(e);
               Alert alert = new Alert(Alert.AlertType.INFORMATION);

              alert.setTitle("Information Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Evenement insérée avec succés!");

              alert.show();
              reset();
               
           } catch (SQLException ex) {
                
            System.out.println(ex.getMessage());
      }
    }
    
      private static int idd;
      
    public static int getIdd(int id) {
        idd = id;
        return idd;
        
        
    }

    @FXML
    private void AfficherOpportunite(ActionEvent event) {
        
        try {
            //navigation
            Parent loader = FXMLLoader.load(getClass().getResource("AfficherOp.fxml"));
            depart.getScene().setRoot(loader);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void modifierOportunite(ActionEvent event) throws IOException {
         DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        LocalDate dateee;
          dateee = datee.getValue();
          
          
          
          
          Opportunite e = new Opportunite();
          e.setDepart(depart.getText());
          e.setDate(Date.valueOf(dateee));
          e.setArrivee(arrivee.getText());
          e.setDescription(descriptionn.getText());
          e.setHeur_depart(Float.parseFloat(heurdep.getText()));
          e.setHeure_arrivee(Float.parseFloat(heurArr.getText()));
          e.setId_opp(idd);
         ///////////////////////////////////////////////
         id.setText(String.valueOf(idd)); 
         
        
          
   
          
           try {
               
               os.modifier(e);
               Alert alert = new Alert(Alert.AlertType.INFORMATION);

              alert.setTitle("Information Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Evenement Modifier avec succés!");

              alert.show();
               Parent loader = FXMLLoader.load(getClass().getResource("AfficherOp.fxml"));
            depart.getScene().setRoot(loader);
       //        reset();
               
           } catch (SQLException ex) {
            System.out.println(ex.getMessage());
      }
    }
    
     private void reset() {
         
        depart.setText("");     
        arrivee.setText("");
        descriptionn.setText("");
        heurArr.setText("");
        heurdep.setText("");
    } 
    
}
