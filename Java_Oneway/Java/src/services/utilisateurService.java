
package services;

import entities.utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import sun.misc.VM;
import utils.MyDB;

public class utilisateurService {
    Connection cnx;


public  utilisateurService(){
    cnx = MyDB.getInstance().getCnx();
            
}
    
    public void ajouter(utilisateur p) throws SQLException {
        p.setNbr_point(0);
       String req = "INSERT INTO utilisateur (name,lastname,email,adresse,type,birthdate,password,nb_point) VALUES("
                + "'" + p.getName() + "','" + p.getLastname() + "','" + p.getEmail() + "','" + p.getAdresse()+  "','" + p.getType() +"','" + p.getBirthdate()+"','" + p.getPassword()+"','" + p.getNbr_point()+ "'" + ")";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        /*if("Client".equals(p.getType())){
            Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("New Client has been added!");
        alert.show();
        }
        else
        {
            Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("New Admin has been added!");
        alert.show();
        }*/
    }

    
    public void modifier(utilisateur p) throws SQLException {
        System.out.println("wokss");
        String req = "UPDATE utilisateur SET name = ?,lastname = ?,email = ?,adresse = ?,type = ?,birthdate = ? ,password = ?,nb_point = ? where id = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, p.getName());
        ps.setString(2, p.getLastname());
        ps.setString(3, p.getEmail());
        ps.setString(4, p.getAdresse());
        ps.setString(5, p.getType());        
        ps.setDate(6, java.sql.Date.valueOf(p.getBirthdate()));
        ps.setString(7, p.getPassword());
        ps.setInt(8, p.getNbr_point());
        ps.setInt(9, p.getId());
        
        ps.executeUpdate();
    }
    
    
    public void modifierCode(utilisateur p) throws SQLException {
        System.out.println(p.getId());
        String req = "UPDATE utilisateur SET code = ? where id = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        
        ps.setInt(1, p.getCode());
        ps.setInt(2, p.getId());
        
        ps.executeUpdate();
    }
    public void modifierpassword(String p , int id) throws SQLException {
        
        String req = "UPDATE utilisateur SET password = ? where id = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        
        ps.setString(1, p);
        ps.setInt(2, id);
        
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

    public List<utilisateur> recuperer(int sizee,String word)  throws SQLException{
         List<utilisateur> users = new ArrayList<>();
        String s = "select * from utilisateur";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
           Boolean find = true;
            utilisateur t = new utilisateur();
            t.setId(rs.getInt("id"));
            t.setName(rs.getString("Name"));
            t.setLastname(rs.getString("Lastname"));
            t.setEmail(rs.getString("Email"));
            t.setAdresse(rs.getString("Adresse"));
            t.setType(rs.getString("Type"));
            t.setBirthdate(rs.getDate("birthdate").toLocalDate());
            t.setPassword(rs.getString("password"));
            t.setNbr_point(rs.getInt("nb_point"));
            
            //System.out.println(word );           
            System.out.println(sizee );
            if("Client".equals(t.getType()))
            {
             for(int i=0; i<sizee && find == true ; i++)
             {
                System.out.println(word.charAt(i));          
                System.out.println(word);
                 if(t.getName().charAt(i) == word.charAt(i))
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
    
    public List<utilisateur> recupererUser()  throws SQLException{
         List<utilisateur> users = new ArrayList<>();
        String s = "select * from utilisateur ";
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
            t.setBirthdate(rs.getDate("birthdate").toLocalDate());
            t.setPassword(rs.getString("password"));
            t.setNbr_point(rs.getInt("nb_point"));
            if("Client".equals(t.getType()))
            {
                users.add(t);
            }

        }
        return users;
    }
     public List<utilisateur> triUp()  throws SQLException{
         List<utilisateur> users = new ArrayList<>();
        String s = "select * from utilisateur ORDER BY name ";
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
            t.setBirthdate(rs.getDate("birthdate").toLocalDate());
            t.setPassword(rs.getString("password"));
            t.setNbr_point(rs.getInt("nb_point"));
            if("Client".equals(t.getType()))
            {
                users.add(t);
            }
        }
        return users;
    }
     
     public List<utilisateur> triDown()  throws SQLException{
         List<utilisateur> users = new ArrayList<>();
        String s = "select * from utilisateur ORDER BY name DESC";
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
            t.setBirthdate(rs.getDate("birthdate").toLocalDate());
            t.setPassword(rs.getString("password"));
            t.setNbr_point(rs.getInt("nb_point"));
            if("Client".equals(t.getType()))
            {
                users.add(t);
            }
        }
        return users;
    }
     
    public List<utilisateur> recupererAdmin()  throws SQLException{
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
            t.setBirthdate(rs.getDate("birthdate").toLocalDate());
            t.setPassword(rs.getString("password"));
            t.setNbr_point(rs.getInt("nb_point"));
            if("admin".equals(t.getType()))
            {
                users.add(t);
            }
    
        }
        return users;
    }
    public boolean rechercher(utilisateur m)  throws SQLException{
        String s = "select * from utilisateur";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            utilisateur t = new utilisateur();
            
            t.setName(rs.getString("Name"));
            t.setPassword(rs.getString("password"));
            if(t.getName() == null ? m.getName() == null : t.getName().equals(m.getName()))
            {
                if(t.getPassword() == null ? m.getPassword() == null : t.getPassword().equals(m.getPassword()))
                {
                    return true;
                }  
            }
            
        }
        return false;      
    }
    public utilisateur rechercherEmail(String getemail)  throws SQLException{
        String s = "select * from utilisateur WHERE email like '%"+ getemail +"%'" ;
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
         utilisateur t = null;
        while(rs.next()){
           
            
            t = new utilisateur(rs.getInt(1));
            
        }
        return t;
        
    }
    public utilisateur getusercode(int idd)  throws SQLException{
        System.out.println(idd);
        String s = "select code from utilisateur WHERE id =  " + idd + "" ;
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
         utilisateur t = null;
        while(rs.next()){
           
            
            t = new utilisateur(rs.getInt("code"));
            System.out.println(t);
            System.out.println(t.getCode());
   
        }
        return t;    
    }
   public utilisateur getUser(String pass)  throws SQLException{
        System.out.println(pass);
        String s = "select type,id from utilisateur where password like '"+ pass +"'";
        
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        utilisateur t = null;
        while(rs.next()){
            
            System.out.println(rs.getString("type"));
            t = new utilisateur(rs.getString("type"),rs.getInt("id"));
        }
        return t;      
    }
}
