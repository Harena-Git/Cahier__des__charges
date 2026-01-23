
package cahier.de.charge.service;

import cahier.de.charge.model.RegleRemise;
import cahier.de.charge.repository.RegleRemiseRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class RegleRemiseService {
    private final RegleRemiseRepository repo;
    public RegleRemiseService(RegleRemiseRepository repo) { this.repo = repo; }
    public RegleRemise save(RegleRemise e) { return repo.save(e); }
    public List<RegleRemise> findAll() { return repo.findAll(); }
    public Optional<RegleRemise> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
