/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import entities.Colis;
import java.io.IOException;
import services.ColisService;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class AjouterColisController implements Initializable {

    @FXML
    private TextField poidsTF;
    @FXML
    private ChoiceBox<String> typeTF;
    @FXML
    private ChoiceBox<String> lieudTF;
    @FXML
    private ChoiceBox<String> lieuaTF;
    
    ColisService CS = new ColisService();
    
    
    
    private String [] gouvernorat = {"Ariana","Béja","Ben Arous","Bizerte","Gabès","Gafsa","Jendouba","Kairouan","Kasserine","Kébili","Kef","Mahdia","Manouba","Médenine","Monastir","Nabeul","Sfax","Sidi Bouzid","Siliana","Sousse","Tataouine","Tozeur","Tunis","Zaghouan"};
    
    private String [] type = {"Agro-Alimentaire","Matériel Electronique","Meubles","Pièces Automobiles Et Industrielles"};
    
    
    
    @FXML
    private Label ajouter_modifier;
    @FXML
    private ImageView imagelogo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
       Image Logoimage = new Image(getClass().getResourceAsStream("../img/LOGO.png"));
        imagelogo.setImage(Logoimage);
        typeTF.getItems().addAll(type);
        lieudTF.getItems().addAll(gouvernorat);
        lieuaTF.getItems().addAll(gouvernorat);
    }    
    
    
    
    
    
    
    @FXML
    private void Ajouter_Colis(ActionEvent event) {
        
        try {
            Colis c = new Colis();
            c.setPoids(Float.parseFloat(poidsTF.getText()));
            c.setType(typeTF.getValue());
            c.setLdepart(lieudTF.getValue());
            c.setLarrive(lieuaTF.getValue());
            CS.ajouter(c);
             showMessageDialog(null, "Colis Ajouté Avec Succès" );
            
        }
        
        catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
    }
        
    }

    @FXML
    private void Afficher_Colis(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherColis.fxml"));
            Parent root = (Parent)loader.load();
            AfficherColisController controller = (AfficherColisController)loader.getController();
            
            typeTF.getScene().setRoot(root);
            lieudTF.getScene().setRoot(root);
            lieuaTF.getScene().setRoot(root);
            poidsTF.getScene().setRoot(root);
             }
         
         catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
        
        
    }
}
    
    

