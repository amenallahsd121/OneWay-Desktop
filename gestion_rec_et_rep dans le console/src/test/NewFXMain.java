/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */
public class NewFXMain extends Application {
    
    @Override
    /////////////////// ajouter une reclamation////////////////////////
  
    public void start(Stage primaryStage) throws IOException {
      try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ajouter_reclamation.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root , 1100 , 700);
       
        primaryStage.setTitle("Ajouter reclamation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }

        ////////////////  ajouter une reponse //////////////////////
 
            }
        
        
        
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    

}