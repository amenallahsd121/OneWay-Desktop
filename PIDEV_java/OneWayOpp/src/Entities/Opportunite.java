/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Meddeb sofien
 */
public class Opportunite {
      private int id_opp;
      private Float heure_arrivee,heur_depart;
      private String date,depart,arrivee,description;

    public Opportunite() {
    }

    public Opportunite(int id_opp,String date,String depart,Float heur_depart, String arrivee, Float heure_arrivee,String description) {
        this.id_opp = id_opp;
        this.heure_arrivee = heure_arrivee;
        this.heur_depart = heur_depart;
        this.date = date;
        this.depart = depart;
        this.arrivee = arrivee;
        this.description = description;
    }
     public Opportunite(String date,String depart,Float heur_depart, String arrivee, Float heure_arrivee,String description) {
        
        this.heure_arrivee = heure_arrivee;
        this.heur_depart = heur_depart;
        this.date = date;
        this.depart = depart;
        this.arrivee = arrivee;
        this.description = description;
    }

    public int getId_opp() {
        return id_opp;
    }

    public Float getHeure_arrivee() {
        return heure_arrivee;
    }

    public Float getHeur_depart() {
        return heur_depart;
    }

    public String getDate() {
        return date;
    }

    public String getDepart() {
        return depart;
    }

    public String getArrivee() {
        return arrivee;
    }

    public String getDescription() {
        return description;
    }

    public void setId_opp(int id_opp) {
        this.id_opp = id_opp;
    }

    public void setHeure_arrivee(Float heure_arrivee) {
        this.heure_arrivee = heure_arrivee;
    }

    public void setHeur_depart(Float heur_depart) {
        this.heur_depart = heur_depart;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public void setArrivee(String arrivee) {
        this.arrivee = arrivee;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Opportunite{" + "id_opp=" + id_opp + ", heure_arrivee=" + heure_arrivee + ", heur_depart=" + heur_depart + ", date=" + date + ", depart=" + depart + ", arrivee=" + arrivee + ", description=" + description +  "\n" + '}';
    }

   
      
    
}
