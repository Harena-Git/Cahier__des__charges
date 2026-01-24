
package cahier.de.charge.service;

import cahier.de.charge.model.InventairePhysique;
import cahier.de.charge.repository.InventairePhysiqueRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class InventairePhysiqueService {
    private final InventairePhysiqueRepository repo;
    public InventairePhysiqueService(InventairePhysiqueRepository repo) { this.repo = repo; }
    public InventairePhysique save(InventairePhysique e) { return repo.save(e); }
    public List<InventairePhysique> findAll() { return repo.findAll(); }
    public Optional<InventairePhysique> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
