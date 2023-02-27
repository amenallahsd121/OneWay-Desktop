/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import entities.Livraison;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.LivraisonService;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class AfficherLivraisonController implements Initializable {

    @FXML
    private ImageView logo;

     private List<Livraison> livraison = new VirtualFlow.ArrayLinkedList<>();
    LivraisonService LS = new LivraisonService();
    
    
    @FXML
    private VBox Vboxlivraison;
    
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        try { 
            livraison = LS.recuperer();
            
        } catch (SQLException ex) {
            Logger.getLogger(AfficherLivraisonController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        this.AFFICHERLESLIVRAISONS();
    }    
    
    
    
    
    
    
    public void AFFICHERLESLIVRAISONS(){
    for(int i=0 ; i<livraison.size() ; i++)
    {
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("LivraisonView.fxml"));
        
        try {
            
            HBox hbox = fxmlloader.load();
            LivraisonViewController LVC = fxmlloader.getController();
            LVC.SetLivraison(livraison.get(i));
            Vboxlivraison.getChildren().add(hbox);
             
        }
        
        catch(IOException e)
                {
                    e.printStackTrace();
                }
       
    }

}
}
