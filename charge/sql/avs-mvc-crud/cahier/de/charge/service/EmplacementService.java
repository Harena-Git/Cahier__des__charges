
package cahier.de.charge.service;

import cahier.de.charge.model.Emplacement;
import cahier.de.charge.repository.EmplacementRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EmplacementService {
    private final EmplacementRepository repo;
    public EmplacementService(EmplacementRepository repo) { this.repo = repo; }
    public Emplacement save(Emplacement e) { return repo.save(e); }
    public List<Emplacement> findAll() { return repo.findAll(); }
    public Optional<Emplacement> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
