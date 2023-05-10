/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.CategorieOffre;
import entities.TrajetOffre;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.TrajetService;

/**
 * FXML Controller class
 *
 * @author utilisateur
 */
public class ModifierTrajetController implements Initializable {

    @FXML
    private TextField NbreEscaleOffre;
    @FXML
    private Button ModifierTrajetOffre;
    @FXML
    private Label description;
    @FXML
    private TextField LimiteKmOffre;
    private TrajetOffre TrajetOffre;

    public Label getDescription() {
        return description;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
public void setTrajetOffre(TrajetOffre t) {
    
        description.setText(t.getDescription());
        NbreEscaleOffre.setText(Integer.toString(t.getNbreEscaleOffre()));
        LimiteKmOffre.setText(Integer.toString(t.getLimiteKmOffre()));

    }

    @FXML
    private void ModifierTrajetOffre(ActionEvent event) throws IOException, SQLException {
       TrajetService cs =new TrajetService();
        TrajetOffre t = new TrajetOffre();
        if (isInputValid()) {

            t.setDescription(description.getText());

            TrajetOffre t1 = cs.recuperer().get(cs.recuperer().indexOf(t));
            System.out.println(t1.toString());

            t1.setLimiteKmOffre(Integer.parseInt(LimiteKmOffre.getText()));
            t1.setNbreEscaleOffre(Integer.parseInt(NbreEscaleOffre.getText()));
            try {

                cs.modifier(t1);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);

                alert.setTitle("Information Dialog");

                alert.setHeaderText(null);

                alert.setContentText("Categorie Modifier avec succés!");

                alert.show();
  Parent loader = FXMLLoader.load(getClass().getResource("affichageTrajetOffre.fxml"));
           description.getScene().setRoot(loader); 
           
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

       
    }

    private boolean isInputValid() {
        return true;
       

    }
    
     
}
