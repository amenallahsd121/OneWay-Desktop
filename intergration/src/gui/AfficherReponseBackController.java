/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import entities.Reponse;
import services.ReponseService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class AfficherReponseBackController implements Initializable {

    @FXML
    private VBox Vboxrec;

    private List<Reponse> Rep = new VirtualFlow.ArrayLinkedList<>();
    
    ReponseService RS = new ReponseService();
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO

            Rep=RS.recuperer();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherReponseBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.AFFICHERLESRECLAMATION();
        
    }    
    
    
    
    public void AFFICHERLESRECLAMATION(){
    for(int i=0 ; i<Rep.size() ; i++)
    {
       
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("ReponseView2.fxml"));
       
         try {
            
            HBox hbox = fxmlloader.load();
            ReponseView2Controller rvc = fxmlloader.getController();
            rvc.SetReponse(Rep.get(i));
            
            Vboxrec.getChildren().add(hbox);  
        }
        catch(IOException e)
                {
                    e.printStackTrace();
                }
       
    }

}
    
    
}
