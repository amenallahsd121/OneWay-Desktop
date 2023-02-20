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
public class CategorieService implements IService<Categorie> {
    
    Connection cnx;

    public CategorieService() {
        cnx = MyDB.getInstance().getCnx();
    }
    
     @Override
    public void ajouter(Categorie t) throws SQLException {
          String req = "INSERT INTO categorie (type) VALUES("
                + "'" + t.getType()+ "'"  +  ")";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
    }
    
    @Override
    public void modifier(Categorie t) throws SQLException {
        String req = "UPDATE categorie SET type = ? = ? where id_maintenance = ?";
        PreparedStatement vc = cnx.prepareStatement(req);
        vc.setString(1, t.getType());
        vc.setInt(2, t.getId_categorie());
        vc.executeUpdate();
        
    }
    
    @Override
    public void supprimer(Categorie t) throws SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     
       /*String req = " DELETE from vehicule where id_vehicule = '?'   ";
            PreparedStatement vs = cnx.prepareStatement(req);
            vs.executeUpdate();*/
       
       String req = " DELETE FROM categorie where id_categorie = ?   ";
         
            PreparedStatement vc = cnx.prepareStatement(req);
            vc.setInt(1, t.getId_categorie());
            vc.executeUpdate();
            
            
    }
    
    @Override
    public List<Categorie> recuperer(Categorie t) throws SQLException {
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

    
}
