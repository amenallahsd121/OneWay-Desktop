/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package entities;

/**
 *
 * @author Houda
 */
/*public class Maintenance {
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

    public void setnom_sos_rep(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
*/

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
     private int id_maintenance,id_vehicule;
    private String etat , nom_sos_rep;

    public Maintenance() {
    }

    public Maintenance(int id_maintenance, String etat, String nom_sos_rep, int id_vehicule ) {
        this.id_maintenance = id_maintenance;
        this.etat = etat;
        this.nom_sos_rep = nom_sos_rep;
        this.id_vehicule= id_vehicule;
    }
    public Maintenance( String etat, String nom_sos_rep, int id_vehicule ) {
       
        this.etat = etat;
        this.nom_sos_rep = nom_sos_rep;
        this.id_vehicule= id_vehicule;
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

    public int getId_vehicule() {
        return id_vehicule;
    }

    public void setId_vehicule(int id_vehicule) {
        this.id_vehicule = id_vehicule;
    }

    public void setNom_sos_rep(String nom_sos_rep) {
        this.nom_sos_rep = nom_sos_rep;
    }

    @Override
    public String toString() {
        return "Maintenance{" + "id_maintenance=" + id_maintenance + ", id_vehicule=" + id_vehicule + ", etat=" + etat + ", nom_sos_rep=" + nom_sos_rep +"\n" + '}';
    }
    

    
    
    
}
