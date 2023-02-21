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
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import services.CategorieOffreService;

/**
 * FXML Controller class
 *
 * @author utilisateur
 */
public class AffichageCategorieController implements Initializable {

    @FXML
    private Button Ajouter;
    @FXML
    private TableView<CategorieOffre> CategorieTv;
    @FXML
    private TableColumn<CategorieOffre,Integer> tabid;
    @FXML
    private TableColumn<CategorieOffre,String> TypeOffre;
    @FXML
    private TableColumn<CategorieOffre,Integer> nbreColisOffre;
    @FXML
    private TableColumn<CategorieOffre,Float> poidsOffre;
    @FXML
    private TextField TFsearch;

    CategorieOffreService ps = new CategorieOffreService();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
try {
            
            List<CategorieOffre> CategorieOffres = ps.recuperer();
            ObservableList<CategorieOffre> olp = FXCollections.observableArrayList(CategorieOffres);
           CategorieTv.setItems(olp);
            TypeOffre.setCellValueFactory(new PropertyValueFactory("TypeOffre"));
            nbreColisOffre.setCellValueFactory(new PropertyValueFactory("nbreColisOffre"));
            poidsOffre.setCellValueFactory(new PropertyValueFactory("poidsOffre"));
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        }    }    
    private ObservableList<CategorieOffre> olp;

    @FXML
    private void Ajouter (ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterCategorie.fxml"));
            Parent root = loader.load();
            AjouterCategorieController controller = loader.getController();
            TFsearch.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }

  

    @FXML
    private void searchBar(KeyEvent event) {
    }
      public void setData(String Message) {
        

    }
}
