
package cahier.de.charge.service;

import cahier.de.charge.model.Permission;
import cahier.de.charge.repository.PermissionRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PermissionService {
    private final PermissionRepository repo;
    public PermissionService(PermissionRepository repo) { this.repo = repo; }
    public Permission save(Permission e) { return repo.save(e); }
    public List<Permission> findAll() { return repo.findAll(); }
    public Optional<Permission> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
