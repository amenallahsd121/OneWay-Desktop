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
import entities.Reponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import static javax.swing.JOptionPane.showMessageDialog;
import services.ReponseService;



/**
 * FXML Controller class
 *
 * @author amens
 */
public class ModifierReponseController implements Initializable {

    @FXML
    private TextField reponse;

    /**
     * Initializes the controller class.
     */
     Reponse Rep = new Reponse();
    ReponseService RS = new ReponseService(); 
    private static int id;
    public static int getIdd(Reponse R) {      
        id = R.getId_rep();
        return id;      
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        Rep=RS.TrouverReponseById(id);
        reponse.setText(Rep.getText_rep());
        
    }    

    @FXML
    private void Modifier(ActionEvent event) {
        
        Reponse R = new Reponse();
        
        R.setId_rep(id);
        R.setId_rec(Rep.getId_rec());
        R.setText_rep(reponse.getText());
        
        
         try {
                RS.modifier(R);
                    showMessageDialog(null, "Reponse Modifier Avec Succès");
            } catch (SQLException ex) {
                Logger.getLogger(ModifierReponseController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    @FXML
    private void Menu(ActionEvent event) {
        
             try {
         
              FXMLLoader loader = new FXMLLoader(getClass().getResource("BackOffice.fxml"));
              Parent root = (Parent)loader.load();
              BackOfficeController controller = (BackOfficeController)loader.getController();
                 reponse.getScene().setRoot(root);
        
        } catch (Exception e) {
             System.out.println(e);
        
        
        
    }
        
    }
    
}
