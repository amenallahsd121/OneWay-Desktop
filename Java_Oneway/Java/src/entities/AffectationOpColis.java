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
public class AffectationOpColis {
    
    private int idAff,idopp,idcolis;

    public AffectationOpColis() {
    }

    public AffectationOpColis(int idAff, int idopp, int idcolis) {
        this.idAff = idAff;
        this.idopp = idopp;
        this.idcolis = idcolis;
    }
     public AffectationOpColis( int idopp, int idcolis) {
   
        this.idopp = idopp;
        this.idcolis = idcolis;
    }

    public int getIdAff() {
        return idAff;
    }

    public int getIdopp() {
        return idopp;
    }

    public int getIdcolis() {
        return idcolis;
    }

    public void setIdAff(int idAff) {
        this.idAff = idAff;
    }

    public void setIdopp(int idopp) {
        this.idopp = idopp;
    }

    public void setIdcolis(int idcolis) {
        this.idcolis = idcolis;
    }

    @Override
    public String toString() {
        return "AffectationOpColis{" + "idAff=" + idAff + ", idopp=" + idopp + ", idcolis=" + idcolis + "\n" + '}';
    }
    
    
    
}
