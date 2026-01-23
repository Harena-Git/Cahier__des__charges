
package cahier.de.charge.service;

import cahier.de.charge.model.Module;
import cahier.de.charge.repository.ModuleRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ModuleService {
    private final ModuleRepository repo;
    public ModuleService(ModuleRepository repo) { this.repo = repo; }
    public Module save(Module e) { return repo.save(e); }
    public List<Module> findAll() { return repo.findAll(); }
    public Optional<Module> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
