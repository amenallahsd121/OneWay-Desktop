
package test;

import entity.relais;
import entity.utilisateur;
import java.sql.SQLException;
import service.relaisService;
import service.utilisateurService;
import utils.MyDB;

public class Test {
    public static void main(String[] args) throws SQLException {
        MyDB db = MyDB.getInstance();
    
       System.out.println(db);
        //utilisateur u1 = new utilisateur(23,"ffff","felhi","gokgojg","kffk","client",12);
        /*relais r1 = new relais("dddd5","dfgfd","dhdghg","dggdf",10);
        relais r2= new relais("hhh4","ousasl","ggdsee","baaan",50);*/
        
        utilisateurService us = new utilisateurService();
        relaisService rs = new relaisService();
        
      //rs.ajouter(r1);
        //System.out.println(rs.recuperer());
        //rs.supprimer(r1);
        System.out.println(rs.recuperer());
        
                    
                    
       
        

        
       

         
    }
}
