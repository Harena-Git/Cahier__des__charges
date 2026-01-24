
package cahier.de.charge.service;

import cahier.de.charge.model.FactureFournisseur;
import cahier.de.charge.repository.FactureFournisseurRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class FactureFournisseurService {
    private final FactureFournisseurRepository repo;
    public FactureFournisseurService(FactureFournisseurRepository repo) { this.repo = repo; }
    public FactureFournisseur save(FactureFournisseur e) { return repo.save(e); }
    public List<FactureFournisseur> findAll() { return repo.findAll(); }
    public Optional<FactureFournisseur> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
