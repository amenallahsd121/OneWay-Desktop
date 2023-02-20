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
public class Vehicule {
    private int id_vehicule;
    private String matricule, marque ;

    public Vehicule() {
    }

    public Vehicule(int id_vehicule, String matricule, String marque) {
        this.id_vehicule = id_vehicule;
        this.matricule = matricule;
        this.marque = marque;
    }

    public int getId_vehicule() {
        return id_vehicule;
    }

    public void setId_vehicule(int id_vehicule) {
        this.id_vehicule = id_vehicule;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Override
    public String toString() {
        return "Vehicule{" + "id_vehicule=" + id_vehicule + ", matricule=" + matricule + ", marque=" + marque + '}';
    }
    
    
}
