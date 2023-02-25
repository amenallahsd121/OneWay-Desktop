/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.AffectationOpColis;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import services.AffectationService;

/**
 * FXML Controller class
 *
 * @author Meddeb sofien
 */
public class AfficherAffectationController implements Initializable {

    @FXML
    private GridPane gridpane;
    @FXML
    private Button retour_btn;
  AffectationService as = new AffectationService();
  AffectationOpColis e1 = new AffectationOpColis();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        try {
             
            List<AffectationOpColis> aff = as.recuperer(e1);
            int row = 0;
            int column = 0;
            for (int i = 0; i < aff.size(); i++) {
                //chargement dynamique d'une interface
                FXMLLoader loader = new FXMLLoader(getClass().getResource("affeccontrol.fxml"));
                AnchorPane pane = loader.load();
               
                //passage de parametres
                AffeccontrolController controller = loader.getController();
                controller.setAff(aff.get(i));
                

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
           

            Parent loader = FXMLLoader.load(getClass().getResource("AjouterAffectation.fxml"));
           gridpane.getScene().setRoot(loader);
       
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
    }
   }
    

