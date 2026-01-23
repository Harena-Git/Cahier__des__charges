
package cahier.de.charge.service;

import cahier.de.charge.model.ProformaFournisseur;
import cahier.de.charge.repository.ProformaFournisseurRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProformaFournisseurService {
    private final ProformaFournisseurRepository repo;
    public ProformaFournisseurService(ProformaFournisseurRepository repo) { this.repo = repo; }
    public ProformaFournisseur save(ProformaFournisseur e) { return repo.save(e); }
    public List<ProformaFournisseur> findAll() { return repo.findAll(); }
    public Optional<ProformaFournisseur> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
