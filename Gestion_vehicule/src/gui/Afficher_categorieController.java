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
import javafx.scene.layout.GridPane;*/

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import services.CategorieService;

/**
 * FXML Controller class
 *
 * @author Houda
 */
public class Afficher_categorieController implements Initializable {

    @FXML
    private GridPane gridpane;
    
    CategorieService vc = new CategorieService();
    Categorie c ; 
    private Button retour_btn; 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        try {
             
            List<Categorie> categorie = vc.recuperer();
            int row = 0;
            int column = 0;
            for (int i = 0; i < categorie.size(); i++) {
                //chargement dynamique d'une interface
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Catecontroleur.fxml"));
                AnchorPane pane = loader.load();
               
                //passage de parametres
                CatecontroleurController controller = loader.getController();
                controller.setCategorie(categorie.get(i));
                

                gridpane.add(pane, column, row);
                column++;
                if (column > 1) {
                    column = 0;
                    row++;
                }
            }
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }    

        // TODO
        

    @FXML
    private void retournerHome(ActionEvent categorie) {
        try {

            Parent loader = FXMLLoader.load(getClass().getResource("Ajouter_categorie.fxml"));
           gridpane.getScene().setRoot(loader);
       
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
        
    }
    
}
