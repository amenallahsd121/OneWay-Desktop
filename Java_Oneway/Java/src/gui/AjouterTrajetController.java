/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.TrajetOffre;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import services.TrajetService;

/**
 * FXML Controller class
 *
 * @author utilisateur
 */
public class AjouterTrajetController implements Initializable {

    private TextField AddDepartOffre;
    private TextField AddArriveOffre;
    @FXML
    private TextField NbreEscaleOffre;
    @FXML
    private TextField LimiteKmOffre;
        TrajetService ts = new TrajetService();
    @FXML
    private Button ModifierTrajetOffre;
    @FXML
    private Label description;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   }    

   

    @FXML
    private void AjouterTrajet(ActionEvent event) throws IOException {
         try {

            TrajetOffre t = new TrajetOffre(Integer.parseInt(LimiteKmOffre.getText()),Integer.parseInt(NbreEscaleOffre.getText()),AddArriveOffre.getText(),AddDepartOffre.getText());
            
            t.setAddDepartOffre(AddDepartOffre.getText());
            t.setAddArriveOffre(AddArriveOffre.getText());

            t.setNbreEscaleOffre(Integer.parseInt(NbreEscaleOffre.getText()));
            t.setLimiteKmOffre(Integer.parseInt(LimiteKmOffre.getText()));
            ts.ajouter(t);
            System.out.println("Categorie ajouter avec succes");
 
 FXMLLoader loader = new FXMLLoader(getClass().getResource("AffichageTrajetOffre.fxml"));
            AnchorPane pane = loader.load();
            AffichageTrajetOffreController controller = loader.getController();
            controller.refresh(event);
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }
   
  
    
}
