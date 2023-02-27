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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author amens
 */
public class MainAjouter extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AfficherColis.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root , 1200 , 700);
        
        primaryStage.setTitle("Colis");
        primaryStage.setScene(scene);
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
