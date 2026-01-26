package cahier.de.charge.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Article implements Serializable {
    private Integer id;
    private String reference;
    private String designation;
    private String description;
    private Integer categorieArticleId;
    private Integer uniteMesureStockId;
    private Integer uniteMesureAchatId;
    private Integer uniteMesureVenteId;
    private Boolean estActif;
    private Timestamp dateCreation;

    public Article() {}

    public Article(Integer id, String reference, String designation, String description, Integer categorieArticleId, 
                   Integer uniteMesureStockId, Integer uniteMesureAchatId, Integer uniteMesureVenteId, 
                   Boolean estActif, Timestamp dateCreation) {
        this.id = id;
        this.reference = reference;
        this.designation = designation;
        this.description = description;
        this.categorieArticleId = categorieArticleId;
        this.uniteMesureStockId = uniteMesureStockId;
        this.uniteMesureAchatId = uniteMesureAchatId;
        this.uniteMesureVenteId = uniteMesureVenteId;
        this.estActif = estActif;
        this.dateCreation = dateCreation;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getReference() { return reference; }
    public void setReference(String reference) { this.reference = reference; }
    
    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public Integer getCategorieArticleId() { return categorieArticleId; }
    public void setCategorieArticleId(Integer categorieArticleId) { this.categorieArticleId = categorieArticleId; }
    
    public Integer getUniteMesureStockId() { return uniteMesureStockId; }
    public void setUniteMesureStockId(Integer uniteMesureStockId) { this.uniteMesureStockId = uniteMesureStockId; }
    
    public Integer getUniteMesureAchatId() { return uniteMesureAchatId; }
    public void setUniteMesureAchatId(Integer uniteMesureAchatId) { this.uniteMesureAchatId = uniteMesureAchatId; }
    
    public Integer getUniteMesureVenteId() { return uniteMesureVenteId; }
    public void setUniteMesureVenteId(Integer uniteMesureVenteId) { this.uniteMesureVenteId = uniteMesureVenteId; }
    
    public Boolean getEstActif() { return estActif; }
    public void setEstActif(Boolean estActif) { this.estActif = estActif; }
    
    public Timestamp getDateCreation() { return dateCreation; }
    public void setDateCreation(Timestamp dateCreation) { this.dateCreation = dateCreation; }
}