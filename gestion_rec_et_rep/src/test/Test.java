/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import entities.Reclamation;
import entities.Reponse;
import java.sql.SQLException;
import static javafx.scene.input.KeyCode.R;
import services.ReclamationService;
import services.ReponseService;
import utils.MyDB;
/**
 *
 * @author hp
 */
public class Test {
     public static void main(String[] args) {
       
         
       //  ReponseService rp = new ReponseService();
        try {
            
            ///////////////////////////////// RECLAMATION ///////////////////////////////////////////
            
          //  Reclamation R = new Reclamation(2,"amen" , " jai une reclation concernant ");
            ReclamationService Rs = new ReclamationService();
            //Rs.ajouter(R);
    //        Rs.modifier(R);
            //Rs.supprimer(R);
           // System.out.println(Rs.recuperer(R));
            
            ////////////////////////////////////////// REPONSE //////////////////////////////////////
            
             Reponse r = new Reponse(28, 2, "dfgghhhj");
            ReponseService Rps = new ReponseService();
            Rps.ajouter(r);
           // Rps.modifier(Rp);
           // Rps.supprimer(Rp);
            
            System.out.println(Rps.recuperer()); 
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     
       
       
    }
    



