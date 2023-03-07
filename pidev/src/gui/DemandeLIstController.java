/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Demande;
import entities.TrajetOffre;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author utilisateur
 */
public class DemandeLIstController implements Initializable {

    @FXML
    private HBox itemC;
    @FXML
    private Label IdDemande;
    @FXML
    private Label Description;
    @FXML
    private Label IdColis;
    @FXML
    private Label IdPersonne;
    @FXML
    private Label Prix;
    @FXML
    private ImageView doc;
Demande to = new Demande();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void SetDemande(Demande o)
    {
       
        IdDemande.setText(String.valueOf(o.getIdDemande()));
        Description.setText(o.getDescriptionDemande());
        IdColis.setText(String.valueOf(o.getIdColis()));
        IdPersonne.setText(String.valueOf(o.getIdPersonne()));        
        Prix.setText(String.valueOf(o.getPrix()));        
       
        
        to=o;
        
    }
}
