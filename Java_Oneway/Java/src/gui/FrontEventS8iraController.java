/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Evenement;
import Entities.Participation;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import org.controlsfx.control.Notifications;
import services.EvenementService;
import services.ParticipationService;

/**
 * FXML Controller class
 *
 * @author Meddeb sofien
 */
public class FrontEventS8iraController implements Initializable {

    @FXML
    private HBox Hbox;
    @FXML
    private Label nom;
    @FXML
    private Label duree;
    @FXML
    private Label awards;
    @FXML
    private Label id_label;
    @FXML
    private Label description;
    
    Evenement e = new Evenement();
    ParticipationService ps = new ParticipationService();
    EvenementService es = new EvenementService();
    private List<Evenement> list = new VirtualFlow.ArrayLinkedList<>();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         
    }    

    @FXML
    private void Participer(ActionEvent event) throws IOException, SQLException {
          Participation p = new Participation();
          p.setId_event(e.getId_event());
          p.setId_user(ps.getidclientt());
          System.out.println();
         //   List<Integer> l = new ArrayList<Integer>();
      int k= ps.verif_existanceop();
      int i = ps.verif_existanceuser(p.getId_user());
      int j = ps.verif_existanceevent(p.getId_event());
        System.out.println(i+"  "+j);
        int a = ps.getidclientt();
        System.out.println(k);
        //System.out.println(a);
//        System.out.println(l);
//        System.out.println(ps.getidev());
   if(k==0 || i!=j){
       
   
        try {
            ps.ajouter(p);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

              alert.setTitle("Information Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Evenement insérée avec succés!");

              alert.show();
               Parent loader = FXMLLoader.load(getClass().getResource("AfficherParticipation.fxml"));
              id_label.getScene().setRoot(loader);
             


        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
        }
         Image image=new Image("GUI/ok.png");

        Notifications notifications=Notifications.create();
        notifications.graphic(new ImageView(image));
        notifications.text("Bonjour");
        notifications.title("Success Message");
        notifications.hideAfter(javafx.util.Duration.seconds(5));
        /*notifications.darkStyle();*/
     /*   notifications.position(Pos.BOTTOM_CENTER);*/
        notifications.show();
   }else{
       Alert alert = new Alert(Alert.AlertType.ERROR);

              alert.setTitle("Information Dialog");

              alert.setHeaderText(null);

              alert.setContentText("vous etes deja Participer a cet Event!");

              alert.show();
              Image image=new Image("GUI/error.png");

        Notifications notifications=Notifications.create();
        notifications.graphic(new ImageView(image));
        notifications.text("BONJOUR vous etes deja participer");
        notifications.title("FAILED Message");
        notifications.hideAfter(javafx.util.Duration.seconds(5));
        /*notifications.darkStyle();*/
     /*   notifications.position(Pos.BOTTOM_CENTER);*/
        notifications.show();
       
   }
    }
    
       public void SetEvent(Evenement E)
    {
       
        nom.setText(E.getNom());
        awards.setText(E.getAwards());
        description.setText(E.getDescription());
        duree.setText(E.getDate_debut() + " -- " + E.getDate_fin());
         id_label.setText(String.valueOf(E.getId_event()));        
        e=E;
        
    }

    
    
}
