/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.CategorieOffre;
import entities.TrajetOffre;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.TrajetService;

/**
 * FXML Controller class
 *
 * @author utilisateur
 */
public class TrajetOffreController implements Initializable {

    @FXML
    private HBox itemC;
    @FXML
    private Label description;
    @FXML
    private Label AddresseDeDepart;
    @FXML
    private Label AddresseDarrivee;
    @FXML
    private Label NombreEscale;
    @FXML
    private Label LimiteKm;
    @FXML
    private Label nombreOffre;
TrajetOffre to = new TrajetOffre();
TrajetService ts = new TrajetService();
 private Stage stage;
AffichageTrajetOffreController c ;
    private Scene scene;
    private Parent shit;
    @FXML
    private ImageView Set;
    @FXML
    private ImageView Delete;

    /**
     * Initializes the controller class.
     * @param o
     */
    public void SetTrajet(TrajetOffre o)
    {
       
        description.setText(o.getDescription());
        System.out.println(o.getDescription());
        AddresseDeDepart.setText(o.getAddDepartOffre());
        AddresseDarrivee.setText(o.getAddArriveOffre());
        NombreEscale.setText(String.valueOf(o.getNbreEscaleOffre()));        
        LimiteKm.setText(String.valueOf(o.getLimiteKmOffre()));        
        nombreOffre.setText(String.valueOf(o.getNbreOffre()));
       
        
        to=o;
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


   


    private void TrajetSupp(ActionEvent event) throws SQLException, IOException {
                     TrajetOffre c =new TrajetOffre();
    c.setDescription(description.getText());
    
        try {
            
              Alert alert = new Alert(Alert.AlertType.WARNING);

              alert.setTitle("confirmation ");

              alert.setHeaderText(null);

              alert.setContentText("Voulez-vous supprimer cet " +"?");
              ButtonType cancelBtn = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
             alert.getButtonTypes().setAll(cancelBtn, ButtonType.OK);
              Optional<ButtonType> result = alert.showAndWait();
           
           if (result.isPresent() && result.get() == ButtonType.OK) {
    // User clicked OK 
           ts.supprimer(c);
           
               
} else {
    // User clicked cancel or closed the dialog
               System.out.println("supprission annulee");
    
}
          shit = FXMLLoader.load(getClass().getResource("AffichageTrajetOffre.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(shit);
        stage.setScene(scene);
        stage.show();  
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void TrajetSupp(MouseEvent event) throws IOException {
        TrajetOffre c =new TrajetOffre();
    c.setDescription(description.getText());
    
        try {
            
              Alert alert = new Alert(Alert.AlertType.WARNING);

              alert.setTitle("confirmation ");

              alert.setHeaderText(null);

              alert.setContentText("Voulez-vous supprimer cet " +"?");
              ButtonType cancelBtn = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
             alert.getButtonTypes().setAll(cancelBtn, ButtonType.OK);
              Optional<ButtonType> result = alert.showAndWait();
           
           if (result.isPresent() && result.get() == ButtonType.OK) {
    // User clicked OK 
           ts.supprimer(c);
           
               
} else {
    // User clicked cancel or closed the dialog
               System.out.println("supprission annulee");
    
}
          shit = FXMLLoader.load(getClass().getResource("AffichageTrajetOffre.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(shit);
        stage.setScene(scene);
        stage.show();  
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void TrajetEdit(MouseEvent event) throws IOException, SQLException {
       
        
TrajetOffre o =new TrajetOffre(Integer.parseInt(LimiteKm.getText()),Integer.parseInt(NombreEscale.getText()),AddresseDarrivee.getText(),AddresseDeDepart.getText());
o.setNbreEscaleOffre(Integer.parseInt(NombreEscale.getText()));
o.setLimiteKmOffre(Integer.parseInt(LimiteKm.getText()));
            o.setAddDepartOffre(AddresseDeDepart.getText());
            o.setAddArriveOffre(AddresseDarrivee.getText());

            o.setDescription(description.getText());
      FXMLLoader loader = new FXMLLoader(getClass().getResource("AffichageTrajetOffre.fxml"));
            Parent root = loader.load();
            AffichageTrajetOffreController controller = loader.getController();
    
            controller.ModifierTrajetOffre(o);
                        description.getScene().setRoot(root);

    }

    @FXML
    private void TrajetSupp(TouchEvent event) {
    }


    
  

 
}


    
    
