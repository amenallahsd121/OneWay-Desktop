/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Houda
 */
//////////////////////////////////////////////
import entities.Maintenance;
import entities.Vehicule;
import entities.Categorie;
import java.sql.SQLException;
import services.VehiculeService;
import services.MaintenanceService;
import services.CategorieService;
import utils.MyDB;

public class Test {
    
    public static void main(String[] args) {
       
        try {
           Vehicule v = new Vehicule( 1,"215 Tunis 1100", "toyota");
           Vehicule v3 = new Vehicule( 12,"228 Tunis 6114", "hundai");
           //Maintenance m3 = new Maintenance( 1,"accidenté", "aaaa");
            VehiculeService vs = new VehiculeService();
           vs.ajouter(v);
           vs.modifier(v);
           vs.supprimer(v3);
            System.out.println(vs.recuperer(v));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        
       try {
           Maintenance m = new Maintenance( 4,"réparee", "aaaaa auto ");
           //Maintenance m3 = new Maintenance( 1,"accidenté", "aaaa");
           MaintenanceService ms = new MaintenanceService();
           //ms.ajouter(m);
           //ms.modifier(m);
           ms.supprimer(m);
            System.out.println(ms.recuperer(m));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
       
       try {
           Categorie c = new Categorie( 3,"voiture xx");
           CategorieService vc = new CategorieService();
           //vc.ajouter(c);
           //vc.modifier(c);
           vc.supprimer(c);
            System.out.println(vc.recuperer(c));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
       
    }
    
    
}
