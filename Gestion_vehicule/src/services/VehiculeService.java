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

import entities.Vehicule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;
public class VehiculeService implements IService <Vehicule> {
    Connection cnx;

    public VehiculeService() {
        cnx = MyDB.getInstance().getCnx();
    }
    
    @Override
    public void ajouter(Vehicule t) throws SQLException {
        /*String req = "INSERT INTO vehicule(matricule,marque) VALUES("
                + "'" + t.getMatricule()+ "','" + t.getMarque()+ "'" + ")";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);*/
        String req = "INSERT INTO vehicule(matricule,marque,id_categorie) VALUES("
                + "'" + t.getMatricule()+ "','" + t.getMarque()+ "','" + t.getId_categorie() + "'"  + ")";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
    }

    @Override
    public void modifier(Vehicule t) throws SQLException {
        String req = "UPDATE vehicule SET matricule = ?,marque = ? where id_vehicule = ?";
        PreparedStatement vs = cnx.prepareStatement(req);
        vs.setString(1, t.getMatricule());
        vs.setString(2, t.getMarque());
        vs.setInt(3, t.getId_vehicule());
        vs.executeUpdate();
        
    }

    @Override
    public boolean supprimer(Vehicule t) throws SQLException {
       boolean ok = false;
        try {
       String req = " DELETE FROM vehicule where id_vehicule = ?   ";
         
            PreparedStatement vs = cnx.prepareStatement(req);
             vs.setInt(1, t.getId_vehicule());
            vs.executeUpdate();
             ok= true;
        }
        catch ( SQLException ex){
            System.out.println("error in delete"+ex);
       
           
        }
        return ok;
            
            
    }


    @Override
    public List<Vehicule> recuperer() throws SQLException {
        List<Vehicule> vehicule = new ArrayList<>();
        String s = "select * from vehicule";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Vehicule v = new Vehicule();
            v.setMatricule(rs.getString("matricule"));
            v.setMarque(rs.getString("marque"));
            v.setId_vehicule(rs.getInt("id_vehicule"));
            v.setId_categorie(rs.getInt("id_categorie"));

            
            
            vehicule.add(v);
            
        }
        return vehicule;
    }
}
