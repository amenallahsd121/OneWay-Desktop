/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Houda
 */
public class Page_de_gardeController implements Initializable {

    @FXML
    private Button vehiculebtn;
    @FXML
    private Button categoriebtn;
    @FXML
    private Button maintenacebtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void vehicule(ActionEvent event) {
        try {

            Parent loader = FXMLLoader.load(getClass().getResource("Ajouter_vehicule.fxml"));
           vehiculebtn.getScene().setRoot(loader);
       
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
        
        
    }

    @FXML
    private void categorie(ActionEvent event) {
         try {

            Parent loader = FXMLLoader.load(getClass().getResource("Ajouter_categorie.fxml"));
           categoriebtn.getScene().setRoot(loader);
       
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
        
        
    }

    @FXML
    private void maintenance(ActionEvent event) {
        try {

            Parent loader = FXMLLoader.load(getClass().getResource("Ajouter_Maintenance.fxml"));
           maintenacebtn.getScene().setRoot(loader);
       
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
        
        
        
    }
    
}
