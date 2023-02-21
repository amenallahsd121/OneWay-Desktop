/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.CategorieOffre;
import entities.Demande;
import java.sql.SQLException;
import entities.Offre;
import entities.TrajetOffre;
import java.text.ParseException;
import services.CategorieOffreService;
import services.DemandeService;
import services.OffreService;
import services.TrajetService;
import utils.MyDB;

/**
 *
 * @author Houda
 */
public class test {

    public static void main(String[] args) throws ParseException {
        try {
            CategorieOffre c = new CategorieOffre(505, 1, 150, "M");
            System.out.println(c.toString());
            CategorieOffreService cs = new CategorieOffreService();
            cs.ajouter(c);
            cs.modifier(c);
            System.out.println(cs.recuperer());

            TrajetOffre t = new TrajetOffre(4, 150, 3, "Zarzis", "Gabes");
            System.out.println(t.toString());

            TrajetService ts = new TrajetService();
            ts.ajouter(t);
            ts.modifier(t);
            System.out.println(ts.recuperer());
            OffreService os = new OffreService();

            

            Offre o1 = new Offre(3, 4, "M", "", "5jours", 20, "2-3-2019", "ZarzisGabes");
            System.out.println(o1.toString());

            os.ajouter(o1);
            os.modifier(o1);
            System.out.println(os.recuperer());
           DemandeService ds= new DemandeService();
            Demande d= new Demande(4,4,1,1,"je veux vous parler",15.0);
            ds.ajouter(d);
            ds.modifier(d);
            System.out.println(ds.recuperer());
            
            os.supprimer(o1);
            ts.supprimer(t);
            cs.supprimer(c);
            ds.supprimer(d);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
