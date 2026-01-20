
package cahier.de.charge.service;

import cahier.de.charge.model.RolePermission;
import cahier.de.charge.repository.RolePermissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolePermissionService {
    private final RolePermissionRepository repository;

    public RolePermissionService(RolePermissionRepository repository) {
        this.repository = repository;
    }

    public RolePermission save(RolePermission e) { return repository.save(e); }
    public List<RolePermission> findAll() { return repository.findAll(); }
    public Optional<RolePermission> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
