
package cahier.de.charge.service;

import cahier.de.charge.model.Role;
import cahier.de.charge.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public Role save(Role e) { return repository.save(e); }
    public List<Role> findAll() { return repository.findAll(); }
    public Optional<Role> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
