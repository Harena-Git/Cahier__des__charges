
package cahier.de.charge.service;

import cahier.de.charge.model.PaiementFournisseur;
import cahier.de.charge.repository.PaiementFournisseurRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PaiementFournisseurService {
    private final PaiementFournisseurRepository repo;
    public PaiementFournisseurService(PaiementFournisseurRepository repo) { this.repo = repo; }
    public PaiementFournisseur save(PaiementFournisseur e) { return repo.save(e); }
    public List<PaiementFournisseur> findAll() { return repo.findAll(); }
    public Optional<PaiementFournisseur> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
