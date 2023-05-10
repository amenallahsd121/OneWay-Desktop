/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import entities.Reclamation;
import entities.Reponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.ReclamationService;
import services.ReponseService;
/**
 * FXML Controller class
 *
 * @author amens
 */
public class AfficherReclamationBackController implements Initializable {
    
   private List<Reclamation> Rep = new VirtualFlow.ArrayLinkedList<>();
   private List<Integer> ReclamationIDs = new VirtualFlow.ArrayLinkedList<>();
   private List<Integer> ReponseIDs = new VirtualFlow.ArrayLinkedList<>();
   private List<Integer> ReclamationNonTraiteeIDList = new ArrayList<>();
   
   
   ReclamationService RS = new ReclamationService();
   ReponseService RepS = new ReponseService();
    @FXML
    private VBox Vboxrec;
    @FXML
    private TextField search;
    int aux = 0;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
        
        ReclamationIDs=RS.GetALLReclamationID();
        ReponseIDs=RepS.GetALLReponseID();
                
                
                
        for (int i=0 ; i<ReclamationIDs.size() ; i++)
       {
         boolean var=true;  
           for(int j=0 ; j<ReponseIDs.size() && var==true; j++ )
           {
               if(ReclamationIDs.get(i) != ReponseIDs.get(j))
                var=true;
               else
                var=false;
           }
           if (var==true)
           ReclamationNonTraiteeIDList.add(ReclamationIDs.get(i)); 
       
           
       }
        
     try
       {
        Rep=RS.AllReclamationNonTraiteColis(ReclamationNonTraiteeIDList);
       }
        catch (SQLException ex) {
            Logger.getLogger(AfficherReclamationBackController.class.getName()).log(Level.SEVERE, null, ex);
        }
       

        
          this.AFFICHERLESRECLAMATION();

          
    }

public void AFFICHERLESRECLAMATION(){
    for(int i=0 ; i<Rep.size() ; i++)
    {
       
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("reponseview.fxml"));
       
         try {
            
            HBox hbox = fxmlloader.load();
            ReponseviewController rvc = fxmlloader.getController();
            rvc.SetReponse(Rep.get(i));
            
            Vboxrec.getChildren().add(hbox);  
        }
        catch(IOException e)
                {
                    e.printStackTrace();
                }
       
    }

}

    @FXML
    //rechercher
    private void searchhh(KeyEvent event) throws SQLException {
         System.out.println(aux);
        //System.out.println(word.charAt(1) + " chhh");
        String x = search.getText();
        aux = x.length();
        System.out.println(x);
        System.out.println(aux); 
 
        Rep=RS.recuperer(aux, x);
        Vboxrec.getChildren().clear();
        this.AFFICHERLESRECLAMATION();
    }

    @FXML
    ///tri croissnat
    private void tri(ActionEvent event) throws SQLException {
        
        Rep=RS.triUp();
        Vboxrec.getChildren().clear();
        this.AFFICHERLESRECLAMATION(); 
        
    }

    @FXML
    // tri decroissant
    private void tridown(ActionEvent event) throws SQLException {
        Rep=RS.triDown();
        Vboxrec.getChildren().clear();
        this.AFFICHERLESRECLAMATION(); 
    }

    @FXML
    private void stat(ActionEvent event) throws IOException {
        
         FXMLLoader loader = new FXMLLoader ();
    loader.setLocation(getClass().getResource("ReclaStat.fxml"));
    loader.load();
    
    Parent parent = loader.getRoot();
    Stage stage = new Stage();
    stage.setScene(new Scene(parent));
    stage.initStyle(StageStyle.UTILITY);
    stage.show();
        
    }





    
    
}
