
package entity;

public class relais {
     private String id,name,adresse,city;
    private int capacity;

    public relais() {
    }

    public relais(String id, String name, String adresse, String city, int capacity) {
        this.id = id;
        this.name = name;
        this.adresse = adresse;
        this.city = city;
        this.capacity = capacity;
    }
 public relais( String name, String adresse, String city, int capacity) {
        
        this.name = name;
        this.adresse = adresse;
        this.city = city;
        this.capacity = capacity;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "relais{" + "id=" + id + ", name=" + name + ", adresse=" + adresse + ", city=" + city + ", capacity=" + capacity + '}';
    }
    
}
