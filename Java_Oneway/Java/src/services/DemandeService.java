/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Demande;
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
public class DemandeService {

    Connection cnx;

    public DemandeService() {
        cnx = MyDB.getInstance().getCnx();
    }


    public void ajouter(Demande t) throws SQLException {
        String req = "INSERT INTO Demande( DescriptionDemande,IdOffre,IdColis,IdPersonne,prix) VALUES("
                + "'" + t.getDescriptionDemande() + "','" + t.getIdOffre() + "','" + t.getIdColis() + "','" + t.getIdPersonne() + "'," + t.getPrix() + ")";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
    }

  
    public void modifier(Demande t) throws SQLException {
        String req = "UPDATE Demande SET  IdDemande = ?,IdOffre = ? ,IdColis = ? ,IdPersonne = ? ,DescriptionDemande = ? ,prix=?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setLong(1, t.getIdDemande());
        ps.setInt(2, t.getIdOffre());
        ps.setInt(3, t.getIdColis());
        ps.setInt(4, t.getIdPersonne());
        ps.setString(5, t.getDescriptionDemande());

        ps.setDouble(6, t.getPrix());

        ps.executeUpdate();
    }
    
    
  
    public void supprimer(Demande t) throws SQLException {
        String querry = "DELETE FROM Demande WHERE IdDemande = '" + t.getIdDemande() + "'";
        Statement stm = cnx.createStatement();

        stm.executeUpdate(querry);

    }

    
    public List<Demande> recuperer() throws SQLException {
        List<Demande> Demandes = new ArrayList<>();
        String s = "select * from Demande";
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(s);
        while (rs.next()) {
            Demande p = new Demande();

            p.setDescriptionDemande(rs.getString("DescriptionDemande"));
            p.setIdDemande(rs.getInt("IdDemande"));
            p.setIdOffre(rs.getInt("IdOffre"));
            p.setIdColis(rs.getInt("IdColis"));
            p.setIdPersonne(rs.getInt("IdPersonne"));
            p.setPrix(rs.getDouble("Prix"));

            Demandes.add(p);

        }
        return Demandes;
    }

}
