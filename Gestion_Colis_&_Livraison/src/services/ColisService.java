/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Colis;
import entities.Livreur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
        
        String req = "INSERT INTO colis (id_client,poids,prix,type_colis,lieu_depart,lieu_arrive) VALUES("
                + "'" + t.getId_client()+ "','" + t.getPoids() + "','" + t.getPrix()+  "','" + t.getType() + "','" + t.getLdepart() + "','" + t.getLarrive() + "'" + ")";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        
    }

    
    
    
    
    @Override
    public boolean modifier(Colis t) throws SQLException {
            
        boolean ok = false;
        try {
            String req = " UPDATE colis SET id_client = ? , poids = ? , prix = ? , type_colis = ? , lieu_depart = ? , lieu_arrive = ?    where id_colis = ?    ";
            PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, t.getId_client());
        ps.setDouble(2, t.getPoids());
        ps.setDouble(3, t.getPrix());
        ps.setString(4, t.getType());
        ps.setString(5, t.getLdepart());
        ps.setString(6, t.getLarrive());
        ps.setInt(7, t.getId());
        ps.executeUpdate();
        ok = true;
        
        } catch (SQLException ex) {
            System.out.println("error in update" + ex);
        }
        return ok; 
    }
    

    
    
    
    
    @Override
    public boolean supprimer(Colis t) throws SQLException {
    
                  boolean ok = false;
        try {
            PreparedStatement req = cnx.prepareStatement("delete from colis where id_colis = ? ");
            req.setInt(1, t.getId());
            req.executeUpdate();
            ok = true;
        } catch (SQLException ex) {
            System.out.println("error in delete " + ex);
        }
        return ok;  

    }

    
    
    
    
    
     @Override
    public List<Colis> recuperer() throws SQLException {
      
         List<Colis> Colis = new ArrayList<>();
        String s = "select * from colis";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Colis c = new Colis();
            c.setId(rs.getInt("id_colis"));
            c.setId_client(rs.getInt("id_client"));
            c.setPoids(rs.getFloat("poids"));
            c.setPrix(rs.getFloat("prix"));
            c.setType(rs.getString("type_colis"));
            c.setLdepart(rs.getString("lieu_depart"));
            c.setLarrive(rs.getString("lieu_arrive"));
      
            
            
            Colis.add(c);
            
        }
        return Colis;
    }
    
    
    
    
     public Colis TrouverById(int id) {
        Colis C = null;
        String Req = "select * from colis where id_colis = " + id + "";
        try {
            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(Req); //recherche
            while (res.next()) {

               C = new Colis (res.getInt("id_colis"), res.getInt("id_client"), res.getFloat("poids"), res.getFloat("prix"), res.getString("type_colis"), res.getString("lieu_depart"), res.getString("lieu_arrive"));
               
            }

        } catch (SQLException ex) {
            Logger.getLogger(LivraisonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return C;
    }
    
    
     
     public ObservableList<Integer> getidclient() {
       
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
     
     
     
     
     
     public String TrouvernameById(int id) {
        String C = null;
        String Req = "select name from utilisateur where id = " + id + "";
        try {
            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(Req); //recherche
            while (res.next()) {

             C=res.getString("name");
               
            }

        } catch (SQLException ex) {
            Logger.getLogger(LivraisonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return C;
    }
     
    
    
}
