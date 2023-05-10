/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import entities.Vehicule;
import java.util.List;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import services.VehiculeService;



/**
 * FXML Controller class
 *
 * @author amens
 */
public class AfficherVehiculeController implements Initializable {

    @FXML
    private Label tttt;
    @FXML
    private VBox VboxLivreur;

    VehiculeService VS = new VehiculeService ();
    Vehicule v = new Vehicule();
        private List<Vehicule> Vec = new VirtualFlow.ArrayLinkedList<>();
    @FXML
    private TextField search;
    int aux=0;

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         try { 
            Vec = VS.recuperer();

        } catch (SQLException ex) {
            Logger.getLogger(AfficherLivreurController.class.getName()).log(Level.SEVERE, null, ex);
        }
         this.AFFICHERLESVEHICULES();
        
    }    

    @FXML
    private void Ajouter_Vehicule(ActionEvent event) {
        
         try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterVehicule.fxml"));
            Parent root = (Parent)loader.load();
            AjouterVehiculeController controller = (AjouterVehiculeController)loader.getController();
            tttt.getScene().setRoot(root);
         
        
        } catch (Exception e) {
             System.out.println(e);
                
        }
        
    }
    
        
public void AFFICHERLESVEHICULES(){
    for(int i=0 ; i<Vec.size() ; i++)
    {
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("VehiculeView.fxml"));
        
        try {
            
            HBox hbox = fxmlloader.load();
            VehiculeViewController Lvc = fxmlloader.getController();
            Lvc.SetVehicule(Vec.get(i));
            VboxLivreur.getChildren().add(hbox);
            
            
        }
        catch(IOException e)
                {
                    e.printStackTrace();
                }
       
    }

}

    @FXML
    private void TrierParCat(MouseEvent event) throws SQLException {
        VboxLivreur.getChildren().clear();
         Vec=VS.recupererTrier();
        this.AFFICHERLESVEHICULES();
         System.out.println("Done");
    }

    @FXML
    private void searchhh(KeyEvent event) throws SQLException {
        System.out.println(aux);
        //System.out.println(word.charAt(1) + " chhh");
        String x = search.getText();
        aux = x.length();
        System.out.println(x);        
        System.out.println(aux); 
 
        Vec=VS.recuperer(aux, x);
        VboxLivreur.getChildren().clear();
        this.AFFICHERLESVEHICULES();
    }
    }

