
package cahier.de.charge.service;

import cahier.de.charge.model.Depot;
import cahier.de.charge.repository.DepotRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DepotService {
    private final DepotRepository repo;
    public DepotService(DepotRepository repo) { this.repo = repo; }
    public Depot save(Depot e) { return repo.save(e); }
    public List<Depot> findAll() { return repo.findAll(); }
    public Optional<Depot> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
