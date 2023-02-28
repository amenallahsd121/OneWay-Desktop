
package GUI;

import entity.utilisateur;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.utilisateurService;
import utils.MyDB;


public class InterfaceController implements Initializable {

    @FXML
    private ImageView imageview;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField loginuser;
    @FXML
    private TextField loginpass;
    @FXML
    private Button loginbutton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MyDB db = MyDB.getInstance();
       System.out.println(db);
       
        Image image = new Image(getClass().getResourceAsStream("/utils/Untitled-1.png"));
        imageview.setImage(image);
        
        
    }  

    @FXML
    private void showSignup(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("signupPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();        
    }

    @FXML
    private void login(ActionEvent event) throws SQLException {
        utilisateur u1 = new utilisateur(loginuser.getText(),loginpass.getText());
        utilisateurService us = new utilisateurService();
        boolean valide = us.rechercher(u1);
        if(valide == true)
        {
             Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("valide login!");
        alert.show();
        }else{
            Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Wrong password or username!");
        alert.show();
        }
    }
   


    
}
