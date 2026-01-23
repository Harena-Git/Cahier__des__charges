
package cahier.de.charge.service;

import cahier.de.charge.model.TauxChange;
import cahier.de.charge.repository.TauxChangeRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TauxChangeService {
    private final TauxChangeRepository repo;
    public TauxChangeService(TauxChangeRepository repo) { this.repo = repo; }
    public TauxChange save(TauxChange e) { return repo.save(e); }
    public List<TauxChange> findAll() { return repo.findAll(); }
    public Optional<TauxChange> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
