/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author utilisateur
 */
public class CategorieOffre {
     private int IdCatOffre,nbreColisOffre ;
     private float poidsOffre;
     private String TypeOffre;

    public CategorieOffre() {
    }

    public CategorieOffre(int IdCatOffre, int nbreColisOffre, float poidsOffre, String TypeOffre) {
        this.IdCatOffre = IdCatOffre;
        this.nbreColisOffre = nbreColisOffre;
        this.poidsOffre = poidsOffre;
        this.TypeOffre = TypeOffre;
    }

  

    public void setIdCatOffre(int IdCatOffre) {
        this.IdCatOffre = IdCatOffre;
    }

    public void setPoidsOffre(float poidsOffre) {
        this.poidsOffre = poidsOffre;
    }

    public void setNbreColisOffre(int nbreColisOffre) {
        this.nbreColisOffre = nbreColisOffre;
    }

    public void setTypeOffre(String TypeOffre) {
        this.TypeOffre = TypeOffre;
    }

    public int getIdCatOffre() {
        return IdCatOffre;
    }

    public float getPoidsOffre() {
        return poidsOffre;
    }

    public int getNbreColisOffre() {
        return nbreColisOffre;
    }

    public String getTypeOffre() {
        return TypeOffre;
    }

   

   
}
