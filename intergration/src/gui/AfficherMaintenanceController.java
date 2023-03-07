/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import entities.Maintenance;
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
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import services.MaintenanceService;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class AfficherMaintenanceController implements Initializable {

    @FXML
    private Label tttt;
    @FXML
    private VBox VboxLivreur;
    private List<Maintenance> Main = new VirtualFlow.ArrayLinkedList<>();
    MaintenanceService MS = new MaintenanceService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         try { 
            Main = MS.recuperer();

        } catch (SQLException ex) {
            Logger.getLogger(AfficherMaintenanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
      this.AFFICHERLESCATEGORIES();
        
        
        
    }    

    
    
    public void AFFICHERLESCATEGORIES(){
    for(int i=0 ; i<Main.size() ; i++)
    {
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("MainView.fxml"));
        
        try {
            
            HBox hbox = fxmlloader.load();
            MainViewController Lvc = fxmlloader.getController();
            Lvc.SetMaintenance(Main.get(i));
            VboxLivreur.getChildren().add(hbox);
            
            
        }
        catch(IOException e)
                {
                    e.printStackTrace();
                }
       
    }

}    
    
    @FXML
    private void Ajouter_Maintenance(ActionEvent event) {
        
        try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterMaintenance.fxml"));
            Parent root = (Parent)loader.load();
            AjouterMaintenanceController controller = (AjouterMaintenanceController)loader.getController();
            tttt.getScene().setRoot(root);
         
        
        } catch (Exception e) {
             System.out.println(e);
                
        }
        
    }
    
}
