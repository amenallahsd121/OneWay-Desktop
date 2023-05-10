/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entities.AffectationOpColis;
import Entities.Evenement;
import Entities.Opportunite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import utils.MyDB;

/**
 *
 * @author Meddeb sofien
 */
public class AffectationService {
    
    
        Connection cnx;

    public AffectationService() {
         cnx = MyDB.getInstance().getCnx();
    }

    


  
    public void ajouter(AffectationOpColis t) throws SQLException {
         String req = "INSERT INTO affectationopcolis(id_opp,id_colis) VALUES("
                + "'" + t.getIdopp() + "','" + t.getIdcolis() +  "' )";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
    }

  
    public void modifier(AffectationOpColis t) throws SQLException {
        
          try{
        String req = "UPDATE affectationopcolis SET id_opp = ?,id_colis = ? where id_aff = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, t.getIdopp());
        ps.setInt(2, t.getIdcolis());
       
        ps.setInt(3, t.getIdAff());
        ps.executeUpdate();
         System.out.println("modification affectation  avec succes");
            }catch(SQLException ex){
               
        
                System.out.println(ex.getMessage());
                 }
    }

 
    public void supprimer(AffectationOpColis t) throws SQLException {
        
         try{
            String s = "DELETE FROM affectationopcolis where id_aff = ? ";
           
             PreparedStatement ps = cnx.prepareStatement(s);
             ps.setInt(1,t.getIdAff());
             ps.executeUpdate();
                System.out.println("supression affectation avec succes");
            }catch(SQLException ex){
        
                System.out.println(ex.getMessage());
                 }
    }

    public List<AffectationOpColis> recuperer() throws SQLException {
        
      List<AffectationOpColis> laff = new ArrayList<>();
        String s = "select * from affectationopcolis";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            AffectationOpColis p = new AffectationOpColis();
           
            p.setIdopp(rs.getInt("id_opp"));
            p.setIdAff(rs.getInt("id_aff"));
            p.setIdcolis(rs.getInt("id_colis"));

            
            
            laff.add(p);
            
        }
        return laff;
    }

    public ObservableList<Integer> idOpDisponible() {
       
        String Req = "select id_opp from opportinute ";
                  
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

    
     public ObservableList<Integer> idColisDisponible() {
       
        String Req = "select id_colis from colis ";
                  
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

     public AffectationOpColis recherche(int id) {
        AffectationOpColis P = null;
        String Req = "select * from  affectationopcolis where id_aff= " + id + "";
                  
   
        try {
            
           Statement ste = cnx.createStatement();
           ResultSet res =  ste.executeQuery(Req); //recherche
            while (res.next()) {

               P= new AffectationOpColis(res.getInt(1), res.getInt(2), res.getInt(3));
           
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return P;
    }
     
    
      public String getNomUser(int id) {
               String P = null;

        String Req = "select name from utilisateur where id= " + id + "  ";
                  
      //ObservableList<Integer> l = FXCollections.observableArrayList();
      
        try {
             
             
           Statement ste = cnx.createStatement();
           ResultSet res =  ste.executeQuery(Req);//recherche
            while (res.next()) {
              //  l.add(res.getInt(1));
               P=res.getString(1);
                
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return P;
    }
        public String getPRENomUser(int id) {
               String P = null;

        String Req = "select lastname from utilisateur where id= " + id + "  ";
                  
      //ObservableList<Integer> l = FXCollections.observableArrayList();
      
        try {
             
             
           Statement ste = cnx.createStatement();
           ResultSet res =  ste.executeQuery(Req);//recherche
            while (res.next()) {
              //  l.add(res.getInt(1));
               P=res.getString(1);
                
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return P;
    }
         public int getiddclient(int id) {
               int P = 0;

        String Req = "select id_client from colis where id_colis = " + id + "  ";
                  
      //ObservableList<Integer> l = FXCollections.observableArrayList();
      
        try {
             
             
           Statement ste = cnx.createStatement();
           ResultSet res =  ste.executeQuery(Req);//recherche
            while (res.next()) {
              //  l.add(res.getInt(1));
               P=res.getInt(1);
                
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return P;
    }

          public String getdepart(int id) {
               String P = null;

        String Req = "select depart from opportinute where id_opp = " + id + "  ";
                  
      //ObservableList<Integer> l = FXCollections.observableArrayList();
      
        try {
             
             
           Statement ste = cnx.createStatement();
           ResultSet res =  ste.executeQuery(Req);//recherche
            while (res.next()) {
              //  l.add(res.getInt(1));
               P=res.getString(1);
                
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return P;
    }
          
           public String getArrive(int id) {
               String P = null;

        String Req = "select arrivee from opportinute where id_opp = " + id + "  ";
                  
      //ObservableList<Integer> l = FXCollections.observableArrayList();
      
        try {
             
             
           Statement ste = cnx.createStatement();
           ResultSet res =  ste.executeQuery(Req);//recherche
            while (res.next()) {
              //  l.add(res.getInt(1));
               P=res.getString(1);
                
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return P;
    }

 public String getdateOp(int id) {
               String P = null;

        String Req = "select date from opportinute where id_opp = " + id + "  ";
                  
      //ObservableList<Integer> l = FXCollections.observableArrayList();
      
        try {
             
             
           Statement ste = cnx.createStatement();
           ResultSet res =  ste.executeQuery(Req);//recherche
            while (res.next()) {
              //  l.add(res.getInt(1));
               P=res.getString(1);
                
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return P;
    }

    
}