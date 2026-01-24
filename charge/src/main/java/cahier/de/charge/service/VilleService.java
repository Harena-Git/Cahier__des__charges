
package cahier.de.charge.service;

import cahier.de.charge.model.Ville;
import cahier.de.charge.repository.VilleRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class VilleService {
    private final VilleRepository repo;
    public VilleService(VilleRepository repo) { this.repo = repo; }
    public Ville save(Ville e) { return repo.save(e); }
    public List<Ville> findAll() { return repo.findAll(); }
    public Optional<Ville> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
