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
import utils.MyDB;

/**
 *
 * @author hp
 */
public class ReponseService implements IService <Reponse> {

    
Connection cnx;

    public ReponseService() {
        cnx = MyDB.getInstance().getCnx();
    }
    @Override
    public void ajouter(Reponse t) throws SQLException {
          String req = "INSERT INTO reponse (id_raclamation,text_rep) VALUES("
                + "'" + t.getId_rec() + "','" + t.getText_rep() +  "'"  +  ")";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
    }

    @Override
    public void modifier(Reponse t) throws SQLException {
        String req = "UPDATE reponse SET text_rep = ? where id_reponse = ?";
        PreparedStatement vs = cnx.prepareStatement(req);
        vs.setString(1, t.getText_rep());
        
        vs.setInt(2, t.getId_rep());
        vs.executeUpdate();
    }

    @Override
    public void supprimer(Reponse t) throws SQLException {
       String req = " DELETE FROM reponse where id_reponse = ?   ";
         
            PreparedStatement vs = cnx.prepareStatement(req);
             vs.setInt(1, t.getId_rep());
            vs.executeUpdate();
    }

    @Override
    public List<Reponse> recuperer(Reponse t) throws SQLException {
          List<Reponse> Reponse = new ArrayList<>();
        String s = "select * from reponse ";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Reponse R = new Reponse();
            
            R.setId_rep(rs.getInt("id_Reponse"));
            R.setId_rec(rs.getInt("id_raclamation"));
            R.setText_rep(rs.getString("text_rep"));
            
            
            
            Reponse.add(R);
            
        }
        return Reponse;
    
    }
    
}
