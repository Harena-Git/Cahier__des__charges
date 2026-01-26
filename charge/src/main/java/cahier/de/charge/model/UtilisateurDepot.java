package cahier.de.charge.model;

import java.io.Serializable;

public class UtilisateurDepot implements Serializable {
    private Integer id;
    private Integer utilisateurId;
    private Integer depotId;
    private Integer roleId;

    public UtilisateurDepot() {}

    public UtilisateurDepot(Integer id, Integer utilisateurId, Integer depotId, Integer roleId) {
        this.id = id;
        this.utilisateurId = utilisateurId;
        this.depotId = depotId;
        this.roleId = roleId;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Integer getUtilisateurId() { return utilisateurId; }
    public void setUtilisateurId(Integer utilisateurId) { this.utilisateurId = utilisateurId; }
    
    public Integer getDepotId() { return depotId; }
    public void setDepotId(Integer depotId) { this.depotId = depotId; }
    
    public Integer getRoleId() { return roleId; }
    public void setRoleId(Integer roleId) { this.roleId = roleId; }
}