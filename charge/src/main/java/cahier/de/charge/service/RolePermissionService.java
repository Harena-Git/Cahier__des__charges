
package cahier.de.charge.service;

import cahier.de.charge.model.RolePermission;
import cahier.de.charge.repository.RolePermissionRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class RolePermissionService {
    private final RolePermissionRepository repo;
    public RolePermissionService(RolePermissionRepository repo) { this.repo = repo; }
    public RolePermission save(RolePermission e) { return repo.save(e); }
    public List<RolePermission> findAll() { return repo.findAll(); }
    public Optional<RolePermission> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
