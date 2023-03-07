/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import services.OffreService;
import services.TrajetService;

/**
 *
 * @author Houda
 */
public class Offre {

    private  int IdOffre, IdCatColis,IdUser;
         private  int   nbreDemande;
    private String IdTrajetOffre;   
    private String DescriptionOffre, MaxRetard,Etat,CatOffreId;
    private TrajetOffre IdTrajetOffres ;
    private float prixOffre;
    Date date = new Date();
    SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat dateFormat = SimpleDateFormat.getDateInstance();
    private String DateOffre = dateFormat.format(date);
    private String DateSortieOffre = DateFor.format(date);

    public Offre() {
    }
    
    public Offre(int IdOffre,int IdCatColis,int IdUser, String CatOffreId, String DescriptionOffre, String MaxRetard, float prixOffre, String DateSortieOffre,long IdTrajetOffre,int LimiteKmOffre, int NbreEscaleOffre, String AddArriveOffre, String AddDepartOffre) throws SQLException, ParseException  {
        this.IdOffre=IdOffre ;
        this.IdCatColis = IdCatColis;
        this.CatOffreId = CatOffreId;
        this.IdUser=IdUser;
        this.DescriptionOffre = DescriptionOffre;
        this.MaxRetard = MaxRetard;
        this.prixOffre = prixOffre;
        this.DateSortieOffre = DateSortieOffre;
        this.Etat= this.etat_m(DateSortieOffre,this.DateOffre);
        this.IdTrajetOffres = new TrajetOffre(IdTrajetOffre,LimiteKmOffre, NbreEscaleOffre, AddArriveOffre,AddDepartOffre);
        this.IdTrajetOffres.setIdoffres(this);
        this.IdTrajetOffre=IdTrajetOffres.getDescription();
       
    }
    public Offre(int IdOffre,int IdUser,int IdCatColis, String CatOffreId, String DescriptionOffre, String MaxRetard, float prixOffre, String DateSortieOffre,String IdTrajetOffre) throws SQLException, ParseException  {
                this.IdOffre = IdOffre;
this.IdUser=IdUser;
        this.IdCatColis = IdCatColis;
        this.CatOffreId = CatOffreId;
        this.DescriptionOffre = DescriptionOffre;
        this.MaxRetard = MaxRetard;
        this.prixOffre = prixOffre;
        this.DateSortieOffre = DateSortieOffre;
        this.Etat= this.etat_m(DateSortieOffre,this.DateOffre);
        this.IdTrajetOffre=IdTrajetOffre;
    }
    public Offre(int IdCatColis,int IdUser, String CatOffreId, String DescriptionOffre, String MaxRetard, float prixOffre, String DateSortieOffre,String IdTrajetOffre) throws SQLException, ParseException  {
        this.IdCatColis = IdCatColis;
        this.CatOffreId = CatOffreId;
        this.IdUser=IdUser;
        this.DescriptionOffre = DescriptionOffre;
        this.MaxRetard = MaxRetard;
        this.prixOffre = prixOffre;
        this.DateSortieOffre = DateSortieOffre;
        this.Etat= this.etat_m(DateSortieOffre,this.DateOffre);
        this.IdTrajetOffre=IdTrajetOffre;
    }

    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }

    public int getIdUser() {
        return IdUser;
    }

   
   
    
 public void setDateOffre(String DateOffre) {
        this.DateOffre = DateOffre;
    }

    public void setDateSortieOffre(String DateSortieOffre) {
        this.DateSortieOffre = DateSortieOffre;
    }

    public String getEtat() {
        return Etat;
    }
    public int getNbreDemande() {
        return nbreDemande;
    }
    

    public TrajetOffre getIdTrajetOffres() {
        return IdTrajetOffres;
    }

    public void setIdOffre(int IdOffre) {
        this.IdOffre = IdOffre;
    }

    public void setIdCatColis(int IdCatColis) {
        this.IdCatColis = IdCatColis;
    }

    public void setCatOffreId(String CatOffreId) {
        this.CatOffreId = CatOffreId;
    }

    public void setDescriptionOffre(String DescriptionOffre) {
        this.DescriptionOffre = DescriptionOffre;
    }

    public void setMaxRetard(String MaxRetard) {
        this.MaxRetard = MaxRetard;
    }

    public void setIdTrajetOffre(String IdTrajetOffre) {
        this.IdTrajetOffre = IdTrajetOffre;
    }

    public void setNbreDemande(int nbreDemande) {
        this.nbreDemande = nbreDemande;
    }

    public void setPrixOffre(float prixOffre) {
        this.prixOffre = prixOffre;
    }

    public int getIdOffre() {
        return IdOffre;
    }

    public int getIdCatColis() {
        return IdCatColis;
    }

    public String getCatOffreId() {
        return CatOffreId;
    }

    public String getDescriptionOffre() {
        return DescriptionOffre;
    }

    public String getMaxRetard() {
        return MaxRetard;
    }

    public String getIdTrajetOffre() {
        return IdTrajetOffre;
    }

    public float getPrixOffre() {
        return prixOffre;
    }

    public String getDateOffre() {
        return DateOffre;
    }

    public String getDateSortieOffre() {
        return DateSortieOffre;
    }

    @Override
    public String toString() {
        return "Offre{" + "IdOffre=" + IdOffre + ", IdCatColis=" + IdCatColis + ", CatOffreId=" + CatOffreId + ", DescriptionOffre=" + DescriptionOffre + ", MaxRetard=" + MaxRetard + ", IdTrajetOffre=" + IdTrajetOffre + ", prixOffre=" + prixOffre + ", date=" + date + ", DateFor=" + DateFor + ", dateFormat=" + dateFormat + ", DateOffre=" + DateOffre + ", DateSortieOffre=" + DateSortieOffre + '}';
    }

   public void setEtat(String Etat) {
        this.Etat = Etat;
    }
     public String etat_m (String DateSortieOffre,String DateOffre) throws ParseException{
         Date D1 =dateFormat.parse(DateOffre);
         Date D2 =DateFor.parse(DateSortieOffre);
        if(D2.after(D1)){
            Etat="finish";
        }else if(D2.before(D1)){             Etat="EnCours";
 }else{Etat="today"; }
        return Etat;
     }
}
