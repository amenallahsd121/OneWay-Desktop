/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import entities.CategorieOffre;
import entities.Demande;
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
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import services.DemandeService;

/**
 * FXML Controller class
 *
 * @author utilisateur
 */
public class DemandeFrontController implements Initializable {

    @FXML
    private VBox Vboxrec;
    @FXML
    private Button refresh;
  private List<Demande> Rec = new VirtualFlow.ArrayLinkedList<>();
      DemandeService ds =new DemandeService();
    @FXML
    private Pane discus;
    @FXML
    private Button refresh1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.AFFICHERDemande();
        } catch (SQLException ex) {
            Logger.getLogger(DemandeFrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void refreshdemande(ActionEvent event) {
    }
    public void AFFICHERDemande() throws SQLException{
                        Rec=ds.recuperer();
Demande d= new Demande();
      
    for(int i=0 ; i<Rec.size() ; i++)
    {

    
if(Rec.get(i).getIdPersonne()== 1){
FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("demandelittle.fxml"));
       
         try {
            
            Pane hbox = fxmlloader.load();
            DemandelittleController rvc = fxmlloader.getController();
            rvc.SetDemande(Rec.get(i));
            
            Vboxrec.getChildren().add(hbox);  
        }
        catch(IOException e)
                {
                    e.printStackTrace();
                }}
       
    }
    }

    @FXML
    private void retour(ActionEvent event) {
        
        
        try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FrontOffice.fxml"));
            Parent root = (Parent)loader.load();
            gui.FrontOfficeController controller = (gui.FrontOfficeController)loader.getController();
            Vboxrec.getScene().setRoot(root);
         
        
        } catch (Exception e) {
             System.out.println(e);
                
        }
        
        
        
    }
}
