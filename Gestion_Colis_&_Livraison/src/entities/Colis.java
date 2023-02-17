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
    int id;
    double poids;
    String type,Ldepart,Larrive;

    
    public Colis() {
    }

    public Colis(int id, double poids, String type, String Ldepart, String Larrive) {
        this.id = id;
        this.poids = poids;
        this.type = type;
        this.Ldepart = Ldepart;
        this.Larrive = Larrive;
    }
    
    
    public Colis(double poids, String type, String Ldepart, String Larrive) {
        this.poids = poids;
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

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
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
        return "Colis{" + "id=" + id + ", poids=" + poids + ", type=" + type + ", Ldepart=" + Ldepart + ", Larrive=" + Larrive + '}';
    }
    
    
}
