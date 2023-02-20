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
        String req = "INSERT INTO vehicule(matricule,marque) VALUES("
                + "'" + t.getMatricule()+ "','" + t.getMarque()+ "'" + ")";
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
    public void supprimer(Vehicule t) throws SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     
       /*String req = " DELETE from vehicule where id_vehicule = '?'   ";
            PreparedStatement vs = cnx.prepareStatement(req);
            vs.executeUpdate();*/
       
       String req = " DELETE FROM vehicule where id_vehicule = ?   ";
         
            PreparedStatement vs = cnx.prepareStatement(req);
             vs.setInt(1, t.getId_vehicule());
            vs.executeUpdate();
            
            
    }


    @Override
    public List<Vehicule> recuperer(Vehicule t) throws SQLException {
        List<Vehicule> vehicule = new ArrayList<>();
        String s = "select * from vehicule";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Vehicule v = new Vehicule();
            v.setMatricule(rs.getString("matricule"));
            v.setMarque(rs.getString("marque"));
            v.setId_vehicule(rs.getInt("id_vehicule"));
            
            
            vehicule.add(v);
            
        }
        return vehicule;
    }
}
