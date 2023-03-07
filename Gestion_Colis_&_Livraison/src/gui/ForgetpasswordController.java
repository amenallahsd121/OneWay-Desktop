/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.mail.MessagingException;
import services.utilisateurService;

public class ForgetpasswordController implements Initializable {

    @FXML
    private TextField AdL;
    @FXML
    private Button closebutton;
    String getemail;
    utilisateurService us = new utilisateurService();    
    utilisateur user = new utilisateur();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   
    @FXML
    private void savechanges(ActionEvent event) throws SQLException, MessagingException, IOException {
        Random random = new Random(); 
        int b = (int)(Math.random()*(9999-1000+1)+1000); 
          getemail = AdL.getText(); 
         //locM.setId_delai(1);
         System.out.println(getemail ); 
        user = us.rechercherEmail(getemail);
        System.out.println(user);
      
            System.out.println("SimpleEmail Start");
	    String mail = getemail;
            System.out.println(mail);
	    EmailUtil.sendEmail(mail,b);
            user.setCode(b);
            System.out.println(user.getId());            
            System.out.println(user.getCode());
            us.modifierCode(user);
    Stage stage = (Stage) closebutton.getScene().getWindow();
        stage.close();
            /////
             FXMLLoader loader = new FXMLLoader ();
    loader.setLocation(getClass().getResource("sendcode.fxml"));
    loader.load();

    sendcodeControllerr sendController = loader.getController();
       // System.out.println(user.getId());
    sendController.setTextField(user.getId());
    Parent parent = loader.getRoot();
    Stage ss = new Stage();
    ss.setScene(new Scene(parent));
    ss.initStyle(StageStyle.UTILITY);
    ss.show();
            
        
        
       
    }
    
}
