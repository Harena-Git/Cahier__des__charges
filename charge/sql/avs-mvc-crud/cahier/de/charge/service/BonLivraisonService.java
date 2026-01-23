
package cahier.de.charge.service;

import cahier.de.charge.model.BonLivraison;
import cahier.de.charge.repository.BonLivraisonRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BonLivraisonService {
    private final BonLivraisonRepository repo;
    public BonLivraisonService(BonLivraisonRepository repo) { this.repo = repo; }
    public BonLivraison save(BonLivraison e) { return repo.save(e); }
    public List<BonLivraison> findAll() { return repo.findAll(); }
    public Optional<BonLivraison> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
