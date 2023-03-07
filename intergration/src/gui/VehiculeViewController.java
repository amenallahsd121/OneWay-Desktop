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
import entities.Vehicule;
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
import services.VehiculeService;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class VehiculeViewController implements Initializable {

    @FXML
    private HBox Hbox;
    @FXML
    private Label matricule;
    @FXML
    private Label marque;
    @FXML
    private Label idcatveh;
    Vehicule v = new Vehicule();
    VehiculeService VS = new VehiculeService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void UpdateVehicule(ActionEvent event) {
        
         ModifierVehiculeController.getIdd(v);
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierVehicule.fxml"));
            Parent root = loader.load();
            marque.getScene().setRoot(root);
        } catch (Exception e) {
        }
        
    }

    @FXML
    private void DeleteVehicule(ActionEvent event) {
         try {
            VS.supprimer(v);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BackOffice.fxml"));
              Parent root = (Parent)loader.load();
              BackOfficeController controller = (BackOfficeController)loader.getController();
                 matricule.getScene().setRoot(root);
        
        } catch (Exception e) {
        }
        
        
    }
    
     public void SetVehicule(Vehicule V)
    {
       
        matricule.setText(V.getMatricule());
        marque.setText(V.getMarque());
        idcatveh.setText(Integer.toString(V.getId_categorie()));
        v=V;
        
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
            Paragraph title = new Paragraph("Vehicule", titleFont);
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
 
           
            PdfPTable table = new PdfPTable(3); // 3 colonnes pour Nom, Prix et Quantité
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);
 
            // En-tête de table
            table.addCell(new PdfPCell(new Phrase("Matricule", regularFont)));
            table.addCell(new PdfPCell(new Phrase("Marque", regularFont)));
            table.addCell(new PdfPCell(new Phrase("ID Categorie", regularFont)));
          
 
            // Contenu de table
             
                table.addCell(new PdfPCell(new Phrase(v.getMatricule(), regularFont)));
                table.addCell(new PdfPCell(new Phrase(v.getMarque(), regularFont)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(v.getId_categorie()), regularFont)));
               
            
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
    

