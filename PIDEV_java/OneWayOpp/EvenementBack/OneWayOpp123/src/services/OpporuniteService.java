/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entities.Evenement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import Entities.Opportunite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.MyDB;
/**
 *
 * @author Meddeb sofien
 */
public class OpporuniteService implements IService<Opportunite>{
    
     Connection cnx;

    public OpporuniteService() {
         cnx = MyDB.getInstance().getCnx();
    }

   

    
    public void ajouter(Opportunite t) throws SQLException {
        
        String req = "INSERT INTO opportinute(date,depart,heur_depart,arrivee,heur_arrivee,description) VALUES("
                + "'" + t.getDate() + "','" + t.getDepart() + "','" + t.getHeur_depart() + "','" + t.getArrivee() + "','" +t.getHeure_arrivee() + "','" +t.getDescription() + "' )";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
    }

    
    public void modifier(Opportunite t) throws SQLException {
        
        try{
        String req = "UPDATE opportinute SET date = ?,depart = ?,heur_depart = ?,arrivee = ?,heur_arrivee= ?,description= ? where id_opp = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setDate(1, t.getDate());
        ps.setString(2, t.getDepart());
        ps.setFloat(3, t.getHeur_depart());
        ps.setString(4, t.getArrivee());
        ps.setFloat(5, t.getHeure_arrivee());
        ps.setString(6, t.getDescription());
        ps.setInt(7, t.getId_opp());
        ps.executeUpdate();
         System.out.println("modification avec succes");
            }catch(SQLException ex){
        
                System.out.println(ex.getMessage());
                 }
    }

    public void supprimer(Opportunite t) throws SQLException {
            try{
            String s = "DELETE FROM opportinute where id_opp = ? ";
           
            PreparedStatement ps = cnx.prepareStatement(s);
             ps.setInt(1,t.getId_opp());
              ps.executeUpdate();
                System.out.println("supression avec succes");
            }catch(SQLException ex){
        
                System.out.println(ex.getMessage());
                 }
    
    }
    public List<Opportunite> recuperer() throws SQLException {
        
        List<Opportunite> lo = new ArrayList<>();
        String s = "select * from opportinute";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Opportunite p = new Opportunite();
           // p.setAge(rs.getInt("age"));
            p.setDate(rs.getDate("date"));
            p.setDepart(rs.getString("depart"));
            p.setHeur_depart(rs.getFloat("heur_depart"));
            p.setArrivee(rs.getString("arrivee"));
            p.setHeure_arrivee(rs.getFloat("heur_arrivee"));
            p.setDescription(rs.getString("description"));
            p.setId_opp(rs.getInt("id_opp"));

            
            
            lo.add(p);
            
        }
        return lo;
    }
public Opportunite recherche(int id) {
        Opportunite P = null;
        String Req = "select * from opportinute where id_opp= " + id + "";
                  
   
        try {
            
           Statement ste = cnx.createStatement();
           ResultSet res =  ste.executeQuery(Req); //recherche
            while (res.next()) {

               P= new Opportunite(res.getInt(1), res.getDate(2), res.getString(3), res.getFloat(4), res.getString(5), res.getFloat(6) , res.getString(7));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return P;
    }


    
}
