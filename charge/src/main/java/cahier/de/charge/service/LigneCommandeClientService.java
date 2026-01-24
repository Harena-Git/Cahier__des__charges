
package cahier.de.charge.service;

import cahier.de.charge.model.LigneCommandeClient;
import cahier.de.charge.repository.LigneCommandeClientRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class LigneCommandeClientService {
    private final LigneCommandeClientRepository repo;
    public LigneCommandeClientService(LigneCommandeClientRepository repo) { this.repo = repo; }
    public LigneCommandeClient save(LigneCommandeClient e) { return repo.save(e); }
    public List<LigneCommandeClient> findAll() { return repo.findAll(); }
    public Optional<LigneCommandeClient> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
