/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Evenement;
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
import services.EvenementService;

/**
 * FXML Controller class
 *
 * @author Meddeb sofien
 */
public class AfficherEvenementController implements Initializable {

    @FXML
    private GridPane gridpane;
    EvenementService es = new EvenementService();
      Evenement e1;
    @FXML
    private Button retour_btn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
             
            List<Evenement> events = es.recuperer(e1);
            int row = 0;
            int column = 0;
            for (int i = 0; i < events.size(); i++) {
                //chargement dynamique d'une interface
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Eventcontroleur.fxml"));
                AnchorPane pane = loader.load();
               
                //passage de parametres
                EventcontroleurController controller = loader.getController();
                controller.setEvenement(events.get(i));
                

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

    @FXML
    private void retournerHome(ActionEvent event) {
        
        try {
           

            Parent loader = FXMLLoader.load(getClass().getResource("AjouterEvenement.fxml"));
           gridpane.getScene().setRoot(loader);
       
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
    }
    
}