/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entities.AffectationOpColis;
import Entities.Opportunite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import utils.MyDB;

/**
 *
 * @author Meddeb sofien
 */
public class AffectationService implements  IService<AffectationOpColis>{
    
    
        Connection cnx;

    public AffectationService() {
         cnx = MyDB.getInstance().getCnx();
    }

    


    @Override
    public void ajouter(AffectationOpColis t) throws SQLException {
         String req = "INSERT INTO affectationopcolis(id_opp,id_colis) VALUES("
                + "'" + t.getIdopp() + "','" + t.getIdcolis() +  "' )";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
    }

    @Override
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

    @Override
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

    @Override
    public List<AffectationOpColis> recuperer(AffectationOpColis t) throws SQLException {
        
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
    
}
