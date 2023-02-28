
package GUI;

import entity.relais;
import entity.utilisateur;
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
import service.relaisService;
import service.utilisateurService;


public class addRelaiController implements Initializable {

    @FXML
    private TextField lastnameM;
    @FXML
    private TextField emailM;
    @FXML
    private TextField adresseM;
    @FXML
    private TextField nameM;
        relais relaiM = new relais();
        relaisService us = new relaisService();
    @FXML
    private Button closebutton;
    @FXML
    private TextField cityM;
    @FXML
    private TextField numM;
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    public void getData() {

        
        relaiM.setName(nameM.getText());
        relaiM.setAdresse(adresseM.getText());        
        relaiM.setEmail(emailM.getText());
        relaiM.setLastname(lastnameM.getText());        
        relaiM.setCity(cityM.getText());        
        relaiM.setNumber(Integer.parseInt(numM.getText()));
        
   
    }

    @FXML
    private void savechanges(ActionEvent event) throws SQLException {
         getData();
        us.ajouter(relaiM);
        Stage stage = (Stage) closebutton.getScene().getWindow();
        stage.close();    
        
    }
    
}
