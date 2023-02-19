/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Entities.AffectationOpColis;
import Entities.Opportunite;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.AffectationService;
import utils.MyDB;
import services.OpporuniteService;

/**
 *
 * @author Meddeb sofien
 */
public class Test {
    public static void main(String[] args) {
      //  MyDB db = new MyDB();
      //*******************************table Opportuniteé******************************
        try {
        Opportunite op1 = new Opportunite("10/10/2023", "fraance",6f, "gabes" ,10f, "cccccccc");
        Opportunite op2 = new Opportunite("10/10/2023", "cccc",6f, "ccccccc" ,10f, "vvvvvvv");
        
        
        OpporuniteService os = new OpporuniteService();
        
        // os.supprimer(16);
            //os.supprimer(op1);
               // os.modifier(op1);
            //   os.ajouter(op2);
            
            System.out.println(os.recuperer(op1));
        
        //*******************************table Affectation******************************
            System.out.println("*************************************************************");
        AffectationService as = new AffectationService();
            
            AffectationOpColis aff1 = new AffectationOpColis(18,24,1);
            
            
          //  as.ajouter(aff1);
            
           //as.modifier(aff1);
          //as.supprimer(aff1);
            System.out.println(as.recuperer(aff1));;
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());       
        }
             
        
    }
    
}
