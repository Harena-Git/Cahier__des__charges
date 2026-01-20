
package cahier.de.charge.service;

import cahier.de.charge.model.Permission;
import cahier.de.charge.repository.PermissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionService {
    private final PermissionRepository repository;

    public PermissionService(PermissionRepository repository) {
        this.repository = repository;
    }

    public Permission save(Permission e) { return repository.save(e); }
    public List<Permission> findAll() { return repository.findAll(); }
    public Optional<Permission> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
