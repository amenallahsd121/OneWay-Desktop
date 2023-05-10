/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import services.ColisService;
import entities.Colis;
import entities.Livreur;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Ref;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javax.swing.JFrame;
import sun.applet.Main;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class ColisViewController implements Initializable {
    

    @FXML
    private HBox Hbox;
   
    
    Colis C = new Colis();
    ColisService CS = new ColisService();
    @FXML
    private Label poidstf;
    @FXML
    private Label typetf;
    @FXML
    private Label lieudtf;
    @FXML
    private Label lieuatf;
    @FXML
    private Label NomClient_tf;
    @FXML
    private Label prixtf;
    
    private String name;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     
    }    

 

    @FXML
    private void UpdateColis(ActionEvent event) {
        
          ModifierColisController.getIdd(C);
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierColis.fxml"));
            Parent root = loader.load();
            lieuatf.getScene().setRoot(root);

        } catch (Exception e) {
        }
    }

    
    
    @FXML
    private void DeleteColis(ActionEvent event) {
        
         try {
            CS.supprimer(C);
              FXMLLoader loader = new FXMLLoader(getClass().getResource("FrontOffice.fxml"));
            Parent root = (Parent)loader.load();
            lieuatf.getScene().setRoot(root);
        
        } catch (Exception e) {
        }
    }
       
       
    
    
   
    
          public void SetColis(Colis c)
    {
       
        name=CS.TrouvernameById(c.getId_client());
        NomClient_tf.setText(name);
        prixtf.setText(Double.toString(c.getPrix())+" DT");
        poidstf.setText(Double.toString(c.getPoids())+ " Kg");
        typetf.setText(c.getType());
        lieudtf.setText(c.getLdepart());
        lieuatf.setText(c.getLarrive());
        C=c;
       
        
    }

}