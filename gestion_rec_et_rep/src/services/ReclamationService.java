/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services; 
import entities.Reclamation;
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
public class ReclamationService implements IService <Reclamation> {
Connection cnx;

    public ReclamationService() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Reclamation t) throws SQLException {
        
      /* PreparedStatement stmt = cnx.prepareStatement("INSERT INTO reclamation (text_rec) VALUES (?)");
       
       stmt.setString(1, t.getText_rec());
        Statement st = cnx.createStatement();
        stmt.executeUpdate();
*/
        String req = "INSERT INTO reclamation (text_rec,sujet) VALUES("
                + "'" + t.getText_rec() + "','" + t.getSujet() + "'" + ")";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
      
      
    }

    @Override
    public void modifier(Reclamation t) throws SQLException {
        String req = "UPDATE reclamation SET text_rec = ?,sujet = ? where id_reclamation = ?";
        PreparedStatement vs = cnx.prepareStatement(req);
        vs.setString(1, t.getText_rec());
        vs.setString(2, t.getSujet());
        vs.setInt(3, t.getId_rec());
        vs.executeUpdate();

    }

    @Override
    public boolean supprimer(Reclamation t) throws SQLException {
        boolean ok = false;
        try {
         String req = " DELETE FROM reclamation where id_reclamation = ?   ";
         
            PreparedStatement vs = cnx.prepareStatement(req);
             vs.setInt(1, t.getId_rec());
            vs.executeUpdate();
            ok= true;
        }
        catch ( SQLException ex){
            System.out.println("error in delete"+ex);
        
           
        }
        return ok;
    }

    @Override
    public List<Reclamation> recuperer() throws SQLException {
          List<Reclamation> Reclamation = new ArrayList<>();
        String s = "select * from reclamation ";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Reclamation R = new Reclamation();
            
            R.setId_rec(rs.getInt("id_reclamation"));
            R.setSujet(rs.getString("sujet"));
            R.setText_rec(rs.getString("text_rec"));
            
            
            
            Reclamation.add(R);
            
        }
        return Reclamation;
    }
    
    public Reclamation recherche(int id) {
        Reclamation P = null;
        String Req = "select * from reclamation where id_reclamation= " + id + "";
                  
   
        try {
            
           Statement ste = cnx.createStatement();
           ResultSet res =  ste.executeQuery(Req); //recherche
            while (res.next()) {

               P= new Reclamation(res.getInt(1), res.getString(2), res.getString(3));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return P;
    }
    }
    

