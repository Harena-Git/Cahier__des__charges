
package cahier.de.charge.service;

import cahier.de.charge.model.LigneBonLivraison;
import cahier.de.charge.repository.LigneBonLivraisonRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class LigneBonLivraisonService {
    private final LigneBonLivraisonRepository repo;
    public LigneBonLivraisonService(LigneBonLivraisonRepository repo) { this.repo = repo; }
    public LigneBonLivraison save(LigneBonLivraison e) { return repo.save(e); }
    public List<LigneBonLivraison> findAll() { return repo.findAll(); }
    public Optional<LigneBonLivraison> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
