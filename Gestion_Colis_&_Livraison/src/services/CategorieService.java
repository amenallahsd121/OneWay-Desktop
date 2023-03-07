/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author Houda
 */

import entities.Categorie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;
public class CategorieService  {
    
    Connection cnx;

    public CategorieService() {
        cnx = MyDB.getInstance().getCnx();
    }
    
     
    public void ajouter(Categorie t) throws SQLException {
          String req = "INSERT INTO categorie (type) VALUES("
                + "'" + t.getType()+ "'"  +  ")";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
    }
    
    
    public void modifier(Categorie t) throws SQLException {
        String req = "UPDATE categorie SET type = ?  where id_categorie = ?";
        PreparedStatement vc = cnx.prepareStatement(req);
        vc.setString(1, t.getType());
        vc.setInt(2, t.getId_categorie());
        
        vc.executeUpdate();
        
    }
    
    
    public boolean supprimer(Categorie t) throws SQLException {
        boolean ok = false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     
       
       try {
       String req = " DELETE FROM categorie where id_categorie = ?   ";
         
            PreparedStatement vc = cnx.prepareStatement(req);
            vc.setInt(1, t.getId_categorie());
            vc.executeUpdate();
            ok= true;
            }
        catch ( SQLException ex){
            System.out.println("error in delete"+ex);
       
           
        }
        return ok;
            
          
    }
    
    
    public List<Categorie> recuperer( ) throws SQLException {
        List<Categorie> categorie = new ArrayList<>();
        String s = "select * from categorie";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Categorie c = new Categorie();
            c.setType(rs.getString("type"));
            c.setId_categorie(rs.getInt("id_categorie"));
            
            
             categorie.add(c);
            
        }
        return  categorie ;
    }

    
    public Categorie TrouverById(int id) {
        //throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
        
        Categorie c = null;
        String Req = "select * from categorie where id_categorie = " + id + "";
        try {
            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(Req); //recherche
            while (res.next()) {

               c = new Categorie (res.getInt(1), res.getString(2));
            }

        } catch (SQLException ex) {
          //  Logger.getLogger(LService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    
        
    }
    
}
