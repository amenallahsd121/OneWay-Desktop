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
     public static void main(String[] args) {
       
        try {
            Reclamation Rc = new Reclamation(19,"rahma" , "  reclation concernant ");
            ReclamationService Rcs = new ReclamationService();
            //Rcs.ajouter(Rc);
            Rcs.modifier(Rc);
            //Rcs.supprimer(Rc);
            System.out.println(Rcs.recuperer(Rc));
            
            
            
            
            
            ///////////////////////////////////////////////////////////////////////////////////////////
            
            
            
            
            Reponse R = new Reponse(1,19, "   a votre reclamation ");
            ReponseService Rs = new ReponseService();
            Rs.ajouter(R);
            //Rs.modifier(R);
           // Rs.supprimer(R);
            System.out.println(Rs.recuperer(R));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
     
       
            
            
      
    }
    
}


