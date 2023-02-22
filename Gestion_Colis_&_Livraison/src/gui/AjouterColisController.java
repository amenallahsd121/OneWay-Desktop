/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import entities.Colis;
import java.io.IOException;
import services.ColisService;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class AjouterColisController implements Initializable {

    @FXML
    private TextField poidsTF;
    @FXML
    private TextField typeTF;
    @FXML
    private TextField lieudTF;
    @FXML
    private TextField lieuaTF;
    
    ColisService CS = new ColisService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Ajouter_Colis(ActionEvent event) {
        
        try {
            Colis c = new Colis();
            c.setPoids(Float.parseFloat(poidsTF.getText()));
            c.setType(typeTF.getText());
            c.setLdepart(lieudTF.getText());
            c.setLarrive(lieuaTF.getText());
            CS.ajouter(c);
            System.out.println("Colis Ajouté Avec Succès");
        }
        
        catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
    }
        
    }

    @FXML
    private void Afficher_Colis(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherColis.fxml"));
            Parent root = (Parent)loader.load();
            AfficherColisController controller = (AfficherColisController)loader.getController();
            
            typeTF.getScene().setRoot(root);
            lieudTF.getScene().setRoot(root);
            lieuaTF.getScene().setRoot(root);
            poidsTF.getScene().setRoot(root);
             }
         
         catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
        
        
    }
}
    
    

