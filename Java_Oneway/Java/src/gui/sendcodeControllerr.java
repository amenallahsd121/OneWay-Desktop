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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.utilisateurService;

/**
 * FXML Controller class
 *
 * @author wwwou
 */
public class sendcodeControllerr implements Initializable {

    @FXML
    private TextField AdL;
    @FXML
    private Button closebutton;
    @FXML
    private TextField idc;
    utilisateurService us = new utilisateurService();    
    utilisateur user = new utilisateur();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
public void setTextField(int id ) {

        
        idc.setText(Integer.toString(id));
        idc.setVisible(false);

    }
    @FXML
    private void savechanges(ActionEvent event) throws SQLException, IOException {
        int getmeid = Integer.parseInt(idc.getText()); 
         
         System.out.println(getmeid ); 
        user = us.getusercode(getmeid);
     
        
        
        Stage stage = (Stage) closebutton.getScene().getWindow();
        stage.close();
        
       if(user.getId() == Integer.parseInt(AdL.getText()))
        {
            
            
            
         FXMLLoader loader = new FXMLLoader ();
    loader.setLocation(getClass().getResource("Newpassword.fxml"));
    loader.load();

            gui.NewpasswordController sendController = loader.getController();
       // System.out.println(user.getId());
    sendController.setTextField(getmeid);
    Parent parent = loader.getRoot();
    Stage ss = new Stage();
    ss.setScene(new Scene(parent));
    ss.initStyle(StageStyle.UTILITY);
    ss.show();
            
           // System.out.println("SimpleEmail Start");
	   // String mail=getemail;
	   // EmailUtil.sendEmail(mail);
        }
       // System.out.println(locM.getId()); 
        //Stage stage = (Stage) closebutton.getScene().getWindow();
        //stage.close(); 

    }
    
}

