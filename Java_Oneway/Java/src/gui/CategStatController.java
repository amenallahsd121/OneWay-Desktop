/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import services.CategorieOffreService;
import services.ReclamationService;

/**
 * FXML Controller class
 *
 * @author amens
 */
public class CategStatController implements Initializable {

    @FXML
    private PieChart chartfor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.Recla();
    }    
    
    private void Recla() {
         CategorieOffreService serv = new CategorieOffreService();
        Integer s1 = serv.Stats("M","TypeOffre");
        Integer s2 = serv.Stats("L","TypeOffre");
        Integer s3 = serv.Stats("S","TypeOffre");
        Integer s4 = serv.Stats("XS","TypeOffre");
        System.out.println(s1 +""+s2+""+s3+""+s4+"");


     ObservableList<PieChart.Data> PieChartData
             =FXCollections.observableArrayList(
                     new PieChart.Data("M",s1),
                     new PieChart.Data("L",s2),
                     new PieChart.Data("S",s3),
                     new PieChart.Data("XS",s4)
                   

             );
     chartfor.setData(PieChartData);
     
    }

    @FXML
    private void retour(ActionEvent event) {
        
          try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FrontOffice.fxml"));
            Parent root = (Parent)loader.load();
            gui.FrontOfficeController controller = (gui.FrontOfficeController)loader.getController();
            chartfor.getScene().setRoot(root);
         
        
        } catch (Exception e) {
             System.out.println(e);
                
        }
        
    }

    
}
