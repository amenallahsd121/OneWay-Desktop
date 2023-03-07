/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Opportunite;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
import services.OpporuniteService;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class AjouterOppController implements Initializable {

    @FXML
    private Label etat;
    @FXML
    private DatePicker date;
    @FXML
    private TextField depart;
    @FXML
    private TextField arrive;
    @FXML
    private TextField heuredep;
    @FXML
    private TextField heurearr;
    @FXML
    private TextField desc;

    
    Opportunite O = new Opportunite();
    OpporuniteService OS = new OpporuniteService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterOpp(ActionEvent event) {
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        LocalDate dateee;
        dateee = date.getValue();
          
          
          
          
          Opportunite e = new Opportunite();
          e.setDepart(depart.getText());
          e.setDate(Date.valueOf(dateee));
          e.setArrivee(arrive.getText());
          e.setDescription(desc.getText());
          e.setHeur_depart(Float.parseFloat(heuredep.getText()));
          e.setHeure_arrivee(Float.parseFloat(heurearr.getText()));
          
          
           try {
               OS.ajouter(e);
               Alert alert = new Alert(Alert.AlertType.INFORMATION);

              alert.setTitle("Information Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Opportunité Ajouté avec succés!");

              alert.show();
             
               
           } catch (SQLException ex) {
                
            System.out.println(ex.getMessage());
      }
        
        
        
    }

    @FXML
    private void AfficherOpp(ActionEvent event) {
        
          try {
            Parent loader = FXMLLoader.load(getClass().getResource("BackOffice.fxml"));
            desc.getScene().setRoot(loader);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
