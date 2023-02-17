/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Colis;
import entities.Livreur;
import entities.Livraison;
import java.sql.SQLException;
import services.ColisService;
import services.LivreurService;
import services.LivraisonService;
/**
 *
 * @author amens
 */
public class Test {
    public static void main(String[] args) {
        
         try {
             
             
             
            ///////////////////////////////////// COLIS ///////////////////////////////////////////////////////// 
            
            
            
            //Colis c = new Colis(  5 , 1.2 ,"Flagile", "Gabes", "Sfax");
            Colis c1 = new Colis(  1 , 2.5 ,"Flagile", "Tunis", "Sfax");
            ColisService CS = new ColisService();
            //CS.ajouter(c1);
            //CS.modifier(c1);
            //CS.supprimer(c1);
            System.out.println(CS.recuperer(c1));
            
            
            
            
            //////////////////////////////////// LIVREUR //////////////////////////////////////////////////////////
            
            
            
             Livreur L1 = new Livreur(  "12345678" ,"Hnich", "Adem", "Berlingo");
             LivreurService LS = new LivreurService() ;
           //LS.ajouter(L1);
           //LS.modifier(L1);
           //LS.supprimer(L1);
             System.out.println(LS.recuperer(L1));

             
             
             
            ///////////////////////////////////////// LIVRAISON ///////////////////////////////////////////////////
            
            
             Livraison Liv1 = new Livraison( 1 , 2 , "fragile", "12345678");
             LivraisonService LIS = new LivraisonService();
           //LIS.ajouter(Liv1);
           //LIS.modifier(Liv1);
           //LIS.supprimer(Liv1);
             System.out.println(LIS.recuperer(Liv1));
            
            
            
            
            
            
            
            
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         
         
    }
    
}
