
package cahier.de.charge.service;

import cahier.de.charge.model.Role;
import cahier.de.charge.repository.RoleRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class RoleService {
    private final RoleRepository repo;
    public RoleService(RoleRepository repo) { this.repo = repo; }
    public Role save(Role e) { return repo.save(e); }
    public List<Role> findAll() { return repo.findAll(); }
    public Optional<Role> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
