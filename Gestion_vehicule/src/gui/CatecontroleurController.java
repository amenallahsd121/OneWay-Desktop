/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/*import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;*/

import entities.Categorie;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import gui.Afficher_categorieController;
import javafx.scene.control.Alert;
import services.CategorieService;

/**
 * FXML Controller class
 *
 * @author Houda
 */
public class CatecontroleurController implements Initializable {

    @FXML
    private Label nomLabel;
    @FXML
    private Button supprimerbtn;
    @FXML
    private Button modifierbtn;
    @FXML
    private Label id_label;
    
    CategorieService vc = new CategorieService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
public void setCategorie(Categorie  c) {
     
       nomLabel.setText(c.getType());
       id_label.setText(String.valueOf(c.getId_categorie()));
    
    }
    

    @FXML
    
     private void supprimerCategorie(ActionEvent categorie)throws IOException {
        Categorie c =new Categorie();
    c.setId_categorie(Integer.parseInt(id_label.getText()));
        try {
            vc.supprimer(c);
              Alert alert = new Alert(Alert.AlertType.INFORMATION);

              alert.setTitle("Information Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Catégorie supprimer avec succés!");

              alert.show();
            Parent loader = FXMLLoader.load(getClass().getResource("Afficher_categorie.fxml"));
            nomLabel.getScene().setRoot(loader);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @FXML
    private void modifierCategorie(ActionEvent categorie) throws IOException 
    {
        Categorie c =new Categorie();
    c.setId_categorie(Integer.parseInt(id_label.getText()));
    Parent loader = FXMLLoader.load(getClass().getResource("Ajouter_categorie.fxml"));
    
            nomLabel.getScene().setRoot(loader);
        
    }
    
}
