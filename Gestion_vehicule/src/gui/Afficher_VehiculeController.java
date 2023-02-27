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
*/
import entities.Vehicule;
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
import services.VehiculeService;

/**
 * FXML Controller class
 *
 * @author Houda
 */
public class Afficher_VehiculeController implements Initializable {

    @FXML
    private Button retour_btn;
    VehiculeService vs = new VehiculeService();
    @FXML
    private GridPane gridpane;
    
    Vehicule v ;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
             
            List<Vehicule> vehicule = vs.recuperer();
            int row = 0;
            int column = 0;
            for (int i = 0; i < vehicule.size(); i++) {
                //chargement dynamique d'une interface
                FXMLLoader loader = new FXMLLoader(getClass().getResource("vehcontroleur.fxml"));
                AnchorPane pane = loader.load();
               
                //passage de parametres
               VehcontroleurController controller = loader.getController();
                controller.setCategorie(vehicule.get(i));
                

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
        // TODO
    }    

    @FXML
    private void retournerHome(ActionEvent event) {
        try {

            Parent loader = FXMLLoader.load(getClass().getResource("Ajouter_vehicule.fxml"));
           gridpane.getScene().setRoot(loader);
       
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
        
        
    }

   /* void setData(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
}
