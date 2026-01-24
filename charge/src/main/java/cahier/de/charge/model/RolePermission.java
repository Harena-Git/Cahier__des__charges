
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
public class RolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@ManyToOne
private Role role;

@ManyToOne
private Permission permission;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
