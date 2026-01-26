package cahier.de.charge.model;

import java.io.Serializable;
import java.sql.Date;

public class DelegationTemporaire implements Serializable {
    private Integer id;
    private Integer delegantUserId;
    private Integer delegataireUserId;
    private Integer roleId;
    private Date dateDebut;
    private Date dateFin;

    public DelegationTemporaire() {}

    public DelegationTemporaire(Integer id, Integer delegantUserId, Integer delegataireUserId, Integer roleId, Date dateDebut, Date dateFin) {
        this.id = id;
        this.delegantUserId = delegantUserId;
        this.delegataireUserId = delegataireUserId;
        this.roleId = roleId;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Integer getDelegantUserId() { return delegantUserId; }
    public void setDelegantUserId(Integer delegantUserId) { this.delegantUserId = delegantUserId; }
    
    public Integer getDelegataireUserId() { return delegataireUserId; }
    public void setDelegataireUserId(Integer delegataireUserId) { this.delegataireUserId = delegataireUserId; }
    
    public Integer getRoleId() { return roleId; }
    public void setRoleId(Integer roleId) { this.roleId = roleId; }
    
    public Date getDateDebut() { return dateDebut; }
    public void setDateDebut(Date dateDebut) { this.dateDebut = dateDebut; }
    
    public Date getDateFin() { return dateFin; }
    public void setDateFin(Date dateFin) { this.dateFin = dateFin; }
}