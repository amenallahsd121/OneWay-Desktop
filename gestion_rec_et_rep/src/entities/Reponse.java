/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author hp
 */
public class Reponse {
    int id_rep,id_rec;
    String text_rep;

    public Reponse() {
    }

    public Reponse(int id_rep, int id_rec, String text_rep) {
        this.id_rep = id_rep;
        this.id_rec = id_rec;
        this.text_rep = text_rep;
    }

    public int getId_rep() {
        return id_rep;
    }

    public void setId_rep(int id_rep) {
        this.id_rep = id_rep;
    }

    public int getId_rec() {
        return id_rec;
    }

    public void setId_rec(int id_rec) {
        this.id_rec = id_rec;
    }

    public String getText_rep() {
        return text_rep;
    }

    public void setText_rep(String text_rep) {
        this.text_rep = text_rep;
    }

    @Override
    public String toString() {
        return "Reponse{" + "id_rep=" + id_rep + ", id_rec=" + id_rec + ", text_rep=" + text_rep + '}';
    }

    
    
    
    
    
    
    
    
    
    
    
}