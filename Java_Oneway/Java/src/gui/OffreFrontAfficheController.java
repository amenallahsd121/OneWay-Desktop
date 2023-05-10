/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Offre;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author utilisateur
 */
public class OffreFrontAfficheController implements Initializable {

    @FXML
    private Button demande;
    @FXML
    private Label Prix;
    @FXML
    private Label Date;
    @FXML
    private Label CategorieColis;
    @FXML
    private Label CategorieOffre;
    @FXML
    private Label Description;
    @FXML
    private Label Nom;
Offre to = new Offre();
    @FXML
    private Label id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 public void SetTrajet(Offre o)
    {
        Nom.setText(String.valueOf(o.getIdUser()));
        System.out.println(o.getDescriptionOffre());
        CategorieOffre.setText(o.getCatOffreId());
        Description.setText(o.getIdTrajetOffre());
        Date.setText(o.getDateSortieOffre());

        CategorieColis.setText(String.valueOf(o.getIdCatColis()));        
        Prix.setText(String.valueOf(o.getPrixOffre()));        
       id.setText(String.valueOf(o.getIdOffre()));
        
        to=o;
        
    }
    @FXML
    private void Demander(ActionEvent event) throws IOException {FXMLLoader loader = new FXMLLoader(getClass().getResource("DemandeFrontCreate.fxml"));
            Parent root = (Parent)loader.load();
            DemandeFrontCreateController controller = (DemandeFrontCreateController)loader.getController();
            to.setIdOffre(Integer.parseInt(id.getText()));
            controller.setDemande(to);
            Nom.getScene().setRoot(root);
         
    }
    
}
