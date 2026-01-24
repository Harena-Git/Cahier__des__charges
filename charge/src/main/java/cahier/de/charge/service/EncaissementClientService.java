
package cahier.de.charge.service;

import cahier.de.charge.model.EncaissementClient;
import cahier.de.charge.repository.EncaissementClientRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EncaissementClientService {
    private final EncaissementClientRepository repo;
    public EncaissementClientService(EncaissementClientRepository repo) { this.repo = repo; }
    public EncaissementClient save(EncaissementClient e) { return repo.save(e); }
    public List<EncaissementClient> findAll() { return repo.findAll(); }
    public Optional<EncaissementClient> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
