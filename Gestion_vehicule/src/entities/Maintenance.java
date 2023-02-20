/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Houda
 */
public class Maintenance {
     private int id_maintenance;
    private String etat , nom_sos_rep;

    public Maintenance() {
    }

    public Maintenance(int id_maintenance, String etat, String nom_sos_rep) {
        this.id_maintenance = id_maintenance;
        this.etat = etat;
        this.nom_sos_rep = nom_sos_rep;
    }

    public int getId_maintenance() {
        return id_maintenance;
    }

    public void setId_maintenance(int id_maintenance) {
        this.id_maintenance = id_maintenance;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getNom_sos_rep() {
        return nom_sos_rep;
    }

    public void setNom_soc_rep(String nom_sos_rep) {
        this.nom_sos_rep = nom_sos_rep;
    }

    @Override
    public String toString() {
        return "Maintenance{" + "id_maintenance=" + id_maintenance + ", etat=" + etat + ", nom_sos_rep=" + nom_sos_rep + '}';
    }
    
    
    
}
