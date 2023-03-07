
package entity;

public class relais {
     private String name,adresse,lastname,city,email;
    private int number,id;

    public relais() {
    }

    public relais(int id, String name, String adresse,String lastname,String email, String city, int number) {
        this.id = id;
        this.name = name;        
        this.lastname = lastname;        
        this.email = email;
        this.adresse = adresse;
        this.city = city;
        this.number = number;
    }
    public relais ( String name, String adresse,String lastname,String email, String city, int number) {
        
        this.name = name;        
        this.lastname = lastname;        
        this.email = email;
        this.adresse = adresse;
        this.city = city;
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "relais{" + "id=" + id + ", name=" + name + ", adresse=" + adresse + ", lastname=" + lastname + ", city=" + city + ", email=" + email + ", number=" + number + '}';
    }

    

    

    
}
