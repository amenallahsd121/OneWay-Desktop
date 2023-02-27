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
 * @author Houda
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       /* try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/Ajouter_vehicule.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root , 700 , 500);
       
        primaryStage.setTitle("gestion vehicule ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }*/
        
       /* try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/Ajouter_categorie.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root , 1100 , 700);
       
        primaryStage.setTitle("Ajouter Categorie");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }

    }*/
    
           try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/page_de_garde.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root , 700 , 500);
       
        primaryStage.setTitle("GESTION VEHICULE ");
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

          
