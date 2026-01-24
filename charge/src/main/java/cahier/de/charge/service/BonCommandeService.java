
package cahier.de.charge.service;

import cahier.de.charge.model.BonCommande;
import cahier.de.charge.repository.BonCommandeRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BonCommandeService {
    private final BonCommandeRepository repo;
    public BonCommandeService(BonCommandeRepository repo) { this.repo = repo; }
    public BonCommande save(BonCommande e) { return repo.save(e); }
    public List<BonCommande> findAll() { return repo.findAll(); }
    public Optional<BonCommande> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
