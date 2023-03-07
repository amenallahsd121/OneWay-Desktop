/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import entities.CategorieOffre;
import entities.TrajetOffre;
import java.io.IOException;
import static java.lang.System.load;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.CategorieOffreService;
import services.TrajetService;

/**
 * FXML Controller class
 *
 * @author utilisateur
 */
public class AffichageTrajetOffreController implements Initializable {

    @FXML
    private Pane pnlOverview;
    @FXML
    private VBox pnItems;
    TrajetService ts = new TrajetService();
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private SplitPane split;
    @FXML
    private ImageView add;
    @FXML
    private AnchorPane panepane;
    @FXML
    private GridPane gridp;
    @FXML
    private Label Description;
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
    private GridPane gridmenu;

    public SplitPane getSplit() {
        return split;
    }

    public GridPane getGridp() {
        return gridp;
    }

    public void setSplit(SplitPane split) {
        this.split = split;
    }

    public void setGridp(GridPane gridp) {
        this.gridp = gridp;
    }

   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.AfficherTrajetOffre();
        } catch (SQLException ex) {
            Logger.getLogger(AffichageTrajetOffreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void AfficherTrajetOffre() throws SQLException {
        List<TrajetOffre> LTO = ts.recuperer();

        for (int i = 0; i < LTO.size(); i++) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("TrajetOffre.fxml"));

            try {
                HBox hbox = loader.load();
                TrajetOffreController Tc = loader.getController();
                Tc.SetTrajet(LTO.get(i));

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

        }
    }

    void refresh(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("AffichageTrajetOffre.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

   
public void ModifierTrajetOffre(TrajetOffre o) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierTrajet.fxml"));
    Parent root = loader.load();
    ModifierTrajetController controller = loader.getController();
    controller.setTrajetOffre(o);
    gridp.add(root, 0, 0);
    split.setDividerPositions(0.4333);
}
    @FXML
    private void AjouterTrajetOffre(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AjouterTrajet.fxml"));
AnchorPane pane = loader.load();
gridp.add(pane, 0, 0);

        split.setDividerPositions(0.4333);
    }

    @FXML
    private void close(MouseEvent event) {
                split.setDividerPositions(0.9883);

    }

    @FXML
    private void handleClicks(ActionEvent event) {
    }

    @FXML
    private void menuOffre(MouseEvent event) throws IOException {FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
            VBox pane = loader.load();

            gridmenu.add(pane, 0, 1);
    }

    @FXML
    private void menuOffreOut(MouseEvent event) {gridmenu.getChildren().clear();
    }
}
