/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Evenement;
import static com.sun.webkit.perf.WCFontPerfLogger.reset;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import services.EvenementService;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class AjouterEvenementController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private DatePicker mydatedebut;
    @FXML
    private DatePicker mydatefin;
    @FXML
    private TextField awards;
    @FXML
    private TextField description;

    EvenementService es = new EvenementService();
    Evenement events = new Evenement();
    Evenement ev = new Evenement();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        events = es.recherche(idd);
        //setData();
         mydatedebut.setValue(LocalDate.now());
            mydatefin.setValue(LocalDate.now());
    }    

    @FXML
    private void AjouterEvenement(ActionEvent event) {
        
        try {
          LocalDate date_debut,date_fin;
           
          date_debut = mydatedebut.getValue();
          date_fin = mydatefin.getValue();
          Evenement e = new Evenement();
          e.setNom(nom.getText());
          e.setDate_debut(date_debut.format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
          e.setDate_fin(date_fin.format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
          e.setAwards(awards.getText());
          e.setDescription(description.getText());
          if(nom.getText().isEmpty()   || awards.getText().isEmpty() || description.getText().isEmpty() || e.getDate_debut().isEmpty() || e.getDate_fin()==null)
            {
                
                //showMessageDialog(null, "Vérifier Vos Champs" ); 
                Alert alert = new Alert(AlertType.ERROR);

              alert.setTitle("Information Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Vérifier Vos Champs");

              alert.show();
            }
          
          else
          {
              
          
          
               es.ajouter(e);
               //showMessageDialog(null, "Evenement Ajouté Avec Succès" );  
               Alert alert = new Alert(AlertType.INFORMATION);

              alert.setTitle("Information Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Evenement insérée avec succés!");

              alert.show();
               reset();
          }
           } catch (SQLException ex) {
                
            System.out.println(ex.getMessage());
      }
          
        
    }

    @FXML
    private void AfficherEvenement(ActionEvent event) {
        
         try {
            Parent loader = FXMLLoader.load(getClass().getResource("BackOffice.fxml"));
            description.getScene().setRoot(loader);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
     private void reset() {
//                   Evenement e = new Evenement();
//    LocalDate date ;
//    date=LocalDate.of(00, 00, 00);
        nom.setText("");     
        awards.setText("");
        description.setText("");
       // mydatedebut.setValue(date);
        
        
    } 
     public  void setData(){
         events = es.recherche(idd);
          int a =idd;
        String b= events.getNom();
        String c= events.getAwards();
        String d = events.getDate_debut();
         nom.setText(b);     
        awards.setText(c);
        description.setText(d);
         
     }
          
     private static int idd;
      
    public static int getIdd(int id) {
        idd = id;
        return idd;
        
        
    }
    
}
