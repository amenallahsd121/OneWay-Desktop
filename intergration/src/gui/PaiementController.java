/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class PaiementController implements Initializable {

    @FXML
    private TextField card;
    @FXML
    private TextField m_exp;
    @FXML
    private TextField y_exp;
    @FXML
    private TextField cvc;
    @FXML
    private Button pay;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Pay(ActionEvent event) {
    }
    
}
