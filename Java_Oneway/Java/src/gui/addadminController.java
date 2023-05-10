
package GUI;

import entities.utilisateur;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.utilisateurService;


public class addadminController implements Initializable {

    @FXML
    private TextField lastnameM;
    @FXML
    private TextField emailM;
    @FXML
    private TextField adresseM;
    @FXML
    private TextField passM;
    @FXML
    private TextField nameM;
    @FXML
    private DatePicker birthdateM;
        utilisateur userM = new utilisateur();
        utilisateurService us = new utilisateurService();
    @FXML
    private Button closebutton;
    @FXML
    private TextField pointsM;
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    public void getData() {

        
        userM.setName(nameM.getText());
        userM.setBirthdate(birthdateM.getValue());
        userM.setPassword(passM.getText());
        userM.setAdresse(adresseM.getText());        
        userM.setEmail(emailM.getText());
        userM.setLastname(lastnameM.getText());
        userM.setType("admin");
        userM.setNbr_point(0);
        
        
        
        
        
        
    }

    @FXML
    private void savechanges(ActionEvent event) throws SQLException {
         getData();
        us.ajouter(userM);
        Stage stage = (Stage) closebutton.getScene().getWindow();
        stage.close();    
        
    }
    
}
