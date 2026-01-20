
package cahier.de.charge.service;

import cahier.de.charge.model.Module;
import cahier.de.charge.repository.ModuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {
    private final ModuleRepository repository;

    public ModuleService(ModuleRepository repository) {
        this.repository = repository;
    }

    public Module save(Module e) { return repository.save(e); }
    public List<Module> findAll() { return repository.findAll(); }
    public Optional<Module> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
