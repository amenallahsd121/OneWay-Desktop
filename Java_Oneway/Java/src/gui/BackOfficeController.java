/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import entities.utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class BackOfficeController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private AnchorPane paneMane;
private Stage stage;
    private Scene scene;
    private Parent root;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        GUI.switchmode button = new GUI.switchmode();
        SimpleBooleanProperty isOn = button.switchOnProperty();
        isOn.addListener(((observable, oldValue, newValue) -> {
            
            if(newValue){
                button.getScene().getRoot().getStylesheets().add(getClass().getResource("Darkmode.css").toString());
                System.out.println("Ajouter le css");
            }
            else{
                button.getScene().getRoot().getStylesheets().remove(getClass().getResource("Darkmode.css").toString());
                System.out.println("Supprimer le css");
                
            }
        }));
        
        paneMane.getChildren().add(button);
    }    

 
    
    
    private void loadPage(String page)
    {
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(BackOfficeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        bp.setCenter(root);
        
        
    }

    @FXML
    private void GoClient(ActionEvent event) {
         loadPage("home");
    }

    @FXML
    private void GoAdmins(ActionEvent event) {
        loadPage("adminview");
    }

    @FXML
    private void GoRelais(ActionEvent event) {
       loadPage("Relaiview");
    }

    @FXML
    private void GoReclamation(ActionEvent event) {
         loadPage("SousBackOfficeReclamation");
    }

    @FXML
    private void GoOffreDemande(ActionEvent event) {
    }

    @FXML
    private void GoEvenement(ActionEvent event) {
        loadPage("AfficherEvenement");
    }

    @FXML
    private void GoVehicule(ActionEvent event) {
          loadPage("SousBackOfficeVehicule");
        
    }

    @FXML
    private void GoLivreur(ActionEvent event) {
         loadPage("AfficherLivreur");
    }

    @FXML
    private void GoOpportunité(ActionEvent event) {
         loadPage("AfficherOpp");
    }

    @FXML
    private void GoColis(ActionEvent event) {
        loadPage("SousBackOffice");
    }

    @FXML
    private void GoSignOut(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("interface.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root,900,610);
                stage.setScene(scene);
                stage.show();  
    }

    
    
}
