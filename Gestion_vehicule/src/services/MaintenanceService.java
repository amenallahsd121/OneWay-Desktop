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
import entities.Maintenance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;
public class MaintenanceService implements IService<Maintenance> { 
    Connection cnx;

    public MaintenanceService() {
        cnx = MyDB.getInstance().getCnx();
    }
     @Override
    public void ajouter(Maintenance t) throws SQLException {
       /* String req = "INSERT INTO maintenance(etat,nom_sos_rep) VALUES("
                + "'" + t.getEtat()+ "','" + t.getNom_sos_rep()+ "'" + ")";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);*/
       
       String req = "INSERT INTO maintenance(etat,nom_sos_rep,id_vehicule) VALUES("
                + "'" + t.getEtat()+ "','" + t.getNom_sos_rep()+ "','" +t.getId_vehicule() + "'" +")";
          
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
    }
    @Override
    public void modifier(Maintenance t) throws SQLException {
        String req = "UPDATE maintenance SET etat = ?,nom_sos_rep = ? where id_maintenance = ?";
        PreparedStatement vm = cnx.prepareStatement(req);
        vm.setString(1, t.getEtat());
        vm.setString(2, t.getNom_sos_rep());
        vm.setInt(3, t.getId_maintenance());
        vm.executeUpdate();
        
    }
    
    @Override
    public boolean supprimer(Maintenance t) throws SQLException {
       boolean ok = false;
       try {
       String req = " DELETE FROM maintenance where id_maintenance = ?   ";
         
            PreparedStatement vm = cnx.prepareStatement(req);
            vm.setInt(1, t.getId_maintenance());
            vm.executeUpdate();
            ok= true;
            }
        catch ( SQLException ex){
            System.out.println("error in delete"+ex);
       
           
        }
        return ok;
            
            
    }
    
    
    
    @Override
    public List<Maintenance> recuperer() throws SQLException {
        List<Maintenance> maintenance = new ArrayList<>();
        String s = "select * from maintenance";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Maintenance m = new Maintenance();
            m.setEtat(rs.getString("etat"));
            m.setNom_soc_rep(rs.getString("nom_sos_rep"));
            m.setId_maintenance(rs.getInt("id_maintenance"));
            
            
             maintenance.add(m);
            
        }
        return  maintenance;
    }
    
    
}
