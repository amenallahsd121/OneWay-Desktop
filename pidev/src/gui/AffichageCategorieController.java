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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.CategorieOffreService;
import services.TrajetService;

/**
 * FXML Controller class
 *
 * @author utilisateur
 */
public class AffichageCategorieController implements Initializable {
 private Stage stage;
    private Scene scene;
    private Parent root;
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
    private TextField TypeOffre1;
    @FXML
    private GridPane gridmenu;
    @FXML
    private ImageView add;
    @FXML
    private GridPane grid;
    @FXML
    private GridPane gridp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     try {
         this.AfficherCategorieOffre();
     } catch (SQLException ex) {
         Logger.getLogger(AffichageCategorieController.class.getName()).log(Level.SEVERE, null, ex);
     } catch (IOException ex) {
         Logger.getLogger(AffichageCategorieController.class.getName()).log(Level.SEVERE, null, ex);
     }
     }
      public void ModifierCategorieOffre(CategorieOffre o) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierCategorie.fxml"));
    Parent root = loader.load();
    ModifierCategorieController controller = loader.getController();
    controller.setCategorieOffre(o);
    gridp.add(root, 0, 0);
    split.setDividerPositions(0.4333);
}     
public void AfficherCategorieOffre() throws SQLException, IOException {
    CategorieOffreService ts =new CategorieOffreService();
        List<CategorieOffre> LTO = ts.recuperer();
int c=0;
int r=0;
        for (int i = 0; i < LTO.size(); i++) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Categorie.fxml"));
            AnchorPane categorie =loader.load();
            CategorieController Tc = loader.getController();
                Tc.setCat(LTO.get(i));
grid.add(categorie, c, r);
c++;
if (c>2){
            c=0;
                    r++;
            }

        }
    }
    @FXML
    private void handleClicks(ActionEvent event) {
    }

    @FXML
    private void menuOffre(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
            VBox pane = loader.load();
            gridmenu.add(pane, 0, 1);
    }

    @FXML
    private void menuOffreOut(MouseEvent event) {gridmenu.getChildren().clear();
    }

    @FXML
    private void AjouterCategorieOffre(MouseEvent event) throws IOException {  FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AjouterCategorie.fxml"));
AnchorPane pane = loader.load();
gridp.add(pane, 0, 0);

        split.setDividerPositions(0.4333);
    }

    @FXML
    private void close(MouseEvent event) {                split.setDividerPositions(0.9883);

    }

    void refresh(ActionEvent event) throws IOException {
      root = FXMLLoader.load(getClass().getResource("AffichageCategorie.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();    }
}
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * FXML Controller class
 *
 * @author utilisateur
 */
