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
public class Livraison {
    
    int id_livraison,id_colis;
    String etat,cin_livreur;

    public Livraison() {
    }

    public Livraison(int id_livraison, int id_colis, String etat, String cin_livreur) {
        this.id_livraison = id_livraison;
        this.id_colis = id_colis;
        this.etat = etat;
        this.cin_livreur = cin_livreur;
    }

    public int getId_livraison() {
        return id_livraison;
    }

    public void setId_livraison(int id_livraison) {
        this.id_livraison = id_livraison;
    }

    public int getId_colis() {
        return id_colis;
    }

    public void setId_colis(int id_colis) {
        this.id_colis = id_colis;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getCin_livreur() {
        return cin_livreur;
    }

    public void setCin_livreur(String cin_livreur) {
        this.cin_livreur = cin_livreur;
    }

    @Override
    public String toString() {
        return "Livraison{" + "id_livraison=" + id_livraison + ", id_colis=" + id_colis + ", etat=" + etat + ", cin_livreur=" + cin_livreur + '}';
    }
    
    
    
}
