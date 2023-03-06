/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Meddeb sofien
 */
public class AjouterEventFrontController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField awards;
    @FXML
    private DatePicker mydatedebut;
    @FXML
    private DatePicker mydatefin;
    @FXML
    private TextField description;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterEvenement(ActionEvent event) {
    }

    @FXML
    private void AfficherEvenement(ActionEvent event) {
    }
    
}
