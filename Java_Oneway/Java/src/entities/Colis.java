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
public class Colis {
 
      private 
    int id,id_client;
    double poids,prix;
    String type,Ldepart,Larrive;

    public Colis() {
    }

    public Colis(int id, int id_client, double poids, double prix, String type, String Ldepart, String Larrive) {
        this.id = id;
        this.id_client = id_client;
        this.poids = poids;
        this.prix = prix;
        this.type = type;
        this.Ldepart = Ldepart;
        this.Larrive = Larrive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLdepart() {
        return Ldepart;
    }

    public void setLdepart(String Ldepart) {
        this.Ldepart = Ldepart;
    }

    public String getLarrive() {
        return Larrive;
    }

    public void setLarrive(String Larrive) {
        this.Larrive = Larrive;
    }

    @Override
    public String toString() {
        return "Colis{" + "id=" + id + ", id_client=" + id_client + ", poids=" + poids + ", prix=" + prix + ", type=" + type + ", Ldepart=" + Ldepart + ", Larrive=" + Larrive + '}';
    }

   
    
    
    
    
    
    
    
    
    
    
    
   
    
}
