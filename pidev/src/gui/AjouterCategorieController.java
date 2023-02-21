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
import javafx.scene.control.TextField;
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
CategorieOffreService cs= new CategorieOffreService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterCategorieOffre(ActionEvent event) throws IOException {try {
        
            CategorieOffre c = new CategorieOffre();
            c.setTypeOffre(TypeOffre.getText());
            c.setNbreColisOffre(Integer.parseInt(nbreColisOffre.getText()));
            c.setPoidsOffre(Integer.parseInt(poidsOffre.getText()));
            cs.ajouter(c);
            System.out.println("Categorie ajouter avec succes");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AffichageCategorie.fxml"));
            Parent root = loader.load();
            AffichageCategorieController controller = loader.getController();
            controller.setData(TypeOffre.getText() + " " + nbreColisOffre.getText());
            poidsOffre.getScene().setRoot(root);
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }
    
}
