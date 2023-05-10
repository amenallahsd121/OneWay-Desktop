/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import services.TrajetService;

/**
 *
 * @author utilisateur
 */
public class TrajetOffre {

    private  long IdTrajetOffre ;

    private int LimiteKmOffre, NbreEscaleOffre, nbreOffre;
    private List<Offre> idoffres = new ArrayList<>();

    private String AddArriveOffre, AddDepartOffre, description;

    public TrajetOffre() {
    }



    public TrajetOffre(long IdTrajetOffre, int LimiteKmOffre, int NbreEscaleOffre, String AddArriveOffre, String AddDepartOffre) {
    this.LimiteKmOffre = LimiteKmOffre;
        this.NbreEscaleOffre = NbreEscaleOffre;
        this.AddArriveOffre = AddArriveOffre;
        this.AddDepartOffre = AddDepartOffre;
        this.description = AddDepartOffre.concat(AddArriveOffre);
        this.IdTrajetOffre = IdTrajetOffre;
        this.nbreOffre = idoffres.size();
        
    }
    

    public TrajetOffre(int LimiteKmOffre, int NbreEscaleOffre, String AddArriveOffre, String AddDepartOffre) {
this.LimiteKmOffre = LimiteKmOffre;
        this.NbreEscaleOffre = NbreEscaleOffre;
        this.AddArriveOffre = AddArriveOffre;
        this.AddDepartOffre = AddDepartOffre;
        this.description = AddArriveOffre.concat(AddDepartOffre);
        this.nbreOffre = idoffres.size();    }
 public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public List<Offre> getIdoffres() {
        return idoffres;
    }

    public void setIdoffres(Offre idoffres) {
        this.idoffres.add(idoffres);
        this.setNbreOffre(this.getNbreOffre() + 1);

    }

    public List<Offre> getidoffres() {
        return idoffres;
    }

    public long getIdTrajetOffre() {
        return IdTrajetOffre;
    }

    public int getLimiteKmOffre() {
        return LimiteKmOffre;
    }

    public int getNbreEscaleOffre() {
        return NbreEscaleOffre;
    }

    public String getAddArriveOffre() {
        return AddArriveOffre;
    }

    public String getAddDepartOffre() {
        return AddDepartOffre;
    }

    public int getNbreOffre() {
        return nbreOffre;
    }

    public void setIdTrajetOffre(long IdTrajetOffre) {
        this.IdTrajetOffre = IdTrajetOffre;
    }

    public void setLimiteKmOffre(int LimiteKmOffre) {
        this.LimiteKmOffre = LimiteKmOffre;
    }

    public void setNbreEscaleOffre(int NbreEscaleOffre) {
        this.NbreEscaleOffre = NbreEscaleOffre;
    }

    public void setAddArriveOffre(String AddArriveOffre) {
        this.AddArriveOffre = AddArriveOffre;
    }

    public void setAddDepartOffre(String AddDepartOffre) {
        this.AddDepartOffre = AddDepartOffre;
    }

    public void setNbreOffre(int nbreOffre) {
        this.nbreOffre = nbreOffre;
    }

    @Override
    public String toString() {
        return "TrajetOffre{" + "IdTrajetOffre=" + IdTrajetOffre + ", LimiteKmOffre=" + LimiteKmOffre + ", NbreEscaleOffre=" + NbreEscaleOffre + ", idoffres=" + idoffres + ", nbreOffre=" + nbreOffre + ", AddArriveOffre=" + AddArriveOffre + ", AddDepartOffre=" + AddDepartOffre + '}';
    }

   

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TrajetOffre other = (TrajetOffre) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }


   

  

}
