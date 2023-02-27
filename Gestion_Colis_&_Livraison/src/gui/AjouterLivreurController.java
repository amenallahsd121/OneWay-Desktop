/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Livreur;
import services.LivreurService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class AjouterLivreurController implements Initializable {

    @FXML
    private ImageView logo;
    @FXML
    private TextField cintf;
    @FXML
    private TextField prenomtf;
    @FXML
    private TextField nomtf;
    @FXML
    private TextField vehiculetf;

    LivreurService LS = new LivreurService();
    /**
     * Initializes the controller class.
     */
    
    
  /////////////////////////////////////////////////////////////////////////////////// INITIALIZE ////////////////////////////////////////////////////////////////
    
    boolean checkifstringisnumber (String s){
        try {
    int i;        
    i = Integer.parseInt(s);
    return true;
            } 
        catch (NumberFormatException e) {
    System.out.println("Input String cannot be parsed to Integer.");
}
        return false;
    }
    
    
    
    /////////////////////////////////////////////////////////////////////////////////// INITIALIZE ///////////////////////////////////////////////////////////////
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    

    
        /////////////////////////////////////////////////////////////////////////////////// ADD LIVREUR ///////////////////////////////////////////////////////////////
    
    @FXML
    private void AjouterLivreur(ActionEvent event) {
        
         try {
             
            Livreur l = new Livreur();
            l.setCin_livreur(cintf.getText());
            l.setPrenom(prenomtf.getText());
            l.setNom(nomtf.getText());
            l.setVehicule(vehiculetf.getText());
            if(cintf.getText().isEmpty() || prenomtf.getText().isEmpty() || nomtf.getText().isEmpty() || vehiculetf.getText().isEmpty())
            {
                
                showMessageDialog(null, "Vérifier Vos Champs" ); 
            }
            else
            if(cintf.getText().length()!=8)
                {
                     showMessageDialog(null, "Le Numéro de CIN Doit Etre Composer de 8 Chiffres"); 
                }
             else
            if(this.checkifstringisnumber(cintf.getText()) == false)
                {
                     showMessageDialog(null, "Le Numéro de CIN Doit Etre Contenir Des Chiffres Seulement"); 
                }
            else
            {
             LS.ajouter(l);
             showMessageDialog(null, "Livreur Ajouté Avec Succès" );    
            }
            
            
        }
        
        catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
    }
         
       
        
        
    }

        /////////////////////////////////////////////////////////////////////////////////// LIVREUR LIST ///////////////////////////////////////////////////////////////
    @FXML
    private void AnnulerLivreur(ActionEvent event) {
        
             
          try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherLivreur.fxml"));
            Parent root = (Parent)loader.load();
              AfficherLivreurController controller = (AfficherLivreurController)loader.getController();
            cintf.getScene().setRoot(root);
         
        
        } catch (Exception e) {
             System.out.println(e);
                
        }
    }
    
    
    
    
    
    
    
    
    
    
}
