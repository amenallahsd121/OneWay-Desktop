/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Reclamation;
import entities.Reponse;
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
 * @author hp
 */
public class ReponseService {

    
Connection cnx;

    public ReponseService() {
        cnx = MyDB.getInstance().getCnx();
    }
    
    public void ajouter(Reponse t) throws SQLException {
          String req = "INSERT INTO reponse (id_reclamation,text_rep) VALUES("
                + "'" + t.getId_rec() + "','" + t.getText_rep()+  "'"  +  ")";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
    }

    
    public void modifier(Reponse t) throws SQLException {
        String req = "UPDATE reponse SET id_reclamation = ? , text_rep = ? where id_reponse = ?";
        PreparedStatement vs = cnx.prepareStatement(req);
       
        vs.setInt(1, t.getId_rec());
        vs.setString(2, t.getText_rep());
        vs.setInt(3, t.getId_rep());
        vs.executeUpdate();
        
    }


    public boolean supprimer(Reponse t) throws SQLException {
        boolean ok = false;
        try {
        String req = " DELETE FROM reponse where id_reponse = ?   ";
         
            PreparedStatement vs = cnx.prepareStatement(req);
             vs.setInt(1, t.getId_rep());
            vs.executeUpdate();
            ok= true;
        }
        catch ( SQLException ex){
            System.out.println("error in delete"+ex);
        
           
        }
        return ok;
    }

    
    public List<Reponse> recuperer() throws SQLException {
          List<Reponse> Reponse = new ArrayList<>();
        String s = "select * from reponse ";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Reponse R = new Reponse();
            
            R.setId_rep(rs.getInt("id_Reponse"));
            R.setId_rec(rs.getInt("id_reclamation"));
            R.setText_rep(rs.getString("text_rep"));
      
            
            
            
            Reponse.add(R);
            
        }
        return Reponse;
    
    }
    
   
    
    
    
    public ObservableList<Integer> getidRec() {
       
        String Req = "select id_raclamation from reclamation ";
                  
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
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public Reclamation getreclamationbyidreponse (int id) {
        Reclamation R = null;
        String Req = "select * from reclamation where id_reclamation = " + id + "";
        try {
            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(Req); //recherche
            while (res.next()) {

               R = new Reclamation (res.getInt("id_reclamation"),res.getInt("id_user"), res.getString("sujet"), res.getString("text_rec"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return R;
    }
    
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
          public ObservableList<Integer> GetALLReponseID() {
       
        String Req = "select id_reclamation from reponse";
                  
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
    
    
    
    
    
     public Reponse TrouverReponseById (int id) {
        Reponse Rep = null;
        String Req = "select * from reponse where id_reponse = " + id + "";
        try {
            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(Req); //recherche
            while (res.next()) {

             Rep = new Reponse(res.getInt(1),res.getInt(2),res.getString(3) );
               
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReponseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Rep;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
