package cahier.de.charge.model;

import java.io.Serializable;

public class TypeMouvement implements Serializable {
    private Integer id;
    private String code;

    public TypeMouvement() {}

    public TypeMouvement(Integer id, String code) {
        this.id = id;
        this.code = code;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}