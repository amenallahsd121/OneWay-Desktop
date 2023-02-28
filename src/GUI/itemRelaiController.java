
package GUI;

import entity.relais;
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
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import service.relaisService;
import service.utilisateurService;


public class itemRelaiController implements Initializable {

    @FXML
    private HBox itemC;
    @FXML
    private Label nameitem;
    @FXML
    private Label lastnameitem;
    @FXML
    private Label emailitem;
    @FXML
    private Label adresseitem;

    private Stage stage;
    private Scene scene;
    private Parent shit;
    

    relais relai = new relais();
    @FXML
    private Label city;
    @FXML
    private Label number;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
public void SetRelai(relais L)
    {
       
        nameitem.setText(L.getName());
        lastnameitem.setText(L.getLastname());
        emailitem.setText(L.getEmail());
        adresseitem.setText(L.getAdresse());  
        city.setText(L.getCity());
        number.setText(Integer.toString(L.getNumber()));
        
       
        
        relai=L;
        
    }
    @FXML
    private void change(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader ();
    loader.setLocation(getClass().getResource("modifierRelai.fxml"));
    loader.load();

    ModRelaiController modRelaiController = loader.getController();
       // System.out.println(user.getId());
    modRelaiController.setTextField(relai.getId(),relai.getName(), relai.getLastname(),
            relai.getEmail(),relai.getAdresse(),relai.getCity() ,relai.getNumber());
    Parent parent = loader.getRoot();
    Stage stage = new Stage();
    stage.setScene(new Scene(parent));
    stage.initStyle(StageStyle.UTILITY);
    stage.show();
    }

    @FXML
    private void delete(ActionEvent event) throws SQLException, IOException {
        relaisService us = new relaisService();
        us.supprimer(relai);
         shit = FXMLLoader.load(getClass().getResource("Relaiview.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(shit);
        stage.setScene(scene);
        stage.show();  
    }

    @FXML
    private void Addlocation(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader ();
    loader.setLocation(getClass().getResource("addLocation.fxml"));
    loader.load();
    ModRelaiController modRelaiController = loader.getController();
        System.out.println(relai.getId());
    modRelaiController.setTextField(relai.getId());
    Parent parent = loader.getRoot();
    Stage stage = new Stage();
    stage.setScene(new Scene(parent));
    stage.initStyle(StageStyle.UTILITY);
    stage.show();
    }

    

}
