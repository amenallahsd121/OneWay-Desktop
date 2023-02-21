
package entity;


public class utilisateur {
    private int id;
    private int nbr_point;
   private String name,lastname,adresse,email;
   private String type;

    public utilisateur() {
    }

    public utilisateur(int id, String name, String lastname, String adresse, String email, String type,int nbr_point) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.adresse = adresse;
        this.email = email;
        this.type = type;
        this.nbr_point = nbr_point ;
    }
    public utilisateur( String name, String lastname, String adresse, String email, String type,int nbr_point) {
        this.name = name;
        this.lastname = lastname;
        this.adresse = adresse;
        this.email = email;
        this.type = type;
        this.nbr_point = nbr_point ;
    }

    public int getNbr_point() {
        return nbr_point;
    }

    public void setNbr_point(int nbr_point) {
        this.nbr_point = nbr_point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "utilisateur{" + "id=" + id + ", nbr_point=" + nbr_point + ", name=" + name + ", lastname=" + lastname + ", adresse=" + adresse + ", email=" + email + ", type=" + type + '}';
    }

   

    
   
}
