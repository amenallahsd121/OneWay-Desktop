
package services;

import entity.location;
import entity.relais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;


public class LocationService {
    Connection cnx;

public LocationService()  {
    cnx = MyDB.getInstance().getCnx();
            
}
    public void ajouter(location p) throws SQLException {
        System.out.println(p.getId_delai());        
        System.out.println(p.getAdresse());
        System.out.println(p.getXaxe());        
        System.out.println(p.getYaxe());
        String req = "INSERT INTO location (adresse,Xaxe,Yaxe,id_relai) VALUES("
            + "'" + p.getAdresse() + "','" + p.getXaxe()+ "','" + p.getYaxe()+ "','" + p.getId_delai() + "'" +")";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
    }

    public void modifier(location p) throws SQLException {
        String req = "UPDATE location SET adresse = ?,Xaxe = ?,Yaxe = ?, where id = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, p.getAdresse());        
        ps.setDouble(2, p.getXaxe());        
        ps.setDouble(3, p.getYaxe());
        ps.setInt(4, p.getId());
        ps.executeUpdate();
    }

    public void supprimer(location p)  throws SQLException{
        try{
            String req = "DELETE FROM location Where id = '"+p.getId()+"' ";
            PreparedStatement vs = cnx.prepareStatement(req);
            vs.executeUpdate();
           
        }
        catch(SQLException ex){
            System.out.println("error in delete " + ex);
        }
    }
    
    public List<location> recuperer()  throws SQLException{
         List<location> locations = new ArrayList<>();
        String s = "select * from location";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            location t = new location();
            t.setId(rs.getInt("id"));            
            t.setAdresse(rs.getString("adresse"));
            t.setXaxe(rs.getDouble("Xaxe"));
            t.setYaxe(rs.getDouble("Yaxe"));            
            
            locations.add(t);
            
        }
        return locations;
    }
     public List<location> recuperer(int idrelaii)  throws SQLException{
         List<location> locations = new ArrayList<>();
        String s = "select * from location where id_relai =  " + idrelaii + "";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            location t = new location();
            t.setId(rs.getInt("id"));            
            t.setAdresse(rs.getString("adresse"));
            t.setXaxe(rs.getDouble("Xaxe"));
            t.setYaxe(rs.getDouble("Yaxe"));            
            
            locations.add(t);
            
        }
        return locations;
    }
    
    
}
