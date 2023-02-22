/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Colis;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.ColisService;
import entities.Colis;
/**
 * FXML Controller class
 *
 * @author amens
 */
public class ModifierColisController implements Initializable {

    @FXML
    private Label ajouter_modifier;
    @FXML
    private TextField poidsTF;
    @FXML
    private TextField typeTF;
    @FXML
    private TextField lieudTF;
    @FXML
    private TextField lieuaTF;
    
    
    
ColisService CS = new ColisService();
    @FXML
    private TextField idcolis;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Modifier_Colis(ActionEvent event) {
        
         try {
            Colis c = new Colis();
            
            c.setId(Integer.parseInt(idcolis.getText()));
            c.setPoids(Float.parseFloat(poidsTF.getText()));
            c.setType(typeTF.getText());
            c.setLdepart(lieudTF.getText());
            c.setLarrive(lieuaTF.getText());
            CS.modifier(c);
            System.out.println("Colis Modifié Avec Succès");
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
