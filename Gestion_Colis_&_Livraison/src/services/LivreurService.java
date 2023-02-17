/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Livreur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;
/**
 *
 * @author amens
 */
public class LivreurService implements IServices<Livreur>{

     Connection cnx;
    public LivreurService() {
         cnx = MyDB.getInstance().getCnx();
    }
    
    @Override
    public void ajouter(Livreur t) throws SQLException {
       
         String req = "INSERT INTO livreur (cin_livreur,nom,prenom,vehicule) VALUES("
                + "'" + t.getCin_livreur() + "','" + t.getNom() + "','" + t.getPrenom() + "','" + t.getVehicule() + "'" + ")";
        
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        
        
    }

    @Override
    public void modifier(Livreur t) throws SQLException {
        
         String req = " UPDATE livreur SET cin_livreur = ? , nom = ? , prenom= ? , vehicule = ?  where cin_livreur = ?    ";
         PreparedStatement ps = cnx.prepareStatement(req);
         ps.setString(1, t.getCin_livreur());
         ps.setString(2, t.getNom());
         ps.setString(3, t.getPrenom());
         ps.setString(4, t.getVehicule());
         ps.setString(5, t.getCin_livreur());
         ps.executeUpdate();
        
    }

    @Override
    public void supprimer(Livreur t) throws SQLException {
        
             String req = " DELETE FROM livreur where cin_livreur = ? " ;
             PreparedStatement ps = cnx.prepareStatement(req);
             ps.setString(1, t.getCin_livreur());
             ps.executeUpdate();
        
    }

    @Override
    public List<Livreur> recuperer(Livreur t) throws SQLException {
        
         List<Livreur> Livreur = new ArrayList<>();
        String s = "select * from livreur ";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Livreur L = new Livreur();
            
            L.setCin_livreur(rs.getString("cin_livreur"));
            L.setNom(rs.getString("nom"));
            L.setPrenom(rs.getString("prenom"));
            L.setVehicule(rs.getString("vehicule"));
           
      
            
            
            Livreur.add(L);
            
        }
        return Livreur;
        
    }
    
    
    
    
}
