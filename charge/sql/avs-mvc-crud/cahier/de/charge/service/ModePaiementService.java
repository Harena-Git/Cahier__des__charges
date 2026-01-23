
package cahier.de.charge.service;

import cahier.de.charge.model.ModePaiement;
import cahier.de.charge.repository.ModePaiementRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ModePaiementService {
    private final ModePaiementRepository repo;
    public ModePaiementService(ModePaiementRepository repo) { this.repo = repo; }
    public ModePaiement save(ModePaiement e) { return repo.save(e); }
    public List<ModePaiement> findAll() { return repo.findAll(); }
    public Optional<ModePaiement> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
