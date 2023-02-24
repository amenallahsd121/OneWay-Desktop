/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.sql.SQLException;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import entities.Colis;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import static javax.swing.JOptionPane.showMessageDialog;
import services.ColisService;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class AfficherColisController implements Initializable {

    @FXML
    private TableView<Colis> colisTV;
    @FXML
    private TableColumn<Colis, Float> poidsTV;
    @FXML
    private TableColumn<Colis, String> typeTV;
    @FXML
    private TableColumn<Colis, String> lieudTV;
    @FXML
    private TableColumn<Colis, String> lieuaTV;
    @FXML
    private TableColumn<Colis, Button> Delete;
     @FXML
    private Label welcomeLb;
    
 ColisService CS = new ColisService();
    @FXML
    private Button retourbutton;
    @FXML
    private TableColumn<Colis, Button> Modifier;

    
    
  
     
     
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
           
            List<Colis> Coliett = CS.recuperer();
            ObservableList<Colis> olc = FXCollections.observableArrayList(Coliett);
            
            
            poidsTV.setCellValueFactory(new PropertyValueFactory<Colis, Float>("poids"));
            typeTV.setCellValueFactory(new PropertyValueFactory<Colis, String>("type"));
            lieudTV.setCellValueFactory(new PropertyValueFactory<Colis, String>("Ldepart"));
            lieuaTV.setCellValueFactory(new PropertyValueFactory<Colis, String>("Larrive"));
            this.delete();
            this.update();
            
      
        
        colisTV.setItems(olc);
      
    }
            catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }
        
    
         

    
    
    
    
    
    
    
    
    
    
    public void delete() {
        Delete.setCellFactory((param) -> {
            return new TableCell() {
                @Override
                protected void updateItem(Object item, boolean empty) {
                    setGraphic(null);
                    if (!empty) {
                        Button b = new Button("Supprimer");
                        b.setOnAction((event) -> {
                            try {
                                if (CS.supprimer(colisTV.getItems().get(getIndex())))
                                        {
                                            
                                    
                                    colisTV.getItems().remove(getIndex());
                                    colisTV.refresh();
                                     showMessageDialog(null, "Colis Supprimé Avec Succès" );
                                    
                                         }
                            } catch (SQLException ex) {
                                System.out.println("erreor:" + ex.getMessage());

                            }

                        });
                        setGraphic(b);

                    }
                }
            };

            
        });
        
    }
        
        
        
        
        
        
        
        
        
        
    public void update() {
    
        
         Modifier.setCellFactory((param) -> {
            return new TableCell() {
                @Override
                protected void updateItem(Object item, boolean empty) {
                    setGraphic(null);
                    if (!empty) {
                        Button b = new Button("Modifier");
                        b.setOnAction((event) -> {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierColis.fxml"));
                             ModifierColisController.getIdd(colisTV.getItems().get(getIndex()));
                             
                            try {
                                  Parent root = loader.load();
                                  welcomeLb.getScene().setRoot(root);
                                  colisTV.refresh();
                                  
                                
                                
                                  

                                         } catch (IOException ex) {
                                Logger.getLogger(AfficherColisController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                           

                            

                        });
                        setGraphic(b);

                    }
                }
            };

            
        });
        
        
        
        
        
        

    }
    
    
    

    
    
    @FXML
    private void retour(ActionEvent event) throws IOException {
        
        
        
              FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterColis.fxml"));
              Parent root = loader.load();
              welcomeLb.getScene().setRoot(root);
            
              
               
              
          
    }
    
}
