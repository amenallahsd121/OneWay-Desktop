
package GUI;

import entity.relais;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.relaisService;
import services.utilisateurService;


public class ModRelaiController implements Initializable {

    @FXML
    private TextField lastnameM;
    @FXML
    private TextField emailM;
    @FXML
    private TextField adresseM;
    private TextField passM;
    @FXML
    private TextField nameM;
    private DatePicker birthdateM;
    @FXML
    private TextField idM;
    private TextField typeM;
    private TextField pointsM;
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
    public void setTextField(int id ,String name, String lastname, String email, String adresse,String city,int number) {

        nameM.setText(name);
        cityM.setText(city);
        adresseM.setText(adresse);        
        emailM.setText(email);
        lastnameM.setText(lastname);
        idM.setText(Integer.toString(id));
        idM.setVisible(false);
        
        numM.setText(Integer.toString(number));
        

    }public void setTextField(int id) {

        
        idM.setText(Integer.toString(id));
        //idM.setVisible(false);

    }
     
    public void getData() {

        
        relaiM.setName(nameM.getText());
        relaiM.setCity(cityM.getText());
        relaiM.setAdresse(adresseM.getText());        
        relaiM.setEmail(emailM.getText());
        relaiM.setLastname(lastnameM.getText());
        relaiM.setId(Integer.parseInt(idM.getText()));
        relaiM.setNumber(Integer.parseInt(numM.getText()));
        
        
        
        
        
        
    }

    @FXML
    private void savechanges(ActionEvent event) throws SQLException {
         getData();
        us.modifier(relaiM);
        Stage stage = (Stage) closebutton.getScene().getWindow();
    // do what you have to do
    stage.close();    
        
    }

    
}
