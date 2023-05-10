/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Demande;
import entities.TrajetOffre;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import services.DemandeService;
import static sun.net.www.http.HttpClient.New;

/**
 * FXML Controller class
 *
 * @author utilisateur
 */
public class DemandelittleController implements Initializable {

    @FXML
    private Button Annuler;
    @FXML
    private Label Prix;
    @FXML
    private Label IdColis;
    @FXML
    private Label IdOffre;
    @FXML
    private Label Description;
    @FXML
    private Label Nom;
    @FXML
    private Button discuter;
    private Stage stage;
    private Scene scene;
    private Parent shit;
private Demande d;
DemandeService ds = new DemandeService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 public void SetDemande(Demande o)
    {
       
        Description.setText(String.valueOf(o.getIdDemande()));
        Description.setText(o.getDescriptionDemande());
        IdColis.setText(String.valueOf(o.getIdColis()));
        Nom.setText(String.valueOf(o.getIdPersonne()));        
        Prix.setText(String.valueOf(o.getPrix()));        
       
        
        d=o;
        
    }
    @FXML
    private void annuler(ActionEvent event) throws IOException { 
                     Demande c =new Demande();
    c.setIdDemande(Integer.parseInt(Description.getText()));
    
        try {
            
              Alert alert = new Alert(Alert.AlertType.WARNING);

              alert.setTitle("confirmation ");

              alert.setHeaderText(null);

              alert.setContentText("Voulez-vous supprimer cet " +"?");
              ButtonType cancelBtn = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
             alert.getButtonTypes().setAll(cancelBtn, ButtonType.OK);
              Optional<ButtonType> result = alert.showAndWait();
           
           if (result.isPresent() && result.get() == ButtonType.OK) {
    // User clicked OK 
           ds.supprimer(c);
           
               
} else {
    // User clicked cancel or closed the dialog
               System.out.println("supprission annulee");
    
}
          shit = FXMLLoader.load(getClass().getResource("DemandeFrontCreate.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(shit);
        stage.setScene(scene);
        stage.show();  
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    

    @FXML
    private void discuter(ActionEvent event) {
    }
    
}
