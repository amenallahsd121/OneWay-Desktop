/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.AffectationOpColis;
import Entities.Opportunite;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.Notifications;
import services.AffectationService;
import services.OpporuniteService;

/**
 * FXML Controller class
 *
 * @author Meddeb sofien
 */
public class AjouterAffFrontController implements Initializable {

    @FXML
    private ComboBox<Integer> comboOp;
    @FXML
    private Button ajouterbtn;
    @FXML
    private ComboBox<Integer> comboColis;
    @FXML
    private Button retourbnt;
    
    AffectationOpColis a = new AffectationOpColis();
    AffectationService as = new AffectationService();
    Opportunite e = new Opportunite();
    OpporuniteService os =new OpporuniteService();
    @FXML
    private AnchorPane paneMain;
    @FXML
    private Label id_label;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            GUI.switchmode button = new GUI.switchmode();
        SimpleBooleanProperty isOn = button.switchOnProperty();
        isOn.addListener(((observable, oldValue, newValue) -> {
            
            if(newValue){
                button.getScene().getRoot().getStylesheets().add(getClass().getResource("Style.css").toString());
                System.out.println("Ajouter le css");
            }
            else{
                button.getScene().getRoot().getStylesheets().remove(getClass().getResource("Style.css").toString());
                System.out.println("Supprimer le css");
                
            }
        }));
        
        paneMain.getChildren().add(button);
        
        
//         ObservableList<Integer> list1 = FXCollections.observableArrayList();        
//        list1 = as.idOpDisponible();

        comboOp.setValue(idd);

      // id_label.setText(String.valueOf(e.getId_opp()));
                //     System.out.println(e.getId_opp());

        
        ObservableList<Integer> list2 = FXCollections.observableArrayList();
        list2 = as.idColisDisponible();
        comboColis.setItems(list2);
    }    
     private static int idd;
      
    public static int getIdd(int id) {
        idd = id;
        System.out.println(idd);
        return idd;
        
        
    }
    


    @FXML
    private void AjouterAffectation(ActionEvent event) {
         AffectationOpColis e = new AffectationOpColis();
          e.setIdcolis(comboColis.getValue());
          e.setIdopp(comboOp.getValue());
          int a = 0 ;
          
          
           try {
               as.ajouter(e);
               a=1;
               
             //  reset();
               
           } catch (SQLException ex) {
                
            System.out.println(ex.getMessage());
      }
           if(a==1){
               Alert alert = new Alert(Alert.AlertType.INFORMATION);

              alert.setTitle("Information Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Affectation!");

              alert.show();
              
              Image image=new Image("GUI/ok.png");

        Notifications notifications=Notifications.create();
        notifications.graphic(new ImageView(image));
        notifications.text("SALUT VOUS AVEZ AJOUTER AFFECTATION ");
        notifications.title("Success Message");
        notifications.hideAfter(javafx.util.Duration.seconds(5));
        /*notifications.darkStyle();*/
     /*   notifications.position(Pos.BOTTOM_CENTER);*/
        notifications.show();
           }else{
               Alert alert = new Alert(Alert.AlertType.ERROR);

              alert.setTitle("Information Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Votre colis est deja Affecter! ");

              alert.show();
              Image image=new Image("GUI/error.png");

        Notifications notifications=Notifications.create();
        notifications.graphic(new ImageView(image));
        notifications.text("CE COLIS EST DEJA AFFECTEZ ");
        notifications.title("FAILED Message");
        notifications.hideAfter(javafx.util.Duration.seconds(5));
        /*notifications.darkStyle();*/
     /*   notifications.position(Pos.BOTTOM_CENTER);*/
        notifications.show();
           }
    }


    @FXML
    private void retourhome(ActionEvent event) throws IOException {
        
                
            Parent loader = FXMLLoader.load(getClass().getResource("FrontOffice.fxml"));
           ajouterbtn.getScene().setRoot(loader);
    }
    public  void sett(int id){
        id_label.setText(Integer.toString(id));
    }
    
    

    
}
