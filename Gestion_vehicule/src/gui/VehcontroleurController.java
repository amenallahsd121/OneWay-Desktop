/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/*import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;*/

import entities.Vehicule;
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
import gui.Afficher_VehiculeController;
import javafx.scene.control.Alert;
import services.VehiculeService;

/**
 * FXML Controller class
 *
 * @author Houda
 */
public class VehcontroleurController implements Initializable {

    @FXML
    private Label idlabel;
    @FXML
    private Label matriculelabel;
    @FXML
    private Label marquelabel;
    @FXML
    private Label idcatlabel;
    
            VehiculeService vs = new VehiculeService();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setCategorie(Vehicule  v ) {
     
       matriculelabel.setText(v.getMatricule());
       marquelabel.setText(v.getMarque());
       idlabel.setText(String.valueOf(v.getId_vehicule())); 
       idcatlabel.setText(String.valueOf(v.getId_categorie()));
    
    }

    @FXML
    private void suppimer(ActionEvent vehicule) throws IOException {
          Vehicule v =new Vehicule();
    v.setId_vehicule(Integer.parseInt(idlabel.getText()));
        try {
            vs.supprimer(v);
              Alert alert = new Alert(Alert.AlertType.INFORMATION);

              alert.setTitle("Information Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Véhicule supprimeé avec succés!");

              alert.show();
            Parent loader = FXMLLoader.load(getClass().getResource("Afficher_vehicule.fxml"));
            idlabel.getScene().setRoot(loader);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @FXML
    private void modifierveh(ActionEvent event) throws IOException {
        Vehicule c =new Vehicule();
    c.setId_categorie(Integer.parseInt(idlabel.getText()));
    Parent loader = FXMLLoader.load(getClass().getResource("Ajouter_vehicule.fxml"));
    
            idlabel.getScene().setRoot(loader);
        
        
    }
    
    
}
