/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import entities.CategorieOffre;
import entities.Offre;
import entities.TrajetOffre;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
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
public class AffichageCategorieOffreController implements Initializable {
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
    private GridPane gridmenu;
    @FXML
    private ImageView add;
    @FXML
    private GridPane grid;
    @FXML
    private GridPane gridp;
    CategorieOffreService ts =new CategorieOffreService();
    @FXML
    private TextField filterTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     try {
         this.AfficherCategorieOffre();
     } catch (SQLException ex) {
         Logger.getLogger(AffichageCategorieOffreController.class.getName()).log(Level.SEVERE, null, ex);
     } catch (IOException ex) {
         Logger.getLogger(AffichageCategorieOffreController.class.getName()).log(Level.SEVERE, null, ex);
     }
     }
      public void ModifierCategorieOffre(CategorieOffre o) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierCategorieOffre.fxml"));
    Parent root = loader.load();
    ModifierCategorieOffreController controller = loader.getController();
    controller.setCategorieOffre(o);
    gridp.add(root, 0, 0);
    split.setDividerPositions(0.4333);
}     
public void AfficherCategorieOffre() throws SQLException, IOException {
        List<CategorieOffre> LTO = ts.recuperer();
int c=0;
int r=0;
        for (int i = 0; i < LTO.size(); i++) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("CategorieOffre.fxml"));
            AnchorPane categorie =loader.load();
            CategorieOffreController Tc = loader.getController();
                Tc.setCat(LTO.get(i));
grid.add(categorie, c, r);
c++;
if (c>2){
            c=0;
                    r++;
            }

        }
    }
public void filterOffre(List LTO ) throws SQLException, IOException {
int c=0;
int r=0;
        for (int i = 0; i < LTO.size(); i++) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("CategorieOffre.fxml"));
            AnchorPane categorie =loader.load();
            CategorieOffreController Tc = loader.getController();
                Tc.setCat((CategorieOffre) LTO.get(i));
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
        loader.setLocation(getClass().getResource("AjouterCategorieOffre.fxml"));
AnchorPane pane = loader.load();
gridp.add(pane, 0, 0);

        split.setDividerPositions(0.4333);
    }

    @FXML
    private void close(MouseEvent event) {                split.setDividerPositions(0.9883);

    }

    void refresh(ActionEvent event) throws IOException {
      root = FXMLLoader.load(getClass().getResource("AffichageCategorieOffre.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();    }
    
        

  

    
    

    private void filterList(String filter) throws SQLException, ParseException, IOException {
            List<CategorieOffre> LTO = ts.recuperer();
        List <CategorieOffre> filteredList = FXCollections.observableArrayList();

        // If the filter is empty, show all items
        if (filter == null || filter.trim().isEmpty()) {
            filteredList=LTO;
        }else{

        // Filter the list based on the filter text
        for (CategorieOffre item : LTO) {
            if (item.getPoidsOffre()== Integer.parseInt(filter)||item.getTypeOffre().contentEquals(filter)) {
                System.out.println(LTO);

                filteredList.add(item);

            }
            
        }                  
}this.filterOffre(filteredList); 
                   
 }

    @FXML
    private void FilterList(ActionEvent event) throws SQLException {
    List<CategorieOffre> LTO = ts.recuperer();

        // Set up a listener on the text property of the TextField
       filterTextField.textProperty().addListener((observable, oldValue, newValue) -> {
        try {
                        System.out.println(newValue);

            this.filterList(newValue);
        } catch (SQLException ex) {
            Logger.getLogger(OffreFrontController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(OffreFrontController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AffichageCategorieOffreController.class.getName()).log(Level.SEVERE, null, ex);
        }
});
   
    }
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
