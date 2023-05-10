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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public boolean modifier(Livreur t) throws SQLException {
        
        
         boolean ok = false;
        try {
         String req = " UPDATE livreur SET cin_livreur = ? , nom = ? , prenom= ? , vehicule = ?  where id_livreur = ? ";
         PreparedStatement ps = cnx.prepareStatement(req);
         ps.setString(1, t.getCin_livreur());
         ps.setString(2, t.getNom());
         ps.setString(3, t.getPrenom());
         ps.setString(4, t.getVehicule());
         ps.setInt(5, t.getId_livreur());
         ps.executeUpdate();
         ok = true;
        } catch (SQLException ex) {
            System.out.println("error in update" + ex);
        }
        return ok;  

    }

        
    

    @Override
    public boolean supprimer(Livreur t) throws SQLException {
        
             boolean ok = false;
        try {
            PreparedStatement req = cnx.prepareStatement("delete from livreur where id_livreur = ? ");
            req.setInt(1, t.getId_livreur());
            req.executeUpdate();
            ok = true;
        } catch (SQLException ex) {
            System.out.println("error in delete " + ex);
        }
        return ok;  
        
    }

    @Override
    public List<Livreur> recuperer() throws SQLException {
        
         List<Livreur> Livreur = new ArrayList<>();
        String s = "select * from livreur ";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            
            Livreur L = new Livreur();
            L.setId_livreur(rs.getInt("id_livreur"));
            L.setCin_livreur(rs.getString("cin_livreur"));
            L.setNom(rs.getString("nom"));
            L.setPrenom(rs.getString("prenom"));
            L.setVehicule(rs.getString("vehicule"));
           
      
            
            
            Livreur.add(L);
            
        }
        return Livreur;
        
    }
    
    
    public Livreur TrouverById(int id) {
        Livreur L = null;
        String Req = "select * from livreur where id_livreur = " + id + "";
        try {
            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(Req); //recherche
            while (res.next()) {

               L = new Livreur (res.getInt("id_livreur"), res.getString("cin_livreur"), res.getString("nom"), res.getString("prenom"), res.getString("vehicule"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(LivraisonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return L;
    }
    
   public List<Livreur> recuperer(int sizee,String word)  throws SQLException{
         List<Livreur> users = new ArrayList<>();
        String s = "select * from livreur";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
           Boolean find = true;
            Livreur t = new Livreur();
            t.setId_livreur(rs.getInt("id_livreur"));
            t.setCin_livreur(rs.getString("cin_livreur"));
            t.setNom(rs.getString("nom"));
            t.setPrenom(rs.getString("prenom"));
            t.setVehicule(rs.getString("vehicule"));
            

            //System.out.println(word );
            System.out.println(sizee );

            //String ww = word + "hhh";
            //System.out.println(ww.charAt(2) + " chhh");
            //if(sizee == 1)
            {
             for(int i=0; i<sizee && find == true ; i++)
             {
                System.out.println(word.charAt(i));
                System.out.println(word);
                 if(t.getPrenom().charAt(i) == word.charAt(i))
                 {
                     System.out.println("in");
                     find = true;
                 }
                 else
                 {
                     System.out.println("out");
                    find =false;
                 }

             }
                System.out.println(find);
             if(find == true)
             {
                 users.add(t);
             }

            }

        }
        return users;
    }
   public List<Livreur> triUp()  throws SQLException{
         List<Livreur> users = new ArrayList<>();
        String s = "select * from livreur ORDER BY nom ";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Livreur t = new Livreur();
           t.setId_livreur(rs.getInt("id_livreur"));
            t.setCin_livreur(rs.getString("cin_livreur"));
            t.setNom(rs.getString("nom"));
            t.setPrenom(rs.getString("prenom"));
            t.setVehicule(rs.getString("vehicule"));
            


        }
        return users;
    }

     public List<Livreur> triDown()  throws SQLException{
        List<Livreur> liv = new ArrayList<>();
        String s = "select * from livreur ORDER BY nom DESC";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Livreur t = new Livreur();
           t.setId_livreur(rs.getInt("id_livreur"));
            t.setCin_livreur(rs.getString("cin_livreur"));
            t.setNom(rs.getString("nom"));
            t.setPrenom(rs.getString("prenom"));
            t.setVehicule(rs.getString("vehicule"));
        }
        return liv;
    }

}
