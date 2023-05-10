/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author amens
 */
public class Livreur {
    int id_livreur;
    String cin_livreur,nom,prenom,vehicule;

    public Livreur() {
    }

    public Livreur(int id_livreur, String cin_livreur, String nom, String prenom, String vehicule) {
        this.id_livreur = id_livreur;
        this.cin_livreur = cin_livreur;
        this.nom = nom;
        this.prenom = prenom;
        this.vehicule = vehicule;
    }

    public int getId_livreur() {
        return id_livreur;
    }

    public void setId_livreur(int id_livreur) {
        this.id_livreur = id_livreur;
    }

    public String getCin_livreur() {
        return cin_livreur;
    }

    public void setCin_livreur(String cin_livreur) {
        this.cin_livreur = cin_livreur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getVehicule() {
        return vehicule;
    }

    public void setVehicule(String vehicule) {
        this.vehicule = vehicule;
    }

    @Override
    public String toString() {
        return "Livreur{" + "id_livreur=" + id_livreur + ", cin_livreur=" + cin_livreur + ", nom=" + nom + ", prenom=" + prenom + ", vehicule=" + vehicule + '}';
    }
    
    
    
    
    
    
    
    
    
    

}