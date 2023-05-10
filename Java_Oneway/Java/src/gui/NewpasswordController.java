/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.utilisateurService;
/**
 * FXML Controller class
 *
 * @author wwwou
 */
public class NewpasswordController implements Initializable {

    @FXML
    private TextField AdL;
    @FXML
    private Button closebutton;
    @FXML
    private TextField idd;

    utilisateurService US = new utilisateurService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void savechanges(ActionEvent event) throws SQLException {
        US.modifierpassword(AdL.getText(), (Integer.parseInt(idd.getText())));
        Stage stage = (Stage) closebutton.getScene().getWindow();
        stage.close();
        
    }
    
    
    public void setTextField(int id ) {

        idd.setText(Integer.toString(id));
        idd.setVisible(false);

    }
    
    
}
