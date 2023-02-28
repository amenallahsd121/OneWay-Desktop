
package entity;

import java.sql.Date;
import java.time.LocalDate;


public class utilisateur {
    private int id;
    private int nbr_point;
   private String name,lastname,adresse,email;
   private String type;
   private String password;
   private LocalDate birthdate;



    public utilisateur() {
    }

    public utilisateur( String name, String lastname, String email, String adresse, String type,LocalDate birthdate,String password) {
        this.name = name;
        this.lastname = lastname;
        this.adresse = adresse;
        this.email = email;
        this.type = type;
        this.password = password;
        this.nbr_point = nbr_point ;
        this.birthdate = birthdate;
    }
    
    public utilisateur( String name, String lastname, String email, String adresse, String type,String password) {
        this.name = name;
        this.lastname = lastname;
        this.adresse = adresse;
        this.email = email;
        this.type = type;
        this.password = password;
        
    }
public utilisateur( String name,String password) {
        this.name = name;
        this.password = password;
        
    }
    
        public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "utilisateur{" + "id=" + id + ", nbr_point=" + nbr_point + ", name=" + name + ", lastname=" + lastname + ", adresse=" + adresse + ", email=" + email + ", type=" + type + ", password=" + password + ", birthdate=" + birthdate + '}';
    }

    

    

   

    
   
}
