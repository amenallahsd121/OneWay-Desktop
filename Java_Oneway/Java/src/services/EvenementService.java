/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entities.AffectationOpColis;
import Entities.Evenement;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyDB;

/**
 *
 * @author Meddeb sofien
 */
public class EvenementService{
     
    
    
     
    
     Connection cnx = MyDB.getInstance().getCnx(); 
     
    
    public void ajouter(Evenement t) throws SQLException {
         try {
   String req = "INSERT INTO evenement (nom,description,date_debut_event,date_fin_event,awards) VALUES("
                + "'" + t.getNom()+ "','" + t.getDescription()+ "','" + t.getDate_debut()+ "','" + t.getDate_fin() + "','" +t.getAwards()+ "'" + ")";
        
        
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
             System.out.println("Evenement Ajoute avec succes ");
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }

    }

   
    public void modifier(Evenement t) throws SQLException {
       try {
           String req = " UPDATE evenement SET nom = ? ,description = ? , date_debut_event = ? , date_fin_event = ?  , awards = ?   where id_event = ?    ";
            PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, t.getNom());
        ps.setString(2, t.getDescription());
        ps.setString(3, t.getDate_debut());
        ps.setString(4, t.getDate_fin());
       
        ps.setString(5, t.getAwards());
        ps.setInt(6, t.getId_event());
        ps.executeUpdate();
      System.out.println("Evenement Modifier avec succes ");
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
 
    public void supprimer(Evenement t) throws SQLException {

   try{
            String req = " DELETE FROM evenement where id_event = ?   ";
       
             PreparedStatement ps = cnx.prepareStatement(req);
             ps.setInt(1, t.getId_event());
             ps.executeUpdate();  
             System.out.println("Suppresion de l'evenement se fait");
    }catch (SQLException ex){
        System.out.println("Erreu"+ ex.getMessage());
       
   }
    }

   
    public List<Evenement> recuperer() throws SQLException {
List<Evenement> event = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM evenement";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {                
                Evenement E = new Evenement();
                E.setId_event(rs.getInt(1));
                E.setNom(rs.getString(2));
                E.setDescription(rs.getString(3));
                E.setDate_debut(rs.getString(4));
                E.setDate_fin(rs.getString(5));
               
                E.setAwards(rs.getString(6));
                
                event.add(E);
            }
            
        } catch (SQLException ex) {
            System.out.println("ERREUR" + ex.getMessage());
        }
        
        return event;
    }  
    
    
    public Evenement recherche(int id) {
        Evenement P = null;
        String Req = "select * from evenement where id_event= " + id + "";
                  
   
        try {
            
           Statement ste = cnx.createStatement();
           ResultSet res =  ste.executeQuery(Req); //recherche
            while (res.next()) {

               P= new Evenement(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return P;
    }



     public String getNomEvent(int id) {
               String P = null;

        String Req = "select nom from evenement where id_event= " + id + "  ";
                  
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
     
      public Evenement TrouverById(int id) {
        Evenement C = null;
        String Req = "select * from evenement where id_event= " + id + "  ";
        try {
            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(Req); //recherche
            while (res.next()) {

            C = new Evenement(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6));               
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
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
    
    
    
public List<Evenement> recuperer(int sizee,String word)  throws SQLException{
         List<Evenement> users = new ArrayList<>();
        String s = "select * from evenement";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
           Boolean find = true;
            Evenement t = new Evenement();
//            t.setId(rs.getInt("id"));
//            t.setName(rs.getString("Name"));
//            t.setLastname(rs.getString("Lastname"));
//            t.setEmail(rs.getString("Email"));
//            t.setAdresse(rs.getString("Adresse"));
//            t.setType(rs.getString("Type"));
//            t.setBirthdate(rs.getDate("birthdate").toLocalDate());
//            t.setPassword(rs.getString("password"));
//            t.setNbr_point(rs.getInt("nb_point"));
              t.setNom(rs.getString("nom"));
              t.setId_event(rs.getInt("id_event"));
              t.setAwards(rs.getString("awards"));
              t.setDate_debut(rs.getString("date_debut_event"));
              t.setDate_fin(rs.getString("date_fin_event"));
              t.setDescription(rs.getString("description"));
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
                 if(t.getNom().charAt(i) == word.charAt(i))
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


public List<Evenement> triUp()  throws SQLException{
         List<Evenement> users = new ArrayList<>();
        String s = "select * from evenement ORDER BY nom ";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Evenement t = new Evenement();
            t.setNom(rs.getString("nom"));
              t.setId_event(rs.getInt("id_event"));
              t.setAwards(rs.getString("awards"));
              t.setDate_debut(rs.getString("date_debut_event"));
              t.setDate_fin(rs.getString("date_fin_event"));
              t.setDescription(rs.getString("description"));
           
                   users.add(t);
        }
        return users;
    }
     
     public List<Evenement> triDown()  throws SQLException{
         List<Evenement> users = new ArrayList<>();
        String s = "select * from evenement ORDER BY nom DESC";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Evenement t = new Evenement();
           t.setNom(rs.getString("nom"));
              t.setId_event(rs.getInt("id_event"));
              t.setAwards(rs.getString("awards"));
              t.setDate_debut(rs.getString("date_debut_event"));
              t.setDate_fin(rs.getString("date_fin_event"));
              t.setDescription(rs.getString("description"));
           
                users.add(t);
            
            

        }
        return users;
    }
     
     
     
     
    
     
     
     }
            
             
    


