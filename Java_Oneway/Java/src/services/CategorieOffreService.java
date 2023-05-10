/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.CategorieOffre;
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
 * @author utilisateur
 */
public class CategorieOffreService  {
        Connection cnx;

     public CategorieOffreService() {
        cnx = MyDB.getInstance().getCnx();
    }

  
    public void ajouter(CategorieOffre t) throws SQLException {
String req = "INSERT INTO categorieoffre( poidsOffre, TypeOffre, nbreColisOffre) VALUES("
               + "'"  + t.getPoidsOffre()+ "','" +t.getTypeOffre()+  "',"+   t.getNbreColisOffre() +  ")";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);    }

   
    public void modifier(CategorieOffre t) throws SQLException {
String req = "UPDATE CategorieOffre SET IdCatOffre = ? ,poidsOffre = ? ,nbreColisOffre = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, t.getIdCatOffre());
        ps.setFloat(2, t.getPoidsOffre());
        ps.setInt(3, t.getNbreColisOffre());



        ps.executeUpdate();       }

   
    public void supprimer(CategorieOffre t) throws SQLException {

                String querry = "DELETE FROM CategorieOffre WHERE TypeOffre = '"+t.getTypeOffre()+"'";
                Statement stm = cnx.createStatement();

                stm.executeUpdate(querry);

                }

  
    public List<CategorieOffre> recuperer() throws SQLException {
List<CategorieOffre> CategorieOffres = new ArrayList<>();
        String s = "select * from CategorieOffre";
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(s);
        while (rs.next()) {
            CategorieOffre p = new CategorieOffre();

            p.setIdCatOffre(rs.getInt("IdCatOffre"));
            p.setPoidsOffre(rs.getFloat("PoidsOffre"));
            p.setNbreColisOffre(rs.getInt("NbreColisOffre"));
            p.setTypeOffre(rs.getString("TypeOffre"));

            CategorieOffres.add(p);

        }
        return CategorieOffres;    }
    
     public int Stats(String par,String field) {
     String s  = "select count(*) from categorieoffre where "+field+""+ "=" +"'"+par+"'";
   
  
      try {

        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);

            int num = 0;
            while(rs.next()){
                num = (rs.getInt(1));
                return num;
 
            }
        } catch (SQLException ex) {
            
        }
        return 0 ;
    }

   
}
