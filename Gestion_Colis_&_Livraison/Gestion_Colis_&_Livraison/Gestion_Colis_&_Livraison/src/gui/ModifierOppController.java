/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Opportunite;
import services.OpporuniteService;
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

/**
 * FXML Controller class
 *
 * @author amens
 */
public class ModifierOppController implements Initializable {

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

    Opportunite OPP = new Opportunite();
    OpporuniteService OS = new OpporuniteService();
    private static int id;
    
    
       public static int getIdd(Opportunite O) {
        
        id = O.getId_opp();
          System.out.println(id);
   
        return id;
    }
       
       
       
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        OPP=OS.recherche(id);
        
        
   
     depart.setText(OPP.getDepart());
     arrive.setText(OPP.getArrivee());
     heuredep.setText(Float.toHexString(OPP.getHeur_depart()));
     heurearr.setText(Float.toHexString(OPP.getHeure_arrivee()));
     desc.setText(OPP.getDescription());
        
        
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

    @FXML
    private void UpdateOpp(ActionEvent event) throws IOException {
        
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
          e.setId_opp(id);
         ///////////////////////////////////////////////
        
         
        
          
   
          
           try {
               
               OS.modifier(e);
               Alert alert = new Alert(Alert.AlertType.INFORMATION);

              alert.setTitle("Information Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Evenement Modifier avec succés!");

              alert.show();
               Parent loader = FXMLLoader.load(getClass().getResource("AfficherOpp.fxml"));
            depart.getScene().setRoot(loader);
       //        reset();
               
           } catch (SQLException ex) {
            System.out.println(ex.getMessage());
      }
        
        
        
    }
    
}
