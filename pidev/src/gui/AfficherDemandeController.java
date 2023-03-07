/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Demande;
import entities.Offre;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import services.DemandeService;

/**
 * FXML Controller class
 *
 * @author utilisateur
 */
public class AfficherDemandeController implements Initializable {

    @FXML
    private VBox pnItems;
    @FXML
    private Label Id;
    @FXML
    private Label Description;
DemandeService os = new DemandeService();
    @FXML
    private Label IdOffre;
    @FXML
    private ImageView Document;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void AfficherDemande(Offre o) throws SQLException {
                 IdOffre.setText(Integer.toString(o.getIdOffre()));

        List<Demande> LTO = os.recuperer();
        for (int i = 0; i < LTO.size(); i++) {
            LTO.get(i).getIdOffre();
if(LTO.get(i).getIdOffre()==o.getIdOffre()){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("DemandeLIst.fxml"));

            try {
                HBox hbox = loader.load();
                DemandeLIstController Tc = loader.getController();

                Tc.SetDemande(LTO.get(i));
                hbox.setOnMouseEntered(event -> {
                    hbox.setStyle("-fx-background-color : #0A0E3F");
                });
                hbox.setOnMouseExited(event -> {
                    hbox.setStyle("-fx-background-color : #02030A");
                });
                pnItems.getChildren().add(hbox);

            } catch (IOException e) {
            }

        }}}

    @FXML
    private void Document(MouseEvent event) throws SQLException {

    
         List<Demande>  list=  os.recuperer();

        // Create a new workbook and sheet
        XSSFWorkbook workbook = new XSSFWorkbook();
        String sheetName = "Les Demandes";
        workbook.createSheet(sheetName);

        // Create the header row
        String[] headers = {"DescriptionDemande","IdOffre","IdColis","IdPersonne","prix"};
        Row headerRow = workbook.getSheet(sheetName).createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // Create the data rows
        int rowNum = 1;
       
        for (int i=0 ; i<list.size() ; i++) {
            Row row = workbook.getSheet(sheetName).createRow(rowNum++);
            row.createCell(0).setCellValue(list.get(i).getDescriptionDemande());
            row.createCell(1).setCellValue(list.get(i).getIdOffre());
            row.createCell(2).setCellValue(list.get(i).getIdColis());
            row.createCell(3).setCellValue(list.get(i).getIdPersonne());
            row.createCell(4).setCellValue(list.get(i).getPrix());
        }

        // Show the file chooser dialog
        Stage stage = (Stage) Id.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Events");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel files (.xlsx)", ".xlsx"));
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            // Save the workbook to the selected file
            try {
                FileOutputStream outputStream = new FileOutputStream(file);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
