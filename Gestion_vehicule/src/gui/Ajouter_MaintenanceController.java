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
import entities.Maintenance;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import services.MaintenanceService;

/**
 * FXML Controller class
 *
 * @author Houda
 */
public class Ajouter_MaintenanceController implements Initializable {

    @FXML
    private TextField etattf;
    @FXML
    private TextField nomtf;
    
    MaintenanceService ms = new MaintenanceService();
    @FXML
    private Button retour_btn;
    @FXML
    private Label IdVehicule;
    @FXML
    private TextField idvehtf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void affichermaintenance(ActionEvent event) {
        try {
           /* FXMLLoader loader = new FXMLLoader(getClass().getResource("Afficher_Maintenance.fxml"));
            Parent root = loader.load();
            Afficher_VehiculeController controller = loader.getController();
            controller.setData(etattf.getText() + " " + nomtf.getText());
       */
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Afficher_Maintenance.fxml"));
            Parent root = (Parent)loader.load();
            Afficher_maintenanceController controller = (Afficher_maintenanceController)loader.getController();
            etattf.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }

    @FXML
    private void ajoutermaintenance(ActionEvent event) throws SQLException {
        
       // try {
              if (controleDeSaisie()) {

            Maintenance m = new Maintenance();
            m.setEtat(etattf.getText());
            m.setNom_soc_rep(nomtf.getText());
            m.setId_vehicule(Integer.valueOf(idvehtf.getText()));

            ms.ajouter(m);
            System.out.println("Maintenance ajouter avec succes");
            
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
       /* } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        }*/ 
    }
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
        if (etattf.getText().length()<4)
            return false;
        if (nomtf.getText().length()<4)
            return false;
        return true;
    }
    
}
