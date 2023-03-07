/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Demande;
import entities.Offre;
import entities.TrajetOffre;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import services.CategorieOffreService;
import services.DemandeService;
import services.OffreService;

/**
 * FXML Controller class
 *
 * @author utilisateur
 */
public class OffreController implements Initializable {

    @FXML
    private HBox itemC;
    @FXML
    private Label description;
    @FXML
    private Hyperlink CategorieOffre;
    @FXML
    private Hyperlink TrajetOffre;
    @FXML
    private Label CategorieColis;
    @FXML
    private Label DateOffre;
    @FXML
    private Label DateSortieOffre;
    @FXML
    private Label PrixOffre;
    @FXML
    private Label Nombredemande;
Offre to = new Offre();
DemandeService ds= new DemandeService();
OffreService os= new OffreService();

    @FXML
    private ImageView list1;
    @FXML
    private Label Id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void mod(Offre o) throws SQLException {int n=0;
             List<Demande>d=ds.recuperer();
             for( int i=0;i<d.size();i++)   {
        if (d.get(i).getIdOffre()==o.getIdOffre()){
       n++; } }   
        o.setNbreDemande(n);
        os.modifier(o);
        
}

 public void SetTrajet(Offre o) throws SQLException
    {
        
       Id.setText(String.valueOf(o.getIdOffre()));
        description.setText(o.getDescriptionOffre());
        System.out.println(o.getDescriptionOffre());
        CategorieOffre.setText(o.getCatOffreId());
        TrajetOffre.setText(o.getIdTrajetOffre());
        DateOffre.setText(o.getDateOffre());
        DateSortieOffre.setText(o.getDateSortieOffre());
        CategorieColis.setText(String.valueOf(o.getIdCatColis()));        
        PrixOffre.setText(String.valueOf(o.getPrixOffre()));   
        
        this.mod(o);
        Nombredemande.setText(String.valueOf(o.getNbreDemande()));
       
        
        to=o;
        
    }
    @FXML
    private void Offre(ActionEvent event) {
    }

    @FXML
    private void Trajet(ActionEvent event) {
    }


    @FXML
    private void listDemande(MouseEvent event) throws IOException, SQLException { to.setIdOffre(Integer.parseInt(Id.getText()));
           

      FXMLLoader loader = new FXMLLoader(getClass().getResource("AffichageOffre.fxml"));
            Parent root = loader.load();
                AffichageOffreController controller= loader.getController();
    controller.ModifierDemandeOffre(to);
                        Id.getScene().setRoot(root);
    }
    
}
