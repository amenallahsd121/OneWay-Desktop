/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author utilisateur
 */
public class MenuController implements Initializable {

    @FXML
    private Label trajet;
    @FXML
    private Label categorie;
    @FXML
    private Label offre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Offre(MouseEvent event) throws IOException {FXMLLoader loader = new FXMLLoader(getClass().getResource("AffichageOffre.fxml"));
            Parent root = loader.load();
            offre.getScene().setRoot(root);
    }


    @FXML
    private void Trajet(MouseEvent event) throws IOException { FXMLLoader loader = new FXMLLoader(getClass().getResource("AffichageTrajetOffre.fxml"));
            Parent root = loader.load();
            trajet.getScene().setRoot(root);
    }

    @FXML
    private void Categorie(MouseEvent event) throws IOException { FXMLLoader loader = new FXMLLoader(getClass().getResource("AffichageCategorie.fxml"));
            Parent root = loader.load();
            categorie.getScene().setRoot(root);
    }

    @FXML
    private void choose(MouseEvent event) {
    }
    
}
