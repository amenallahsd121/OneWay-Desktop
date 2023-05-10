
package entity;

public class location {
    private int id,id_delai;
    private double Xaxe , Yaxe;
    private String adresse;

    public location() {
    }

    public location(int id, int id_delai, double Xaxe, double Yaxe, String adresse) {
        this.id = id;
        this.id_delai = id_delai;
        this.Xaxe = Xaxe;
        this.Yaxe = Yaxe;
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_delai() {
        return id_delai;
    }

    public void setId_delai(int id_delai) {
        this.id_delai = id_delai;
    }

    public double getXaxe() {
        return Xaxe;
    }

    public void setXaxe(double Xaxe) {
        this.Xaxe = Xaxe;
    }

    public double getYaxe() {
        return Yaxe;
    }

    public void setYaxe(double Yaxe) {
        this.Yaxe = Yaxe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
}
