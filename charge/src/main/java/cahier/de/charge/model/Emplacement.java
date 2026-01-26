package cahier.de.charge.model;

import java.io.Serializable;

public class Emplacement implements Serializable {
    private Integer id;
    private String code;
    private Integer depotId;

    public Emplacement() {}

    public Emplacement(Integer id, String code, Integer depotId) {
        this.id = id;
        this.code = code;
        this.depotId = depotId;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    
    public Integer getDepotId() { return depotId; }
    public void setDepotId(Integer depotId) { this.depotId = depotId; }
}