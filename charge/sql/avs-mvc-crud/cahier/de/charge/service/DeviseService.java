
package cahier.de.charge.service;

import cahier.de.charge.model.Devise;
import cahier.de.charge.repository.DeviseRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DeviseService {
    private final DeviseRepository repo;
    public DeviseService(DeviseRepository repo) { this.repo = repo; }
    public Devise save(Devise e) { return repo.save(e); }
    public List<Devise> findAll() { return repo.findAll(); }
    public Optional<Devise> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
