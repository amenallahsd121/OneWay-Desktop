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
public class reponse extends Application {
    
    @Override
    public void start(Stage primaryStage) {
               try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ajouter_reponse.fxml"));
        Parent root1 = loader.load();
        Scene scene1 = new Scene(root1 , 1100 , 700);
       
        primaryStage.setTitle("Ajouter reponse");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
        catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
