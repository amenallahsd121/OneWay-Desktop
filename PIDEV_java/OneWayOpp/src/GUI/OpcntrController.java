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
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import services.OpporuniteService;

/**
 * FXML Controller class
 *
 * @author Meddeb sofien
 */
public class OpcntrController implements Initializable {

    @FXML
    private Label deplabel;
    @FXML
    private Label arrivelabel;
    @FXML
    private Label descriptionlabel;
    @FXML
    private Button supprimeropbtn;
    @FXML
    private Button modifierOpbtn;
    @FXML
    private Label id_label;
    @FXML
    private Label datelabel;
    @FXML
    private Label hdlabel;
    @FXML
    private Label halabel;
 Opportunite e = new Opportunite();
 OpporuniteService os =new OpporuniteService();
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
    private void supprimerOp(ActionEvent event) throws IOException {
         Opportunite e =new Opportunite();
     e.setId_opp(Integer.parseInt(id_label.getText()));
        try {
            Alert alert = new Alert(Alert.AlertType.WARNING);

              alert.setTitle("confirmation Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Voulez vous supprimer cet Opportunite!");
              ButtonType cancelBtn = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
             alert.getButtonTypes().setAll(cancelBtn, ButtonType.OK);
              Optional<ButtonType> result = alert.showAndWait();
           
           if (result.isPresent() && result.get() == ButtonType.OK) {
    // User clicked OK 
           os.supprimer(e);
} else {
    // User clicked cancel or closed the dialog
               System.out.println("Suppression Annuler");
    
}
            Parent loader = FXMLLoader.load(getClass().getResource("AfficherOp.fxml"));
            deplabel.getScene().setRoot(loader);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void modifierOp(ActionEvent event) throws IOException {
        
         
             try {
          Parent loader = FXMLLoader.load(getClass().getResource("AjouterOp.fxml"));
         
          AjouterOpController.getIdd(e.getId_opp());
                         
                 

             deplabel.getScene().setRoot(loader);
        
            
        } catch (NullPointerException ex) {
            System.out.println("error" + ex.getMessage());
        }
           
    }
    
}
