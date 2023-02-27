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
    int id_rep,id_rec,id_user;
    String text_rep;
    
    public Reponse() {
    }

    public Reponse(int id_rep, int id_rec,int id_user, String text_rep) {
        this.id_user=id_user;
        this.id_rep = id_rep;
        this.id_rec = id_rec;
        this.text_rep = text_rep;
    }
     public Reponse( int id_rec,int id_user, String text_rep) {
        this.id_user=id_user;
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

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Reponse{" + "id_rep=" + id_rep + ", id_rec=" + id_rec + ", id_user=" + id_user + ", text_rep=" + text_rep + '}';
    }

   
    
    
    
    
    
    
    
    
    
    
    
}