/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Entities.AffectationOpColis;
import Entities.Evenement;
import Entities.Opportunite;
import Entities.Participation;
import java.sql.SQLException;
import services.AffectationService;
import services.EvenementService;
import services.OpporuniteService;
import services.ParticipationService;

/**
 *
 * @author Meddeb sofien
 */
public class TEST2 {
    public static void main(String[] args) {
        
         try {
           Evenement e1 = new Evenement(3,"sofien", "mmmmm", "15-02-2022", "17-02-2023", "500dt");
//               
            EvenementService es = new EvenementService();
          // es.ajouter(e1);
            //es.modifier(e1);
           //  es.supprimer(e1);
           System.out.println(es.recuperer(e1));

 System.out.println("*********************PARTICIPATION***************");
 Participation p1 = new Participation(2, 35);
 
 ParticipationService ps= new ParticipationService();
         // ps.supprimer(p1);
        //  ps.ajouter(p1);
        //ps.modifier(p1);
             System.out.println(ps.recuperer(p1));
             
             
             
             
            
             
              
             
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());       
        }
        
    }
    
}
