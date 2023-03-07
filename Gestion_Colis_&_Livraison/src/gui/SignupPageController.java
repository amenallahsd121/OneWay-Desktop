
package GUI;

import entity.relais;
import entities.utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.utilisateurService;
import utils.MyDB;


public class SignupPageController implements Initializable {
    

    @FXML
    private ImageView imageview;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField name;
    @FXML
    private PasswordField password;
    @FXML
    private TextField lastname;
    @FXML
    private TextField adresse;
    @FXML
    private TextField email;
    private ChoiceBox<String> type;
    @FXML
    private CheckBox checkpass;
    @FXML
    private DatePicker birthdate;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
     MyDB db = MyDB.getInstance();
    
       System.out.println(db);
    }    

    @FXML
    private void showLogin(MouseEvent event) throws IOException {
        Parent t = FXMLLoader.load(getClass().getResource("interface.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(t);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void signup(ActionEvent event) throws SQLException {
        utilisateur u1 = new utilisateur(name.getText(),lastname.getText(),email.getText(),adresse.getText(),"Client",birthdate.getValue(),password.getText());
        utilisateurService us = new utilisateurService();
        
        us.ajouter(u1);
        
        
    }

    @FXML
    private void showpassword(MouseEvent event) {
        if (checkpass.isSelected()){
        password.setPromptText(password.getText());
        password.setText(""); 
         password.setDisable(true);

         }else {
        password .setText(password.getPromptText());
        password.setPromptText("");
        password.setDisable(false);
        }
    
    }
}
