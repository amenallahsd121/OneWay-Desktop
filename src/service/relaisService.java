
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
        //System.out.println(p.getEmail());
        String req = "INSERT INTO relais (name,lastname,email,adresse,city,number) VALUES("
                + "'" + p.getName() + "','" + p.getLastname()+ "','" + p.getEmail()+ "','" + p.getAdresse() + "','" + p.getCity() + "','" + p.getNumber() + "'" +")";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
    }

    public void modifier(relais p) throws SQLException {
        String req = "UPDATE relais SET name = ?,lastname = ?,email = ?,adresse = ?,city = ?,number = ? where id = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, p.getName());        
        ps.setString(2, p.getLastname());        
        ps.setString(3, p.getEmail());
        ps.setString(4, p.getAdresse());
        ps.setString(5,p.getCity());
        ps.setInt(6, p.getNumber());
        ps.setInt(7, p.getId());
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
            t.setId(rs.getInt("id"));
            t.setName(rs.getString("name"));            
            t.setLastname(rs.getString("lastname"));            
            t.setEmail(rs.getString("email"));
            t.setAdresse(rs.getString("adresse"));
            t.setCity(rs.getString("city"));
            t.setNumber(rs.getInt("number"));
            
            
            
            users.add(t);
            
        }
        return users;
    }
    
}
