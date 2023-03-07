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

    @FXML
    private void PDF(ActionEvent event) {
        
       
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Enregistrer les données");
    File selectedFile = fileChooser.showSaveDialog(Hbox.getScene().getWindow());
 
    if (selectedFile != null) {
        try {
            // Créer un document PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(selectedFile));
            document.open();
 
            // Ajouter les éléments de l'interface utilisateur pour le ticket d'achat
            com.itextpdf.text.Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Paragraph title = new Paragraph("Ticket d'achat", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(10f);
            document.add(title);
 
            com.itextpdf.text.Font regularFont = FontFactory.getFont(FontFactory.HELVETICA, 12);
            Paragraph date = new Paragraph("Date: " + LocalDate.now().toString(), regularFont);
            date.setAlignment(Element.ALIGN_LEFT);
            date.setSpacingAfter(10f);
            document.add(date);
 
            Paragraph produits = new Paragraph("Produits:", regularFont);
            produits.setAlignment(Element.ALIGN_LEFT);
            produits.setSpacingAfter(10f);
            document.add(produits);
 
           
            PdfPTable table = new PdfPTable(6); // 3 colonnes pour Nom, Prix et Quantité
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);
 
            // En-tête de table
            table.addCell(new PdfPCell(new Phrase("Nom", regularFont)));
            table.addCell(new PdfPCell(new Phrase("Prix", regularFont)));
            table.addCell(new PdfPCell(new Phrase("Quantité", regularFont)));
            table.addCell(new PdfPCell(new Phrase("Nom", regularFont)));
            table.addCell(new PdfPCell(new Phrase("Prix", regularFont)));
            table.addCell(new PdfPCell(new Phrase("Quantité", regularFont)));
 
            // Contenu de table
             
                table.addCell(new PdfPCell(new Phrase(name, regularFont)));
                table.addCell(new PdfPCell(new Phrase(C.getType(), regularFont)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(C.getPoids()), regularFont)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(C.getPrix()), regularFont)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(C.getLdepart()), regularFont)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(C.getLdepart()), regularFont)));
            
            document.add(table);
 
            document.close();
        } catch (IOException | DocumentException ex) {
            System.err.println("Erreur lors de l'écriture dans le fichier: " + ex.getMessage());
        }
    } else {
        System.out.println("La sélection de fichier a été annulée");
    }
}
       
          
    
          
}
