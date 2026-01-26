package cahier.de.charge.model;

import java.io.Serializable;

public class MethodeGestion implements Serializable {
    private Integer id;
    private String code;

    public MethodeGestion() {}

    public MethodeGestion(Integer id, String code) {
        this.id = id;
        this.code = code;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}