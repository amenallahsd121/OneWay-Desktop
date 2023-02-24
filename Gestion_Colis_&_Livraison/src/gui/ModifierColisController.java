/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Colis;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.ColisService;
import entities.Colis;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class ModifierColisController implements Initializable {

    @FXML
    private Label ajouter_modifier;
    @FXML
    private TextField poidsTF;
    @FXML
    private ChoiceBox<String> typeTF;
    @FXML
    private ChoiceBox<String> lieudTF;
    @FXML
    private ChoiceBox<String> lieuaTF;

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static int idd;
    private String[] gouvernorat = {"Ariana", "Béja", "Ben Arous", "Bizerte", "Gabès", "Gafsa", "Jendouba", "Kairouan", "Kasserine", "Kébili", "Kef", "Mahdia", "Manouba", "Médenine", "Monastir", "Nabeul", "Sfax", "Sidi Bouzid", "Siliana", "Sousse", "Tataouine", "Tozeur", "Tunis", "Zaghouan"};

    private String[] type = {"Agro-Alimentaire", "Matériel Electronique", "Meubles", "Pièces Automobiles Et Industrielles"};
    ColisService CS = new ColisService();

    @FXML
    private TextField idcolis;
    @FXML
    private ImageView imagelogo;

    /////////////////////////////////////////////////////   Initializes the controller class.  ////////////////////////////////////////////////////////
    /**
     * 
     * 
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

    //////////////////////////////////////////////////////// AFFICHER COLIS ///////////////////////////////////////////////////////////////////
    
    @FXML
    private void Afficher_Colis(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherColis.fxml"));
            Parent root = (Parent) loader.load();
            AfficherColisController controller = (AfficherColisController) loader.getController();

            typeTF.getScene().setRoot(root);
            lieudTF.getScene().setRoot(root);
            lieuaTF.getScene().setRoot(root);
            poidsTF.getScene().setRoot(root);

        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }

    }

    /////////////////////////////////////////////////////////////// MODIFIER COLIS ///////////////////////////////////////////////////////////////// 
    
    @FXML
    private void Modifier_Colis(ActionEvent event) {

        try {
            Colis c = new Colis();
            c.setId(idd);
            c.setPoids(Float.parseFloat(poidsTF.getText()));
            c.setType(typeTF.getValue());
            c.setLdepart(lieudTF.getValue());
            c.setLarrive(lieuaTF.getValue());
            CS.modifier(c);
            showMessageDialog(null, "Colis Modifier Avec Succès");
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        }

       
    }

     ///////////////////////////////////////////////////////////// RECUPERER ID //////////////////////////////////////////////////////////////////////////
    
    public static int getIdd(Colis c) {
        
        idd = c.getId();
        return idd;
    }
    
    

}
