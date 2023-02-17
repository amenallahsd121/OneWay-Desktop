/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Livraison;
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
public class LivraisonService implements IServices<Livraison>{

    
    Connection cnx;
    public LivraisonService() {
        
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Livraison t) throws SQLException {
       
        
         String req = "INSERT INTO livraison (etat,id_colis,cin_livreur) VALUES("
                + "'" + t.getEtat() + "','" + t.getId_colis() + "','" + t.getCin_livreur()+ "'" + ")";
        
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        
        
    }

    @Override
    public void modifier(Livraison t) throws SQLException {
      
        
         String req = " UPDATE livraison SET  etat = ? , id_colis = ? , cin_livreur = ?  where id_livraison = ?    ";
         PreparedStatement ps = cnx.prepareStatement(req);
         ps.setString(1, t.getEtat());
         ps.setInt(2, t.getId_colis());
         ps.setString(3, t.getCin_livreur());
         ps.setInt(4, t.getId_livraison());
         ps.executeUpdate();
         
    }

    @Override
    public void supprimer(Livraison t) throws SQLException {
      
            String req = " DELETE FROM livraison where cin_livreur = ? " ;
             PreparedStatement ps = cnx.prepareStatement(req);
             ps.setString(1, t.getCin_livreur());
             ps.executeUpdate();
        
    }

    @Override
    public List<Livraison> recuperer(Livraison t) throws SQLException {
        
        
          List<Livraison> Livraison = new ArrayList<>();
        String s = "select * from livraison ";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Livraison Liv = new Livraison();
            
             Liv.setId_livraison(rs.getInt("id_livraison"));
             Liv.setEtat(rs.getString("etat"));
             Liv.setCin_livreur(rs.getString("cin_livreur"));
             Liv.setId_colis(rs.getInt("id_colis"));
           
      
            
            
            Livraison.add(Liv);
            
        }
        return Livraison;
    }
}

    
    
            