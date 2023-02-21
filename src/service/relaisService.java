
package service;

import entity.relais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;


public class relaisService  {
    Connection cnx;

public relaisService()  {
    cnx = MyDB.getInstance().getCnx();
            
}
    public void ajouter(relais p) throws SQLException {
        String req = "INSERT INTO relais (id,name,adresse,city,capacity) VALUES("
                + "'" + p.getId() + "','" + p.getName() + "','" + p.getAdresse() + "','" + p.getCity() + "','" + p.getCapacity() + "'" +")";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
    }

    public void modifier(relais p) throws SQLException {
        String req = "UPDATE relais SET name = ?,adresse = ?,city = ?,capacity = ? where id = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, p.getName());
        ps.setString(2, p.getAdresse());
        ps.setString(3, p.getCity());
        ps.setInt(4, p.getCapacity());
        ps.setString(5, p.getId());
        ps.executeUpdate();
    }

    public void supprimer(relais p)  throws SQLException{
        try{
            String req = "DELETE FROM relais Where id = '"+p.getId()+"' ";
            PreparedStatement vs = cnx.prepareStatement(req);
            vs.executeUpdate();
           
        }
        catch(SQLException ex){
            System.out.println("error in delete " + ex);
        }
    }

    
    public List<relais> recuperer()  throws SQLException{
         List<relais> users = new ArrayList<>();
        String s = "select * from relais";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            relais t = new relais();
            t.setName(rs.getString("Name"));
            t.setAdresse(rs.getString("Adresse"));
            t.setCity(rs.getString("City"));
            t.setCapacity(rs.getInt("Capacity"));
            
            
            
            users.add(t);
            
        }
        return users;
    }
    
}
