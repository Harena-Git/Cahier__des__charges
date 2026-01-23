
package cahier.de.charge.service;

import cahier.de.charge.model.LigneProformaFournisseur;
import cahier.de.charge.repository.LigneProformaFournisseurRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class LigneProformaFournisseurService {
    private final LigneProformaFournisseurRepository repo;
    public LigneProformaFournisseurService(LigneProformaFournisseurRepository repo) { this.repo = repo; }
    public LigneProformaFournisseur save(LigneProformaFournisseur e) { return repo.save(e); }
    public List<LigneProformaFournisseur> findAll() { return repo.findAll(); }
    public Optional<LigneProformaFournisseur> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
