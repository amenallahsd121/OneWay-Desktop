/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Evenement;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox; 
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import services.EvenementService;


/**
 * FXML Controller class
 *
 * @author Meddeb sofien
 */
public class AfficherEventFrontController implements Initializable {

    @FXML
    private Label tttt;
    @FXML
    private VBox Vbox;
    
    private List<Evenement> list = new VirtualFlow.ArrayLinkedList<>();
    
     Evenement events = new Evenement();
     EvenementService es = new EvenementService();
    @FXML
    private AnchorPane paneMain;
    @FXML
    private TextField search;
    int aux = 0;
    @FXML
    private Button ASC;
    @FXML
    private Button DESC;
    @FXML
    private Button EXCEL;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
//            GUI.switchmode button = new GUI.switchmode();
//        SimpleBooleanProperty isOn = button.switchOnProperty();
//        isOn.addListener(((observable, oldValue, newValue) -> {
//            
//            if(newValue){
//                button.getScene().getRoot().getStylesheets().add(getClass().getResource("Style.css").toString());
//                System.out.println("Ajouter le css");
//            }
//            else{
//                button.getScene().getRoot().getStylesheets().remove(getClass().getResource("Style.css").toString());
//                System.out.println("Supprimer le css");
//                
//            }
//        }));
//        
//        paneMain.getChildren().add(button);
        
        
          try { 
            list = es.recuperer();

        } catch (SQLException ex) {
            
        }
        
        
        
        
        this.AFFICHERLESEVENT();
        
    }    

    @FXML
    private void afficher(ActionEvent event) {
        
         try {
           

            Parent loader = FXMLLoader.load(getClass().getResource("AfficherParticipation.fxml"));
           tttt.getScene().setRoot(loader);
       
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
    }

  
public void AFFICHERLESEVENT() {
       
        
         for(int i=0 ; i<list.size() ; i++)
    {
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("FrontEventS8ira.fxml"));
        
        try {
            HBox hbox = fxmlloader.load();
//            EventS8iraControllor Lvc = fxmlloader.getController();
//            Lvc.SetEvent(list.get(i));
          FrontEventS8iraController Lvc = fxmlloader.getController();
          Lvc.SetEvent(list.get(i));
          
            Vbox.getChildren().add(hbox);
            
            
        }
        catch(IOException e)
                {
                    e.printStackTrace();
                }
       
    }

    }    

    @FXML
    private void searchhh(KeyEvent event) throws SQLException {
                System.out.println(aux);
        //System.out.println(word.charAt(1) + " chhh");
        String x = search.getText();
        aux = x.length();
        System.out.println(x);        
        System.out.println(aux); 
 
        list=es.recuperer(aux, x);
        Vbox.getChildren().clear();
        this.AFFICHERLESEVENT();
    
    }

    @FXML
    private void ASC(ActionEvent event) throws SQLException, InvalidFormatException {
        
        Vbox.getChildren().clear();
         list=es.triUp();
        this.AFFICHERLESEVENT();
         System.out.println("dodo");
         
    }

    @FXML
    private void DESC(ActionEvent event) throws SQLException {
        Vbox.getChildren().clear();
         list=es.triDown();
        this.AFFICHERLESEVENT();
         System.out.println("dodo");
    }

    @FXML
    private void EXCEL(ActionEvent event) throws SQLException {
          List<Evenement> events =  es.recuperer();

        // Create a new workbook and sheet
        XSSFWorkbook workbook = new XSSFWorkbook();
        String sheetName = "Evenement";
        workbook.createSheet(sheetName);

        // Create the header row
        String[] headers = {"ID", "NOM", "DESCRIPTION", "AWARDS ", "Date de début", "Date de FIN"};
        Row headerRow = workbook.getSheet(sheetName).createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // Create the data rows
        int rowNum = 1;
       
        for (int i=0 ; i<list.size() ; i++) {
            Row row = workbook.getSheet(sheetName).createRow(rowNum++);
            row.createCell(0).setCellValue(list.get(i).getId_event());
            row.createCell(1).setCellValue(list.get(i).getNom());
            row.createCell(2).setCellValue(list.get(i).getDescription());
            row.createCell(3).setCellValue(list.get(i).getAwards());
            row.createCell(4).setCellValue(list.get(i).getDate_debut());
            row.createCell(5).setCellValue(list.get(i).getDate_fin());
        }

        // Show the file chooser dialog
        Stage stage = (Stage) tttt.getScene().getWindow();
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
