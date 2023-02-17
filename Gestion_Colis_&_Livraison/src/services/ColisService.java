/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Colis;
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
public class ColisService implements IServices<Colis> {

    Connection cnx;
    public ColisService() {
         cnx = MyDB.getInstance().getCnx();
    }

    
    
    @Override
    public void ajouter(Colis t) throws SQLException {
        
        String req = "INSERT INTO colis (poids,type_colis,lieu_depart,lieu_arrive) VALUES("
                + "'" + t.getPoids() + "','" + t.getType() + "','" + t.getLdepart() + "','" + t.getLarrive() + "'" + ")";
        
        
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        
    }

    
    
    
    
    @Override
    public void modifier(Colis t) throws SQLException {
        
            String req = " UPDATE colis SET poids = ? , type_colis = ? , lieu_depart = ? , lieu_arrive = ?    where id_colis = ?    ";
            PreparedStatement ps = cnx.prepareStatement(req);
        ps.setDouble(1, t.getPoids());
        ps.setString(2, t.getType());
        ps.setString(3, t.getLdepart());
        ps.setString(4, t.getLarrive());
        ps.setInt(5, t.getId());
        ps.executeUpdate();
    }
    

    
    
    
    
    @Override
    public void supprimer(Colis t) throws SQLException {
        String req = " DELETE FROM colis where id_colis = ?   ";
       
               PreparedStatement ps = cnx.prepareStatement(req);
             ps.setInt(1, t.getId());
             ps.executeUpdate();

    }

    
    
    
    
    
    @Override
    public List<Colis> recuperer(Colis t) throws SQLException {
      
         List<Colis> Colis = new ArrayList<>();
        String s = "select * from colis";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Colis c = new Colis();
            c.setId(rs.getInt("id_colis"));
            c.setPoids(rs.getFloat("poids"));
            c.setType(rs.getString("type_colis"));
            c.setLdepart(rs.getString("lieu_depart"));
            c.setLarrive(rs.getString("lieu_arrive"));
      
            
            
            Colis.add(c);
            
        }
        return Colis;
    }
    
    
    
    
    
    
    
}
