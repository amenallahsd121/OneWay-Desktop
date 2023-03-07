/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.CategorieOffre;
import entities.Demande;
import entities.Offre;
import entities.TrajetOffre;
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
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import services.OffreService;

/**
 * FXML Controller class
 *
 * @author utilisateur
 */
public class AffichageOffreController implements Initializable {

    @FXML
    private Button btnOverview;
    @FXML
    private Button btnSettings211;
    @FXML
    private Button btnPackages;
    @FXML
    private Button btnSettings21;
    @FXML
    private Button btnCustomers;
    @FXML
    private Button btnMenus;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnSettings1;
    @FXML
    private Button btnSettings2;
    @FXML
    private Button btnSignout;
    @FXML
    private SplitPane split;
    @FXML
    private Pane pnlOverview;
    @FXML
    private Label Description;
    @FXML
    private VBox pnItems;
    @FXML
    private GridPane gridmenu;
    @FXML
    private AnchorPane panepane;
    @FXML
    private GridPane gridp;
OffreService os= new OffreService();
    @FXML
    private Label Id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 try {
            this.AfficherOffre();
        } catch (SQLException ex) {
            Logger.getLogger(AffichageTrajetOffreController.class.getName()).log(Level.SEVERE, null, ex);
        }    }    
 public void AfficherOffre() throws SQLException {
        List<Offre> LTO = os.recuperer();

        for (int i = 0; i < LTO.size(); i++) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Offre.fxml"));

            try {
                HBox hbox = loader.load();
                OffreController Tc = loader.getController();

                Tc.SetTrajet(LTO.get(i));
                hbox.setOnMouseEntered(event -> {
                    hbox.setStyle("-fx-background-color : #0A0E3F");
                });
                hbox.setOnMouseExited(event -> {
                    hbox.setStyle("-fx-background-color : #02030A");
                });
                pnItems.getChildren().add(hbox);

            } catch (IOException e) {
            }

        }}
    @FXML
    private void handleClicks(ActionEvent event) {
    }

    @FXML
    private void menuOffre(MouseEvent event) throws IOException {FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
            VBox pane = loader.load();

            gridmenu.add(pane, 0, 1);
    }

    @FXML
    private void menuOffreOut(MouseEvent event) {
    }

    @FXML
    private void close(MouseEvent event) {                split.setDividerPositions(0.9883);

    }
      public void ModifierDemandeOffre(Offre o) throws IOException, SQLException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherDemande.fxml"));
    Parent root = loader.load();
    AfficherDemandeController controller = loader.getController();
    controller.AfficherDemande(o);
    gridp.add(root, 0, 0);
    split.setDividerPositions(0.2528);
}     
    
}
