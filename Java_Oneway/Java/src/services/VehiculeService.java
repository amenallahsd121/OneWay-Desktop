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
import javafx.collections.FXCollections;
import utils.MyDB;
public class VehiculeService  {
    Connection cnx;

    public VehiculeService() {
        cnx = MyDB.getInstance().getCnx();
    }
    
    
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

    
    public void modifier(Vehicule t) throws SQLException {
        String req = "UPDATE vehicule SET matricule = ?,marque = ? where id_vehicule = ?";
        PreparedStatement vs = cnx.prepareStatement(req);
        vs.setString(1, t.getMatricule());
        vs.setString(2, t.getMarque());
        vs.setInt(3, t.getId_vehicule());
        vs.executeUpdate();
        
    }

    
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


    
    public List<Vehicule> recuperer() throws SQLException {
        List<Vehicule> vehicule = new ArrayList<>();
        String s = "SELECT v.matricule, v.marque, v.id_vehicule, c.type FROM vehicule v INNER JOIN categorie c WHERE c.id_categorie = v.id_categorie";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Vehicule v = new Vehicule();
            v.setMatricule(rs.getString("v.matricule"));
            v.setMarque(rs.getString("v.marque"));
            v.setId_vehicule(rs.getInt("v.id_vehicule"));
            v.setTypeCat(rs.getString("c.type"));

            
            
            vehicule.add(v);
            System.out.println(v);
            
        }
        return vehicule;
    }
    
    
    
        public List<Vehicule> recupererTrier() throws SQLException {
        List<Vehicule> vehicule = new ArrayList<>();
        String s = "SELECT v.matricule, v.marque, v.id_vehicule, c.type FROM vehicule v INNER JOIN categorie c WHERE c.id_categorie = v.id_categorie ORDER BY c.type";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Vehicule v = new Vehicule();
            v.setMatricule(rs.getString("v.matricule"));
            v.setMarque(rs.getString("v.marque"));
            v.setId_vehicule(rs.getInt("v.id_vehicule"));
            v.setTypeCat(rs.getString("c.type"));

            
            
            vehicule.add(v);
            System.out.println(v);
            
        }
        return vehicule;
    }
    
    

    public Vehicule TrouverById(int id) {
        //throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
        
        Vehicule v = null;
        String Req = "select * from vehicule where id_vehicule = " + id + "";
        try {
            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(Req); //recherche
            while (res.next()) {

               v = new Vehicule (res.getInt("id_vehicule"), res.getString("matricule"), res.getString("marque") , res.getInt("id_categorie"));
            }

        } catch (SQLException ex) {
          //  Logger.getLogger(LService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    
        
    }
    
    public List<Vehicule> recuperer(int sizee,String word)  throws SQLException{
         List<Vehicule> vehicules = new ArrayList<>();
        String s = "SELECT v.matricule, v.marque, v.id_vehicule, c.type FROM vehicule v INNER JOIN categorie c WHERE c.id_categorie = v.id_categorie ORDER BY c.type";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
           Boolean find = true;
            Vehicule v = new Vehicule();
            v.setId_vehicule(rs.getInt("v.id_vehicule"));
            v.setMatricule(rs.getString("v.matricule"));
            v.setMarque(rs.getString("v.marque"));
            v.setTypeCat(rs.getString("c.type"));
            
            //System.out.println(word );           
            System.out.println(sizee );

            //String ww = word + "hhh";
            //System.out.println(ww.charAt(2) + " chhh");       
            //if(sizee == 1)
            {
             for(int i=0; i<sizee && find == true ; i++)
             {
                System.out.println(word.charAt(i));          
                System.out.println(word);
                 if(v.getMatricule().charAt(i) == word.charAt(i))
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
                 vehicules.add(v);
             }
             
             
            }
            
            
        }
        return vehicules;
    }
    
   /* public ObservableList<Integer> getidclient() {
       
        String Req = "select id from utilisateur ";
                  
      ObservableList<Integer> l = FXCollections.observableArrayList();
        try {
            
           Statement ste = cnx.createStatement();
           ResultSet res =  ste.executeQuery(Req); //recherche
            while (res.next()) {
                l.add(res.getInt(1));
                
                
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return l;
    }

    private static class ObservableList<T> {

        public ObservableList() {
        }
    }*/ 
    
}
