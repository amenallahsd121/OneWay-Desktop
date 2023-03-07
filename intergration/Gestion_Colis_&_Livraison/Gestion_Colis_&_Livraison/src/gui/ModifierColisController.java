/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Colis;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import static javax.swing.JOptionPane.showMessageDialog;
import services.ColisService;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class ModifierColisController implements Initializable {

    @FXML
    private ImageView logo;
    @FXML
    private TextField poidstf;
    @FXML
    private ChoiceBox<String> typetf;
    @FXML
    private ChoiceBox<String> lieudtf;
    @FXML
    private ChoiceBox<String> lieuatf;
    
    String poids,lieud,lieua,type;
    int id_user;
     private String [] gouvernorat = {"Ariana","Béja","Ben Arous","Bizerte","Gabès","Gafsa","Jendouba","Kairouan","Kasserine","Kébili","Kef","Mahdia","Manouba","Médenine","Monastir","Nabeul","Sfax","Sidi Bouzid","Siliana","Sousse","Tataouine","Tozeur","Tunis","Zaghouan"};
    
    private String [] types = {"Agro-Alimentaire","Matériel Electronique","Meubles","Pièces Automobiles "};
    
    private static int id;

    Colis C = new Colis();  
    Colis Col = new Colis();  
    ColisService CS = new ColisService();
    
    
  
     /////////////////////////////////////////////////////////////////// GET ID LIVREUR FUNCTION //////////////////////////////////////////////////////////////
    
     public static int getIdd(Colis col) {
        
        id = col.getId();
         System.out.println(id);
   
        return id;
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          typetf.getItems().addAll(types);
        lieudtf.getItems().addAll(gouvernorat);
        lieuatf.getItems().addAll(gouvernorat);
        
         Col=CS.TrouverById(id);
         id_user=Col.getId_client();
         poids=Double.toString(Col.getPoids());
         type=Col.getType();
         lieud=Col.getLdepart();
         lieua=Col.getLarrive();
         
         
         
         poidstf.setText(poids);
         typetf.setValue(type);
         lieudtf.setValue(lieud);
         lieuatf.setValue(lieua);
         
         
    }    

    @FXML
    private void AfficherAfeecterColis(ActionEvent event) {
    }

    @FXML
    private void AfficherLivreur(ActionEvent event) {
    }

    
    
    
    
    
    
    @FXML
    private void ModifierColis(ActionEvent event) {
        
         try {
           
            C.setId(id);
            C.setId_client(id_user);
            C.setType(typetf.getValue());
            C.setPoids(Float.parseFloat(poidstf.getText())); 
            C.setPrix(C.getPoids()*3);
            C.setLdepart(lieudtf.getValue());
            C.setLarrive(lieuatf.getValue());
            
            
            
            
            if(poidstf.getText().isEmpty())
            {
                
                showMessageDialog(null, "Vérifier Vos Champs" ); 
            }
            else    
            {
                
                 Alert alert = new Alert(Alert.AlertType.WARNING);
                 alert.setTitle("Confirmer Colis");
                 alert.setHeaderText(null);
                 alert.setContentText("Le Prix De Colis Est de "+C.getPrix()+" DT ");
                 ButtonType cancelBtn = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);
                 alert.getButtonTypes().setAll(cancelBtn, ButtonType.OK);
                 Optional<ButtonType> result = alert.showAndWait();
                 
                 if (result.isPresent() && result.get() == ButtonType.OK) {
               
                     CS.modifier(C);
                     showMessageDialog(null, "Colis Modifier Avec Succès" );    
            }
                 else
            {
               showMessageDialog(null, " Modification Annuler" );       
            } 
            }
            }
            
            
         catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        }
}
        
    

    @FXML
    private void AnnulerColis(ActionEvent event) {
        
         try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BackOffice.fxml"));
            Parent root = (Parent)loader.load();
            BackOfficeController controller = (BackOfficeController)loader.getController();
            typetf.getScene().setRoot(root);
             
        
        } catch (Exception e) {
             System.out.println(e);
                
        }
         
    }
    
}
