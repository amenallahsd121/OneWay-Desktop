
package test;

import GUI.HomeController;
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
import javafx.stage.StageStyle;


public class main extends Application {
   HomeController  hr= new  HomeController();
    @Override
    public void start(Stage primaryStage) throws IOException {
       try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/interface.fxml"));
            Parent root = loader.load();
          
             Scene scene = new Scene(root,900,610);            
            //Scene scene = new Scene(root,1370,800);           
           
            

            primaryStage.setScene(scene);
            primaryStage.setTitle("login");
            primaryStage.show();
      

        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
       
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
}
