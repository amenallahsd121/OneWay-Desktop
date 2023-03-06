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
import services.AffectationService;

/**
 * FXML Controller class
 *
 * @author Meddeb sofien
 */
public class Affs8irafrontController implements Initializable {

    @FXML
    private Label idcolislabel;
    @FXML
    private Label idoplabel;
    @FXML
    private Label id_label;
    
     AffectationService as = new AffectationService();
    AffectationOpColis e = new AffectationOpColis();
    @FXML
    private Button annuler;
    @FXML
    private Label nom;
    @FXML
    private Label date;
    @FXML
    private Label prenom;
    @FXML
    private Label dep;
    @FXML
    private Label arrive;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setAff(AffectationOpColis  E) {
        
        
        
         id_label.setText(String.valueOf(E.getIdAff()));
       idcolislabel.setText(String.valueOf(E.getIdcolis()) );
     idoplabel.setText(String.valueOf(E.getIdopp()));
       //  String nom = as.getNomUser(E.getIdAff());
         int id_user = as.getiddclient(Integer.parseInt(idcolislabel.getText()));
         
         System.out.println(id_user);
      String nomm = as.getNomUser(id_user);
      String Prenomm = as.getPRENomUser(id_user);
       
        String departt = as.getdepart(Integer.parseInt(idoplabel.getText()));
        
           String Arrivee = as.getArrive(Integer.parseInt(idoplabel.getText()));
        
      
         String dateOp =   as.getdateOp(Integer.parseInt(idoplabel.getText()));
          System.out.println(nomm + " " + Prenomm + " " +departt + " " + Arrivee +" "+ dateOp);
         nom.setText(nomm);
         prenom.setText(Prenomm);
         arrive.setText(Arrivee);
         dep.setText(departt);
         date.setText(dateOp);
            e=E;
       
    }

    @FXML
    private void Annuler(ActionEvent event) throws IOException {
        
         
        AffectationOpColis a =new AffectationOpColis();
         a.setIdAff(Integer.parseInt(id_label.getText()));
        try {
            
              Alert alert = new Alert(Alert.AlertType.WARNING);

              alert.setTitle("confirmation Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Voulez vous supprimer cet Affectation!");
              ButtonType cancelBtn = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
             alert.getButtonTypes().setAll(cancelBtn, ButtonType.OK);
              Optional<ButtonType> result = alert.showAndWait();
           
           if (result.isPresent() && result.get() == ButtonType.OK) {
    // User clicked OK 
           as.supprimer(a);
} else {
    // User clicked cancel or closed the dialog
               System.out.println("Suppression Annuler");
    
}
            Parent loader = FXMLLoader.load(getClass().getResource("AfficherAffectationfront.fxml"));
            id_label.getScene().setRoot(loader);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
