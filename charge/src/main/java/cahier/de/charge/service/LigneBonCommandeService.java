
package cahier.de.charge.service;

import cahier.de.charge.model.LigneBonCommande;
import cahier.de.charge.repository.LigneBonCommandeRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class LigneBonCommandeService {
    private final LigneBonCommandeRepository repo;
    public LigneBonCommandeService(LigneBonCommandeRepository repo) { this.repo = repo; }
    public LigneBonCommande save(LigneBonCommande e) { return repo.save(e); }
    public List<LigneBonCommande> findAll() { return repo.findAll(); }
    public Optional<LigneBonCommande> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
