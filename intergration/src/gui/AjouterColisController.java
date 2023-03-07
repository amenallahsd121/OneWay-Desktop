/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.java.swing.plaf.windows.resources.windows;
import entities.Colis;
import java.io.IOException;
import services.ColisService;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class AjouterColisController implements Initializable {

   
    @FXML
    private TextField poidstf;
    @FXML
    private ChoiceBox<String> typetf;
    @FXML
    private ChoiceBox<String> lieudtf;
    @FXML
    private ChoiceBox<String> lieuatf;
    @FXML
    private ComboBox<Integer> id_clienttf;
    
     private String [] gouvernorat = {"Ariana","Béja","Ben Arous","Bizerte","Gabès","Gafsa","Jendouba","Kairouan","Kasserine","Kébili","Kef","Mahdia","Manouba","Médenine","Monastir","Nabeul","Sfax","Sidi Bouzid","Siliana","Sousse","Tataouine","Tozeur","Tunis","Zaghouan"};
    
    private String [] type = {"Agro-Alimentaire","Matériel Electronique","Meubles","Pièces Automobiles"};
     Colis C = new Colis();
    ColisService CS = new ColisService();
 
    
    /**
     * Initializes the controller class.
     */
    
     boolean checkifstringisnumber (String s){
        try {
    float f;        
     f = Float.parseFloat(s);
    return true;
            } 
        catch (NumberFormatException e) {
    System.out.println("Input String cannot be parsed to Integer.");
}
        return false;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        typetf.getItems().addAll(type);
        lieudtf.getItems().addAll(gouvernorat);
        lieuatf.getItems().addAll(gouvernorat);
        ObservableList<Integer> list = FXCollections.observableArrayList();
        list=CS.getidclient();
        id_clienttf.setItems(list);      
    }    


    @FXML
    private void AjouterColis(ActionEvent event) throws IOException {
         
                    try {
             
           
            C.setId_client(id_clienttf.getValue());
            C.setType(typetf.getValue());
            C.setPoids(Float.parseFloat(poidstf.getText())); 
            C.setPrix(C.getPoids()*3);
            C.setLdepart(lieudtf.getValue());
            C.setLarrive(lieuatf.getValue());
            
            
             
         
                
                 Alert alert = new Alert(Alert.AlertType.WARNING);
                 alert.setTitle("Confirmer Colis");
                 alert.setHeaderText(null);
                 alert.setContentText("Le Prix De Colis Est de "+C.getPrix()+" DT ");
                 ButtonType cancelBtn = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);
                 alert.getButtonTypes().setAll(cancelBtn, ButtonType.OK);
                 Optional<ButtonType> result = alert.showAndWait();
                 
                 if (result.isPresent() && result.get() == ButtonType.OK) {
                     
                     /////////////////////////////////////////////////////
                                    
                   
                       
                     
                      CS.ajouter(C);
                     showMessageDialog(null, "Colis Ajouté Avec Succès" );    
                     

                     ////////////////////////////////////////////////////
        
            }
                 else
            {
               showMessageDialog(null, " Ajout Annuler" );       
            } 
            
           
            
            
            
        }
        
        catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
    }
         
       
        
        
    }

    @FXML
    private void AnnulerColis(ActionEvent event) {
        
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FrontOffice.fxml"));
            Parent root = (Parent)loader.load();
            FrontOfficeController controller = (FrontOfficeController)loader.getController();
            
            typetf.getScene().setRoot(root);
            lieudtf.getScene().setRoot(root);
            lieuatf.getScene().setRoot(root);
            poidstf.getScene().setRoot(root);
             }
         
         catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
        
    }

    @FXML
    private void PAYER(ActionEvent event) {
    
    
    
     
                           FXMLLoader loader = new FXMLLoader ();
                     loader.setLocation(getClass().getResource("Paiement.fxml"));
       
        
        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(PaiementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
                     Parent parent = loader.getRoot();
                     Stage stage = new Stage();
                     stage.setScene(new Scene(parent));
                     stage.initStyle(StageStyle.UTILITY);
                     stage.show();
                          
               
        }
    
}
