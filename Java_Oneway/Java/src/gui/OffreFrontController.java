/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Offre;
import java.awt.Insets;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import jdk.nashorn.api.scripting.JSObject;
import services.OffreService;

/**
 * FXML Controller class
 *
 * @author utilisateur
 */
public class OffreFrontController implements Initializable {

    @FXML
    private Pagination pignation;
    OffreService os = new OffreService();

    /**
     * Initializes the controller class.
     */
    private int itemsPerPage = 4;
    private WebView webview;
    @FXML
    private TextField filterTextField;
    @FXML
    private ImageView Demandes;
    @FXML
    private ImageView offre;
    @FXML
    private ImageView MesOffres;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
        List<Offre> LTO = os.recuperer();
this.add(LTO);
             this.FilterList();
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(OffreFrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     private void Map() {

WebEngine engine = webview.getEngine();
    engine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue == Worker.State.SUCCEEDED) {
            JSObject window = (JSObject) engine.executeScript("window");
            window.setMember("java", new JavaBridge());
            engine.executeScript("initMap()");
        }
    });
    engine.load(getClass().getResource("/googlemaps.html").toExternalForm());}

    @FXML
    private void demande(MouseEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("DemandeFront.fxml"));
            Parent root = (Parent)loader.load();
            DemandeFrontController controller = loader.getController();
            Demandes.getScene().setRoot(root);
    }

    @FXML
    private void ajouter(MouseEvent event) {
    }

    @FXML
    private void stat(MouseEvent event) {
        
          
        try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CategStat.fxml"));
            Parent root = (Parent)loader.load();
            GUI.CategStatController controller = (GUI.CategStatController)loader.getController();
            offre.getScene().setRoot(root);
         
        
        } catch (Exception e) {
             System.out.println(e);
                
        }
    }
    
    
    
     public class JavaBridge {
    public void log(String message) {
        System.out.println(message);
    }
}
private List listoffre() throws ParseException, SQLException {
    List<Offre> LTO = os.recuperer();
System.out.println("Size of LTO: " + LTO.size());

    // Sort the list based on the date field
    Collections.sort(LTO, (o1, o2) -> o1.getDateOffre().compareTo(o2.getDateOffre()));

    return LTO;
}

        private Pane mod(Offre O) throws ParseException, SQLException, IOException {// Load items from database or other data source
  FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("OffreFrontAffiche.fxml"));

                Pane hbox;
                    hbox = loader.load();

                    OffreFrontAfficheController Tc = loader.getController();

                    Tc.SetTrajet(O);
                    hbox.setOnMouseEntered(event -> {
                        hbox.setStyle("-fx-background-color : #4682B4;-fx-border-radius: 30;");

                    });
                    hbox.setOnMouseExited(event -> {

            hbox.setStyle("-fx-background-color: white; -fx-border-color: grey; -fx-border-radius: 30;");
                       
                    });



        return  hbox;}
    private void add(List LTO) throws ParseException, SQLException {// Load items from database or other data source
       
        // Calculate total number of pages
        int totalPages = (int) Math.ceil((double) LTO.size() / itemsPerPage);

        // Set page count of pagination control
        pignation.setPageCount(totalPages);

        // Set page factory of pagination control
        pignation.setPageFactory(pageIndex -> {
            // Calculate starting and ending indexes of page
            int startIndex = pageIndex * itemsPerPage;
            int endIndex = Math.min(startIndex + itemsPerPage, LTO.size());
// Create a new sublist of items for the page
            List<Offre> pageItems = FXCollections.observableArrayList(LTO.subList(startIndex, endIndex));
                                VBox pageBox = new VBox();

  for (int i = 0; i < pageItems.size(); i++) {
              System.out.println(pageItems.get(i));
                try {
                    Pane pane =this.mod(pageItems.get(i));
                    pageBox.getChildren().add(pane);
                } catch (ParseException ex) {
                    Logger.getLogger(OffreFrontController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(OffreFrontController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(OffreFrontController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        return pageBox;
        });}






    @FXML
       private void FilterList() throws ParseException, SQLException {// Load items from database or other data source


    List<Offre> LTO = os.recuperer();

        // Set up a listener on the text property of the TextField
       filterTextField.textProperty().addListener((observable, oldValue, newValue) -> {
        try {
                        System.out.println(newValue);

            this.filterList(newValue);
        } catch (SQLException ex) {
            Logger.getLogger(OffreFrontController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(OffreFrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
});
        

  

    
    }

    private void filterList(String filter) throws SQLException, ParseException {
            List<Offre> LTO = os.recuperer();
        List <Offre> filteredList = FXCollections.observableArrayList();

        // If the filter is empty, show all items
        if (filter == null || filter.trim().isEmpty()) {
            filteredList=LTO;
        }else{

        // Filter the list based on the filter text
        for (Offre item : LTO) {
            if (item.getIdTrajetOffre().contains(filter)||item.getCatOffreId().contentEquals(filter)) {
                System.out.println(LTO);

                filteredList.add(item);

            }
            
        }                  
}this.add(filteredList); 
                   
 }}

