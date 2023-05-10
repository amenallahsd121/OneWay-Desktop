/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entities.Reclamation;
import entities.Reponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import services.ReclamationService;
import services.ReponseService;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ReclamationViewFrontController implements Initializable {

    @FXML
    private HBox Hbox;
    @FXML
    private Label reclamation;
    @FXML
    private Label reponse;
    @FXML
    private Label Sujet;
    

    Reclamation Re = new Reclamation();
    ReclamationService RSE = new ReclamationService();
    Reponse RP = new Reponse();
    ReponseService RS = new ReponseService();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void Update (ActionEvent event) {
        
        ModifierReclamationController.getIdd(Re);
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierReclamation.fxml"));
            Parent root = loader.load();
            reponse.getScene().setRoot(root);

        } catch (Exception e) {
        }
        
    }

    @FXML
    private void Delete(ActionEvent event) {
        
           try {
               System.out.println(Re);
            RSE.supprimer(Re);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FrontOffice.fxml"));
            Parent root = (Parent)loader.load();
            FrontOfficeController controller = (FrontOfficeController)loader.getController(); 
            reponse.getScene().setRoot(root);
        } catch (Exception e) {
        
    }
    
    }
    
    
     public void SetReclamation(Reclamation R)
    {
       
       RP = RS.TrouverReponseByRecla(R.getId_rec());
       if (RP == null)
       {
        reclamation.setText(R.getText_rec());
        reponse.setText("En Cours");
        Sujet.setText(R.getSujet());
        Re=R;
       }
       else
       {
           reclamation.setText(R.getText_rec());
        reponse.setText(RP.getText_rep());
        Sujet.setText(R.getSujet());
        Re=R; 
           
       }
       
       
        
        
        
      
        
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
            Paragraph title = new Paragraph("Reclamation", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(10f);
            document.add(title);
 
            com.itextpdf.text.Font regularFont = FontFactory.getFont(FontFactory.HELVETICA, 12);
            Paragraph date = new Paragraph("Date: " + LocalDate.now().toString(), regularFont);
            date.setAlignment(Element.ALIGN_LEFT);
            date.setSpacingAfter(10f);
            document.add(date);
 
            Paragraph produits = new Paragraph("Reclamation:", regularFont);
            produits.setAlignment(Element.ALIGN_LEFT);
            produits.setSpacingAfter(10f);
            document.add(produits);
 
           
            PdfPTable table = new PdfPTable(3); // 3 colonnes pour Nom, Prix et Quantité
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);
 
            // En-tête de table
            table.addCell(new PdfPCell(new Phrase("Sujet", regularFont)));
            table.addCell(new PdfPCell(new Phrase("Reclamation", regularFont)));
            table.addCell(new PdfPCell(new Phrase("Reponse", regularFont)));
          
 
            // Contenu de table
             
                table.addCell(new PdfPCell(new Phrase(Re.getSujet(), regularFont)));
                table.addCell(new PdfPCell(new Phrase(Re.getText_rec(), regularFont)));
                table.addCell(new PdfPCell(new Phrase(RP.getText_rep(), regularFont)));
            
            
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
    
    
    

    
