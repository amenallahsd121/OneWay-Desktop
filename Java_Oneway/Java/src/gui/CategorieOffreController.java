/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.CategorieOffre;
import entities.TrajetOffre;
import java.io.IOException;
import static java.lang.System.load;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import services.CategorieOffreService;

/**
 * FXML Controller class
 *
 * @author utilisateur
 */
public class CategorieOffreController implements Initializable {

    @FXML
    private HBox box;
    @FXML
    private Pane PANE;
    @FXML
    private Button modifier;
    @FXML
    private Button delete;
    @FXML
    private Label nombre;
    @FXML
    private Label type;
    @FXML
    private Label nom;
        CategorieOffreService cs = new CategorieOffreService();

CategorieOffre o= new CategorieOffre();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      public void setCat(CategorieOffre  O) {
         type.setText(String.valueOf(O.getTypeOffre()));
         nombre.setText(String.valueOf(O.getNbreColisOffre()));
         nom.setText(String.valueOf(O.getPoidsOffre()));
        
      o=O;
       
    }

     @FXML
    private void supprimerCategorie (ActionEvent event ) throws IOException {
   CategorieOffre c =new CategorieOffre();
    c.setTypeOffre(type.getText());
        try {
            
              Alert alert = new Alert(Alert.AlertType.WARNING);

              alert.setTitle("confirmation ");

              alert.setHeaderText(null);

              alert.setContentText("Voulez-vous supprimer cet " +c.getTypeOffre()+"?");
              ButtonType cancelBtn = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
             alert.getButtonTypes().setAll(cancelBtn, ButtonType.OK);
              Optional<ButtonType> result = alert.showAndWait();
           
           if (result.isPresent() && result.get() == ButtonType.OK) {
    // User clicked OK 
           cs.supprimer(c);
           
               
} else {
    // User clicked cancel or closed the dialog
               System.out.println("supprission annulee");
    
} FXMLLoader loader = new FXMLLoader(getClass().getResource("AffichageCategorieOffre.fxml"));
            AnchorPane pane = loader.load();
            AffichageCategorieOffreController controller = loader.getController();
            controller.refresh(event);
         
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void CategorieEdit(ActionEvent event) throws IOException {CategorieOffre o =new CategorieOffre();
o.setNbreColisOffre(Integer.parseInt(nombre.getText()));
            o.setTypeOffre(type.getText());
            o.setPoidsOffre(Float.parseFloat(nom.getText()));

      FXMLLoader loader = new FXMLLoader(getClass().getResource("AffichageCategorieOffre.fxml"));
            Parent root = loader.load();
                AffichageCategorieOffreController controller = loader.getController();
    controller.ModifierCategorieOffre(o);
                        type.getScene().setRoot(root);
    }

   
}

