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
    int id_rep;
    String text_rep;

    public Reponse() {
    }

    public Reponse(int id_rep, String text_rep) {
        this.id_rep = id_rep;
        this.text_rep = text_rep;
    }

    public int getId_rep() {
        return id_rep;
    }

    public void setId_rep(int id_rep) {
        this.id_rep = id_rep;
    }

    public String getText_rep() {
        return text_rep;
    }

    public void setText_rep(String text_rep) {
        this.text_rep = text_rep;
    }

    @Override
    public String toString() {
        return "reponse{" + "id_rep=" + id_rep + ", text_rep=" + text_rep + '}';
    }
    
    
}
