
package cahier.de.charge.service;

import cahier.de.charge.model.EmplacementStock;
import cahier.de.charge.repository.EmplacementStockRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EmplacementStockService {
    private final EmplacementStockRepository repo;
    public EmplacementStockService(EmplacementStockRepository repo) { this.repo = repo; }
    public EmplacementStock save(EmplacementStock e) { return repo.save(e); }
    public List<EmplacementStock> findAll() { return repo.findAll(); }
    public Optional<EmplacementStock> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
