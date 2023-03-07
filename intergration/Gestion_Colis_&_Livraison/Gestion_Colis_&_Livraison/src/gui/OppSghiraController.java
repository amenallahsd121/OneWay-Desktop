/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Opportunite;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import services.OpporuniteService;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class OppSghiraController implements Initializable {

    @FXML
    private HBox Hbox;
    @FXML
    private Label depart;
    @FXML
    private Label arrive;
    @FXML
    private Label date;
    @FXML
    private Label heurdep;
    @FXML
    private Label heurarr;
    @FXML
    private Label desc;

    
    private List<Opportunite> list = new VirtualFlow.ArrayLinkedList<>();
    Opportunite o = new Opportunite();
    OpporuniteService OS  = new OpporuniteService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
   
 
    }    

    @FXML
    private void UpdateOpp(ActionEvent event) throws IOException {
        
         ModifierOppController.getIdd(o);
            
             try {
          Parent loader = FXMLLoader.load(getClass().getResource("ModifierOpp.fxml"));
              desc.getScene().setRoot(loader);
        
            
        } catch (NullPointerException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }

    
    
    
    
    
    @FXML
    private void DeleteOpp(ActionEvent event) {
        
         try {
            OS.supprimer(o);
         
            Parent loader = FXMLLoader.load(getClass().getResource("BackOffice.fxml"));
            desc.getScene().setRoot(loader);
      
        
        } catch (Exception e) {
        }
        
    }
    
    
public void SetOpp(Opportunite O)
    {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
       
        depart.setText(O.getDepart());
        arrive.setText(O.getArrivee());
        date.setText(df.format(O.getDate()));
        heurdep.setText(Float.toString(O.getHeur_depart())) ;
        heurarr.setText(Float.toString(O.getHeure_arrivee()));
        desc.setText(O.getDescription());    
         
        o=O;
        
    }
    
}
