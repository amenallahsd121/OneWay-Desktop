package gui;
import entities.Reponse;
import gui.RecController;
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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
//import services.ReclamationService;
import services.ReponseService;


public class Afficher_reponseController implements Initializable {

    @FXML
    private Button retour_btn;
    @FXML
    private GridPane gridpane;
    @FXML
    private Label welcomeLb;
    ReponseService RS = new ReponseService();
    Reponse Rp;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
             
            List<Reponse> Reponse = RS.recuperer();
            int row = 0;
            int column = 0;
            for (int i = 0; i < Reponse.size(); i++) {
                //chargement dynamique d'une interface
                FXMLLoader loader = new FXMLLoader(getClass().getResource("REP.fxml"));
                AnchorPane pane = loader.load();
               
                //passage de parametres
                REPController controller = loader.getController();
                controller.setReponse(Reponse.get(i));
                

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
    private void retournerHome(ActionEvent reponse) {
        try {

         //   Parent loader = FXMLLoader.load(getClass().getResource("ajouter_reponse.fxml"));
              Parent loader = FXMLLoader.load(getClass().getResource("Ajouter_reponse.fxml"));

         gridpane.getScene().setRoot(loader);
       
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
    }
    
}