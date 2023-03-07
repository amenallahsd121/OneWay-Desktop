/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Reclamation;
import entities.Reponse;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import services.ReclamationService;
import services.ReponseService;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ReponseViewFrontController implements Initializable {

    @FXML
    private HBox Hbox;
    @FXML
    private Label reclamation;
    @FXML
    private Label reponse;
    @FXML
    private Label Sujet;
    
    
      
    Reponse Rep = new Reponse();
    ReponseService RS = new ReponseService();
    Reclamation Re = new Reclamation();
    ReclamationService RSE = new ReclamationService();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void UpdateReponse(ActionEvent event) {
    }

    @FXML
    private void DeleteReponse(ActionEvent event) {
    }
    
}
