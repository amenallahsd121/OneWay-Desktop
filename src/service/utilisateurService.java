
package service;

import entity.utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

public class utilisateurService {
    Connection cnx;

public  utilisateurService(){
    cnx = MyDB.getInstance().getCnx();
            
}
    
    public void ajouter(utilisateur p) throws SQLException {
       String req = "INSERT INTO utilisateur (name,lastname,email,adresse,type,nb_point) VALUES("
                + "'" + p.getName() + "','" + p.getLastname() + "','" + p.getEmail() + "','" + p.getAdresse()+  "','" + p.getType() +"','" + p.getNbr_point()+ "'" + ")";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
    }

    
    public void modifier(utilisateur p) throws SQLException {
        String req = "UPDATE utilisateur SET name = ?,lastname = ?,email = ?,adresse = ?,type = ? ,nb_point = ? where id = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, p.getName());
        ps.setString(2, p.getLastname());
        ps.setString(3, p.getEmail());
        ps.setString(4, p.getAdresse());
        ps.setString(5, p.getType());
        ps.setInt(6, p.getNbr_point());
        ps.setInt(7, p.getId());
        ps.executeUpdate();
    }

   
    public void supprimer(utilisateur p)  throws SQLException{
        System.out.println(p.getId());
        try{
            String req = "DELETE FROM utilisateur Where id = '"+p.getId()+"' ";
            PreparedStatement vs = cnx.prepareStatement(req);
            vs.executeUpdate();
           
        }
        catch(SQLException ex){
            System.out.println("error in delete " + ex);
        }
    }

    public List<utilisateur> recuperer()  throws SQLException{
         List<utilisateur> users = new ArrayList<>();
        String s = "select * from utilisateur";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            utilisateur t = new utilisateur();
            t.setId(rs.getInt("id"));
            t.setName(rs.getString("Name"));
            t.setLastname(rs.getString("Lastname"));
            t.setEmail(rs.getString("Email"));
            t.setAdresse(rs.getString("Adresse"));
            t.setType(rs.getString("Type"));
            t.setNbr_point(rs.getInt("nb_point"));
            
            
            users.add(t);
            
        }
        return users;
    }
}
