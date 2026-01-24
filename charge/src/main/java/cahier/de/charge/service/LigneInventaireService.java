
package cahier.de.charge.service;

import cahier.de.charge.model.LigneInventaire;
import cahier.de.charge.repository.LigneInventaireRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class LigneInventaireService {
    private final LigneInventaireRepository repo;
    public LigneInventaireService(LigneInventaireRepository repo) { this.repo = repo; }
    public LigneInventaire save(LigneInventaire e) { return repo.save(e); }
    public List<LigneInventaire> findAll() { return repo.findAll(); }
    public Optional<LigneInventaire> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
