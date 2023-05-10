
package GUI;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import entities.utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.utilisateurService;


public class HomeController implements Initializable {

    
    @FXML
    private VBox pnItems;
    

    public VBox getPnItems() {
        return pnItems;
    }

    public void setPnItems(VBox pnItems) {
        this.pnItems = pnItems;
    }
    private List<utilisateur> Liv = new VirtualFlow.ArrayLinkedList<>();
     utilisateurService LS = new utilisateurService();
     
     private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Pane btnOrders;
    @FXML
    private TextField search;
    int aux = 0;

  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        
          try { 
            Liv = LS.recupererUser();

        } catch (SQLException ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.afficherutilisateur();
        
        
    }    

   
    
    public void afficherutilisateur(){
        //System.out.println(Liv.size());
    for(int i=0 ; i<Liv.size() ; i++)
    {
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("../GUI/item.fxml"));
        
        try {
            HBox hbox = fxmlloader.load();
            ItemController Lvc = fxmlloader.getController();
            System.out.println(Liv.get(i).getId());
            Lvc.Setutilisateur(Liv.get(i));
            hbox.setOnMouseEntered(event -> {
                    hbox.setStyle("-fx-background-color : #0A0E3F");
                });
                hbox.setOnMouseExited(event -> {
                    hbox.setStyle("-fx-background-color : #02030A");
                });
            pnItems.getChildren().add(hbox);
    
        }
        catch(IOException e)
                {
                }    
    }

}
    @FXML
    private void refresh(ActionEvent event) throws IOException, SQLException {
         
         pnItems.getChildren().clear();
         Liv=LS.recupererUser();
        this.afficherutilisateur();
       
    }
    @FXML
    private void searchhh(KeyEvent event) throws SQLException {
        
        
        System.out.println(aux);
        //System.out.println(word.charAt(1) + " chhh");
        String x = search.getText();
        aux = x.length();
        System.out.println(x);        
        System.out.println(aux); 
 
        Liv=LS.recuperer(aux, x);
        pnItems.getChildren().clear();
        this.afficherutilisateur();
    }

    @FXML
    private void triUp(MouseEvent event) throws SQLException {
        pnItems.getChildren().clear();
         Liv=LS.triUp();
        this.afficherutilisateur();
         System.out.println("dodo");
    }

    @FXML
    private void triDown(MouseEvent event) throws SQLException {
        pnItems.getChildren().clear();
         Liv=LS.triDown();
        this.afficherutilisateur();
         System.out.println("dodo");
    }
    
       
}
