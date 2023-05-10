
package GUI;

import entity.location;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.LocationService;


public class addLocationController implements Initializable {

        location locM = new location();
        LocationService us = new LocationService();
        @FXML
    private Button closebutton;
        @FXML
    private TextField axeXL;
        @FXML
    private TextField AxeYL;
        @FXML
    private TextField AdL;
    @FXML
    private TextField id_relai;
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
     public void setTextField(int id ) {

        
        id_relai.setText(Integer.toString(id));
        id_relai.setVisible(false);
        

    }
    public void getData() {

        locM.setAdresse(AdL.getText());        
        locM.setXaxe(Double.parseDouble(axeXL.getText()));
        locM.setYaxe(Double.parseDouble(AxeYL.getText()));        
        locM.setId_delai(Integer.parseInt(id_relai.getText())); 
        System.out.println(id_relai.getText() + "   eeeeeee");
             
    }

        @FXML
    private void savechanges(ActionEvent event) throws SQLException {
         getData();
         //locM.setId_delai(1);
         System.out.println(locM.getId_delai()+"  dddd"); 
        us.ajouter(locM);
        System.out.println(locM.getId()); 
        Stage stage = (Stage) closebutton.getScene().getWindow();
        stage.close();    
        
    }
    
}
