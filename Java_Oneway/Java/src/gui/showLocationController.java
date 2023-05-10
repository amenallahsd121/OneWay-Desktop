
package GUI;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import entity.location;
import entity.relais;
import java.io.IOException;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.LocationService;


public class showLocationController implements Initializable {

        location locM = new location();
        LocationService us = new LocationService();
        private List<location> Lil = new VirtualFlow.ArrayLinkedList<>();
    private Button closebutton;
    private TextField axeXL;
    private TextField AxeYL;
    private TextField AdL;
    @FXML
    private TextField idrelai;
    @FXML
    private ImageView position;
    
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }   
     public void setTextField(int id ) {

        
        idrelai.setText(Integer.toString(id));
        idrelai.setVisible(false);
        

    }
    public void getData() {

            
        locM.setId_delai(Integer.parseInt(idrelai.getText())); 
        System.out.println(idrelai.getText() + "   eeeeeee");
             
    }

        @FXML
    private void savechanges(ActionEvent event) throws SQLException {
        
        locM.setId_delai(Integer.parseInt(idrelai.getText()));
        System.out.println(locM.getId_delai()+"  dddd");
         Lil = us.recuperer(locM.getId_delai());
        /*Stage stage = (Stage) closebutton.getScene().getWindow();
        stage.close(); */
        for(int i=0 ; i<Lil.size() ; i++)
        {
          System.out.println(Lil.get(i).getXaxe()+"  ooo");          
          System.out.println(Lil.size()+"  ww");  
  
            Image image = new Image(getClass().getResourceAsStream("/image/position.png"));
        position.setImage(image);
        position.setFitHeight(20);       
        position.setFitWidth(20);
            System.out.println("inin");
        

        position.setX(Lil.get(i).getXaxe());
        position.setY(Lil.get(i).getYaxe());
        
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("../GUI/item.fxml"));
        
        
        }
        
        
    }
    
}
