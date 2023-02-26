/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Evenement;
import Entities.Participation;
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
import services.ParticipationService;

/**
 * FXML Controller class
 *
 * @author Meddeb sofien
 */
public class AfficherParticipationController implements Initializable {

    /**
     * Initializes the controller class.
     */
  
    Participation p;
    ParticipationService ps = new ParticipationService();
    @FXML
    private GridPane gridpane;
    @FXML
    private Button retour_btn;
      @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         try {
             
            List<Participation> par = ps.recuperer(p);
            int row = 0;
            int column = 0;
            for (int i = 0; i < par.size(); i++) {
                //chargement dynamique d'une interface
                FXMLLoader loader = new FXMLLoader(getClass().getResource("participationcontrol.fxml"));
                AnchorPane pane = loader.load();
               
                //passage de parametres
                ParticipationcontrolController controller = loader.getController();
                controller.setParticipationn(par.get(i));
                

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
           

            Parent loader = FXMLLoader.load(getClass().getResource("AfficherEvenement.fxml"));
           gridpane.getScene().setRoot(loader);
       
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
    }
    
}
