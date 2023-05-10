/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Demande;
import entities.Maintenance;
import entities.Offre;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import static javax.swing.JOptionPane.showMessageDialog;
import services.DemandeService;

/**
 * FXML Controller class
 *
 * @author utilisateur
 */
public class DemandeFrontCreateController implements Initializable {

    @FXML
    private Label OffreId;
    @FXML
    private TextField colis;
    @FXML
    private TextArea description;
    @FXML
    private Button ajoutColis;
    @FXML
    private Button ajoutdemande;
    @FXML
    private TextField prix;
DemandeService ds= new DemandeService();
    @FXML
    private Button ajoutdemande1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
public void setDemande(Offre O ){        OffreId.setText(String.valueOf(O.getIdOffre()));

}

    @FXML
    private void ajouter(ActionEvent event) { try {
             
            Demande M = new Demande();
            M.setIdOffre(Integer.parseInt(OffreId.getText()));
            M.setIdColis(Integer.parseInt(colis.getText()));
            M.setDescriptionDemande(description.getText());
                        M.setPrix(Integer.parseInt(prix.getText()));

                        M.setIdPersonne(1);

             ds.ajouter(M);
             showMessageDialog(null, "Maintenance Ajoutée Avec Succès" );    
            }
        
        catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
    }
    }

    @FXML
    private void retour(ActionEvent event) {
        
        
          try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FrontOffice.fxml"));
            Parent root = (Parent)loader.load();
            gui.FrontOfficeController controller = (gui.FrontOfficeController)loader.getController();
            description.getScene().setRoot(root);
         
        
        } catch (Exception e) {
             System.out.println(e);
                
        }
        
    }
    
}
