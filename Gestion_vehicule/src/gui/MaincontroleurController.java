/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/*import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;*/

import entities.Maintenance;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import gui.Afficher_maintenanceController;
import javafx.scene.control.Alert;
import services.MaintenanceService;

/**
 * FXML Controller class
 *
 * @author Houda
 */
public class MaincontroleurController implements Initializable {

    @FXML
    private Label idlabel;
    @FXML
    private Label etatlabel;
    @FXML
    private Label nomlabel;
    @FXML
    private Label idvehlabel;

    MaintenanceService ms = new MaintenanceService();

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

 public void setCategorie(Maintenance  m ) {
     
       etatlabel.setText(m.getEtat());
       nomlabel.setText(m.getNom_sos_rep());
       idlabel.setText(String.valueOf(m.getId_maintenance())); 
       idvehlabel.setText(String.valueOf(m.getId_vehicule()));
    
    }

    @FXML
    private void supprimer(ActionEvent event) throws IOException {
        Maintenance m =new Maintenance();
        m.setId_maintenance(Integer.parseInt(idlabel.getText()));
        try {
            ms.supprimer(m);
              Alert alert = new Alert(Alert.AlertType.INFORMATION);

              alert.setTitle("Information Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Maintenance supprimée avec succés!");

              alert.show();
            Parent loader = FXMLLoader.load(getClass().getResource("Afficher_Maintenance.fxml"));
            idlabel.getScene().setRoot(loader);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }

    @FXML
    private void modifier(ActionEvent event) {
    }
    
}
