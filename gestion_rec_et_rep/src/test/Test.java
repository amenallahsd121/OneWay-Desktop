/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import entities.Reclamation;
import entities.Reponse;
import java.sql.SQLException;
import services.ReclamationService;
import services.ReponseService;
import utils.MyDB;
/**
 *
 * @author hp
 */
public class Test {
     /*public static void main(String[] args) {
       
        try {
            Reclamation R = new Reclamation(1,"amen" , " jai une reclation concernant ");
            ReclamationService Rs = new ReclamationService();
            //Rs.ajouter(R);
            //Rs.modifier(R);
            //Rs.supprimer(R);
            
            System.out.println(Rs.recuperer(R));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }*/
      public static void main(String[] args) {
       
        try {
            Reponse R = new Reponse(3, " rahma doit repondre a votre reclamation ");
            ReponseService Rs = new ReponseService();
            //Rs.ajouter(R);
            Rs.modifier(R);
            Rs.supprimer(R);
            
            System.out.println(Rs.recuperer(R));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}


