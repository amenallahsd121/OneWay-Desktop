/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Opportunite;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
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
 * @author Meddeb sofien
 */
public class FrontOppS8iraController implements Initializable {

    @FXML
    private HBox Hbox;
    @FXML
    private Label deplabel;
    @FXML
    private Label arrivelabel;
    @FXML
    private Label id_label;
    @FXML
    private Label hdlabel;
    @FXML
    private Label halabel;
    @FXML
    private Label descriptionlabel;
     Opportunite e = new Opportunite();
 OpporuniteService os =new OpporuniteService();
    @FXML
    private Label datelabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
      public void setOp(Opportunite  E) {
      DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
      
        datelabel.setText(df.format(E.getDate()));
         deplabel.setText(E.getDepart());
         arrivelabel.setText(E.getArrivee());
        descriptionlabel.setText(E.getDescription());
        hdlabel.setText(Float.toString(E.getHeur_depart()));
        halabel.setText(Float.toString(E.getHeure_arrivee()));
        id_label.setText(String.valueOf(E.getId_opp()));
      e=E;
       
    }

    @FXML
    private void choisirop(ActionEvent event) {
        FXMLLoader fxmlloader = new FXMLLoader();
        
         //FrontOppS8iraController Lvc = fxmlloader.getController();
         //Loader.set
          try {
            e.setId_opp(Integer.parseInt(id_label.getText()));
              System.out.println(e.getId_opp());
            Parent loader = FXMLLoader.load(getClass().getResource("AjouterAffFront.fxml"));
            id_label.getScene().setRoot(loader);
       
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
        
        
        
    }
   

    
}
