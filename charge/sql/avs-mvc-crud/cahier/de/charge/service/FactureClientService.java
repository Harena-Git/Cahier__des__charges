
package cahier.de.charge.service;

import cahier.de.charge.model.FactureClient;
import cahier.de.charge.repository.FactureClientRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class FactureClientService {
    private final FactureClientRepository repo;
    public FactureClientService(FactureClientRepository repo) { this.repo = repo; }
    public FactureClient save(FactureClient e) { return repo.save(e); }
    public List<FactureClient> findAll() { return repo.findAll(); }
    public Optional<FactureClient> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
