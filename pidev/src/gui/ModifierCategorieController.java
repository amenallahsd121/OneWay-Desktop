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
import javafx.scene.layout.VBox;
import services.CategorieOffreService;

/**
 * FXML Controller class
 *
 * @author utilisateur
 */
public class ModifierCategorieController implements Initializable {

    @FXML
    private Label description;
    @FXML
    private TextField poids;
    @FXML
    private TextField nombre;
    @FXML
    private Label type;
        CategorieOffreService cs = new CategorieOffreService();

private CategorieOffre CategorieOffre;
    @FXML
    private Button ModifierTrajetOffre;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  public void setCategorieOffre(CategorieOffre CategorieOffre) {
        this.CategorieOffre = CategorieOffre;
        type.setText(CategorieOffre.getTypeOffre());
        nombre.setText(Integer.toString(CategorieOffre.getNbreColisOffre()));
        poids.setText(Float.toString(CategorieOffre.getPoidsOffre()));

    }
    @FXML
    private void ModifierTrajetOffre(ActionEvent event) throws IOException, SQLException {
      CategorieOffre c = new CategorieOffre();
        if (isInputValid()) {

            c.setTypeOffre(type.getText());

            CategorieOffre l = cs.recuperer().get(cs.recuperer().indexOf(c));
            System.out.println(l.toString());

            c.setNbreColisOffre(Integer.parseInt(nombre.getText()));
            c.setPoidsOffre(Float.parseFloat(poids.getText()));
            System.out.println(l.toString());

            cs.modifier(c);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Categorie Modifier avec succés!");
            alert.show();
            Parent loader = FXMLLoader.load(getClass().getResource("affichageCategorie.fxml"));
            type.getScene().setRoot(loader);}}

    private boolean isInputValid() {
        String errorMessage = "";

        if (type.getText() == null || type.getText().length() == 0) {
            errorMessage += "No valid type!\n";
        }
        if (nombre.getText() == null || nombre.getText().length() == 0 || Integer.parseInt(nombre.getText()) == 0) {
            errorMessage += "No valid nombre de colis!\n";
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(nombre.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid nombre (must be an integer)!\n";
            }
        }

        if (poids.getText() == null || poids.getText().length() == 0 || Integer.parseInt(poids.getText()) == 0) {
            errorMessage += "No valid poids!\n";

        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(poids.getText());
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

    
    

