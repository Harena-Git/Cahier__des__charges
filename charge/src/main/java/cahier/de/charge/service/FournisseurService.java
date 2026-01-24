
package cahier.de.charge.service;

import cahier.de.charge.model.Fournisseur;
import cahier.de.charge.repository.FournisseurRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class FournisseurService {
    private final FournisseurRepository repo;
    public FournisseurService(FournisseurRepository repo) { this.repo = repo; }
    public Fournisseur save(Fournisseur e) { return repo.save(e); }
    public List<Fournisseur> findAll() { return repo.findAll(); }
    public Optional<Fournisseur> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
