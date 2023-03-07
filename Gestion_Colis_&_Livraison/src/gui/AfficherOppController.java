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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import services.OpporuniteService;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class AfficherOppController implements Initializable {

    @FXML
    private Label tttt;
    @FXML
    private VBox VboxOpp;

    
    
    private List<Opportunite> list = new VirtualFlow.ArrayLinkedList<>();
    Opportunite o = new Opportunite();
    OpporuniteService OS  = new OpporuniteService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         try { 
            list = OS.recuperer();

        } catch (SQLException ex) {
            Logger.getLogger(AfficherOppController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         this.AFFICHERLESOPP();
        
    }    
    
    
    public void AFFICHERLESOPP(){
    for(int i=0 ; i<list.size() ; i++)
    {
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("OppSghira.fxml"));
        
        try {
            HBox hbox = fxmlloader.load();
            OppSghiraController Oppc = fxmlloader.getController();
            Oppc.SetOpp(list.get(i));
            VboxOpp.getChildren().add(hbox);
            
            
        }
        catch(IOException e)
                {
                    e.printStackTrace();
                }
       
    }

}

    @FXML
    private void AjouterOpp(ActionEvent event) {
        
         try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterOpp.fxml"));
            Parent root = (Parent)loader.load();
            AjouterOppController controller = (AjouterOppController)loader.getController();
            tttt.getScene().setRoot(root);
         
        
        } catch (Exception e) {
             System.out.println(e);
                
        }
        
    }
    
    
}
