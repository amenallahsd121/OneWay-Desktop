/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Maintenance;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import services.MaintenanceService;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class MainViewController implements Initializable {

    @FXML
    private HBox Hbox;
    @FXML
    private Label etat;
    @FXML
    private Label nomsos;
    @FXML
    private Label idveh;
    
     Maintenance m = new Maintenance();
    MaintenanceService MS = new MaintenanceService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void UpdateMain(ActionEvent event) {
        
        ModifierMaintenanceController.getIdd(m);
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierMaintenance.fxml"));
            Parent root = loader.load();
            nomsos.getScene().setRoot(root);
        } catch (Exception e) {
        }
        
    }

    @FXML
    private void DeleteMain(ActionEvent event) {
         try {
            MS.supprimer(m);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BackOffice.fxml"));
              Parent root = (Parent)loader.load();
              BackOfficeController controller = (BackOfficeController)loader.getController();
                 nomsos.getScene().setRoot(root);
        
        } catch (Exception e) {
        }
        
        
        
    }
    
    public void SetMaintenance(Maintenance M)
    {
       
        etat.setText(M.getEtat());
        nomsos.setText(M.getNom_sos_rep());
        idveh.setText(M.getVehicule());
        m=M;
        
    }
    
}
