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
import javafx.scene.control.TextField;*/
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import entities.Vehicule;
import java.sql.SQLException;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import services.VehiculeService;

/**
 * FXML Controller class
 *
 * @author Houda
 */
public class Ajouter_vehiculeController implements Initializable {

    @FXML
    private TextField matriculetf;
    @FXML
    private TextField marquetf;
    
     //VehiculeService vs = new VehiculeService();
    @FXML
    private TextField idcattf;
    @FXML
    private Button retour_btn;
    private VehiculeService vehiculeS;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        vehiculeS = new VehiculeService();
    }    

    @FXML
    private void affichervehicule(ActionEvent event) {
        
        try {
           /* FXMLLoader loader = new FXMLLoader(getClass().getResource("Afficher_Vehicule.fxml"));
            Parent root = loader.load();
            Afficher_VehiculeController controller = loader.getController();
            controller.setData(matriculetf.getText() + " " + marquetf.getText() + " " + idcattf.getText());*/
           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Afficher_Vehicule.fxml"));
            Parent root = (Parent)loader.load();
            Afficher_VehiculeController controller = (Afficher_VehiculeController)loader.getController();
            matriculetf.getScene().setRoot(root);
       
       
            
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
        
    
    }

    @FXML
    private void ajoutervehicule(ActionEvent event)  throws IOException, SQLException{
       
     //try {
          if (controleDeSaisie()) { 
            Vehicule v = new Vehicule();
            v.setMatricule(matriculetf.getText());
            v.setMarque(marquetf.getText());
            v.setId_categorie(Integer.valueOf(idcattf.getText()));
           // V.setTex(String.valueOf(v.getId_categorie())).
            vehiculeS.ajouter(v);
            System.out.println("Vehicule ajoutée avec succes");
            
            Alert al = new Alert(Alert.AlertType.INFORMATION);
             al.setAlertType(Alert.AlertType.INFORMATION);
             al.setHeaderText("Valider");
             al.setContentText("les informations ont été ajoutées avec succès");
             al.show(); 
             //((Node)(event.getSource())).getScene().getWindow().hide();
             
             }else{
         
            Alert al = new Alert(Alert.AlertType.ERROR);
             al.setAlertType(Alert.AlertType.ERROR);
             al.setHeaderText("erreur!");
             al.setContentText("verifier les champs!");
             al.show();
         }
            
        /*} catch (SQLException ex) { 
            System.out.println("error" + ex.getMessage());
        }*/
    }
    

    @FXML
    private void retournerHome(ActionEvent event) {
        
        try {

            Parent loader = FXMLLoader.load(getClass().getResource("page_de_garde.fxml"));
            retour_btn.getScene().setRoot(loader);
       
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
        
    }
    
    
    private boolean controleDeSaisie() {
        if (matriculetf.getText().length()<7)
            return false;
        if (marquetf.getText().length()<3)
            return false;
        return true;
    }
    
}
