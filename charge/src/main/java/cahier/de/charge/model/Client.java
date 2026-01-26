package cahier.de.charge.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Client implements Serializable {
    private Integer id;
    private Integer typeclientId;
    private String raisonSociale;
    private String telephone;
    private String email;
    private Timestamp dateCreation;

    public Client() {}

    public Client(Integer id, Integer typeclientId, String raisonSociale, String telephone, String email, Timestamp dateCreation) {
        this.id = id;
        this.typeclientId = typeclientId;
        this.raisonSociale = raisonSociale;
        this.telephone = telephone;
        this.email = email;
        this.dateCreation = dateCreation;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Integer getTypeclientId() { return typeclientId; }
    public void setTypeclientId(Integer typeclientId) { this.typeclientId = typeclientId; }
    
    public String getRaisonSociale() { return raisonSociale; }
    public void setRaisonSociale(String raisonSociale) { this.raisonSociale = raisonSociale; }
    
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public Timestamp getDateCreation() { return dateCreation; }
    public void setDateCreation(Timestamp dateCreation) { this.dateCreation = dateCreation; }
}