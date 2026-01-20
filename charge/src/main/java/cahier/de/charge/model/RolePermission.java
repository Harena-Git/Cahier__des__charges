
package cahier.de.charge.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rolepermission")
public class RolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
