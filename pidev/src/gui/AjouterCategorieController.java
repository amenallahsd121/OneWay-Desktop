/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.CategorieOffre;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.CategorieOffreService;

/**
 * FXML Controller class
 *
 * @author utilisateur
 */
public class AjouterCategorieController implements Initializable {

    @FXML
    private TextField TypeOffre;
    @FXML
    private TextField nbreColisOffre;
    @FXML
    private TextField poidsOffre;
    @FXML
    private Button AjouterCategorieOffre;
CategorieOffreService cs = new CategorieOffreService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterCategorieOffre(ActionEvent event) throws IOException {if (isInputValid()) {

        try {

            CategorieOffre c = new CategorieOffre();
            c.setTypeOffre(TypeOffre.getText());
            c.setNbreColisOffre(Integer.parseInt(nbreColisOffre.getText()));
            c.setPoidsOffre(Integer.parseInt(poidsOffre.getText()));
            cs.ajouter(c);
            System.out.println("Categorie ajouter avec succes");
 FXMLLoader loader = new FXMLLoader(getClass().getResource("AffichageCategorie.fxml"));
            AnchorPane pane = loader.load();
            AffichageCategorieController controller = loader.getController();
            controller.refresh(event);            
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        }}
    }
    private boolean isInputValid() {
        String errorMessage = "";

        if (TypeOffre.getText() == null || TypeOffre.getText().length() == 0) {
            errorMessage += "No valid type!\n";
        }
        if (nbreColisOffre.getText() == null || nbreColisOffre.getText().length() == 0 || Integer.parseInt(nbreColisOffre.getText()) == 0) {
            errorMessage += "No valid nombre de colis!\n";
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(nbreColisOffre.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid nombre (must be an integer)!\n";
            }
        }

        if (poidsOffre.getText() == null || poidsOffre.getText().length() == 0 || Integer.parseInt(poidsOffre.getText()) == 0) {
            errorMessage += "No valid poids!\n";

        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(poidsOffre.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid poids (must be an integer)!\n";
            }
        }
        if (errorMessage.length() == 0) {
            System.out.println(errorMessage.length());

            return true;

        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }

    }

   
  

}
