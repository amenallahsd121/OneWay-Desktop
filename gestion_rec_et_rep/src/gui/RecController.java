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
import javafx.scene.control.Label;*/
import entities.Reclamation;
import entities.Reponse;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import gui.Afficher_reclamationController;
import javafx.scene.control.Alert;
import services.ReclamationService;









/**
 * FXML Controller class
 *
 * @author hp
 */
public class RecController implements Initializable {

    @FXML
    private Button modifierbtn;
    @FXML
    private Button supprimerbtn;
    @FXML
    private Label Textlabel;
    @FXML
    private Label Sujetlabel;
    @FXML
    private Label IDlabel;
    ReclamationService Rs = new ReclamationService();
    Reclamation r = new Reclamation();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
public void setReclamation(Reclamation  c) {
     
       Textlabel.setText(c.getText_rec());
       Sujetlabel.setText(c.getSujet());
       IDlabel.setText(String.valueOf(c.getId_rec()));
       r=c;
    
    }    

    @FXML
    private void Modifierreclamation(ActionEvent event) throws IOException {
                Reclamation c =new Reclamation();
  //  c.setId_rec(Integer.parseInt(IDlabel.getText()));
    Parent loader = FXMLLoader.load(getClass().getResource("Ajouter_reclamation.fxml"));
          Ajouter_reclamationController.getid(r.getId_rec());
            Textlabel.getScene().setRoot(loader);
        
    }
        
    

    @FXML
    private void supprimerreclamation(ActionEvent event) throws IOException {
        Reclamation c =new Reclamation();
    c.setId_rec(Integer.parseInt(IDlabel.getText()));
        try {
            Rs.supprimer(c);
              Alert alert = new Alert(Alert.AlertType.INFORMATION);

              alert.setTitle("Information Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Reclamation supprimer avec succés!");

              alert.show();
            Parent loader = FXMLLoader.load(getClass().getResource("Afficher_reclamation.fxml"));
            Textlabel.getScene().setRoot(loader);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

//    public void set(Reponse get) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public void setreponse(Reponse get) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
}
