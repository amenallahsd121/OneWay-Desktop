/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Demande;
import entities.Offre;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import services.DemandeService;

/**
 * FXML Controller class
 *
 * @author utilisateur
 */
public class AfficherDemandeController implements Initializable {

    @FXML
    private VBox pnItems;
    @FXML
    private Label Id;
    @FXML
    private Label Description;
DemandeService os = new DemandeService();
    @FXML
    private Label IdOffre;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void AfficherDemande(Offre o) throws SQLException {
                 IdOffre.setText(Integer.toString(o.getIdOffre()));

        List<Demande> LTO = os.recuperer();
        for (int i = 0; i < LTO.size(); i++) {
            LTO.get(i).getIdOffre();
if(LTO.get(i).getIdOffre()==o.getIdOffre()){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("DemandeLIst.fxml"));

            try {
                HBox hbox = loader.load();
                DemandeLIstController Tc = loader.getController();

                Tc.SetDemande(LTO.get(i));
                hbox.setOnMouseEntered(event -> {
                    hbox.setStyle("-fx-background-color : #0A0E3F");
                });
                hbox.setOnMouseExited(event -> {
                    hbox.setStyle("-fx-background-color : #02030A");
                });
                pnItems.getChildren().add(hbox);

            } catch (IOException e) {
            }

        }}}
}
