/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Opportunite;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import static jdk.nashorn.internal.objects.NativeString.search;
import services.OpporuniteService;

/**
 * FXML Controller class
 *
 * @author Meddeb sofien
 */
public class AfficherOpFrontController implements Initializable {

    @FXML
    private Label tttt;
    @FXML
    private VBox Vbox;
    
    
      private List<Opportunite> list = new VirtualFlow.ArrayLinkedList<>();
     Opportunite opp = new Opportunite();
    OpporuniteService os =new OpporuniteService();
    @FXML
    private Button ASC;
    @FXML
    private Button DESC;
    int aux = 0;
    @FXML
    private TextField search;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
//        switchmode button = new switchmode();
//        SimpleBooleanProperty isOn = button.switchOnProperty();
//        isOn.addListener(((observable, oldValue, newValue) -> {
//            
//            if(newValue){
//                button.getScene().getRoot().getStylesheets().add(getClass().getResource("Style.css").toString());
//                System.out.println("Ajouter le css");
//            }
//            else{
//                button.getScene().getRoot().getStylesheets().remove(getClass().getResource("Style.css").toString());
//                System.out.println("Supprimer le css");
//                
//            }
//        }));
//        
//        paneMain.getChildren().add(button);
//        
        
        
        
            try { 
            list = os.recuperer();

        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        }
        
        
        
        
        this.AFFICHERLESOP();
    }    


    private void AFFICHERLESOP() {


       for(int i=0 ; i<list.size() ; i++)
    {
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("FrontOppS8ira.fxml"));
        
        try {
            HBox hbox = fxmlloader.load();
//            EventS8iraControllor Lvc = fxmlloader.getController();
//            Lvc.SetEvent(list.get(i));
          GUI.FrontOppS8iraController Lvc = fxmlloader.getController();
          Lvc.setOp(list.get(i));
         
          
            Vbox.getChildren().add(hbox);
            
            
        }
        catch(IOException e)
                {
                    e.printStackTrace();
                }
       
    }

    }

    @FXML
    private void afficher(ActionEvent event) {
        
          try {
           

            Parent loader = FXMLLoader.load(getClass().getResource("AfficherAffectationfront.fxml"));
           tttt.getScene().setRoot(loader);
       
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
    }

    @FXML
    private void DESC(ActionEvent event) throws SQLException {
           
        Vbox.getChildren().clear();
         list=os.triUp();
        this.AFFICHERLESOP();
         System.out.println("dodo");
        
    }

    @FXML
    private void ASC(ActionEvent event) throws SQLException {
           Vbox.getChildren().clear();
         list=os.triDown();
        this.AFFICHERLESOP();
         System.out.println("dodo");
        
    }

    

    @FXML
    private void searchhh(KeyEvent event) throws SQLException {
         System.out.println(aux);
        //System.out.println(word.charAt(1) + " chhh");
        String x = search.getText();
        aux = x.length();
        System.out.println(x);        
        System.out.println(aux); 
 
        list=os.recuperer(aux, x);
        Vbox.getChildren().clear();
        this.AFFICHERLESOP();
    }
    
    
}
