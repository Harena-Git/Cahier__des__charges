
package cahier.de.charge.service;

import cahier.de.charge.model.AjustementStock;
import cahier.de.charge.repository.AjustementStockRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AjustementStockService {
    private final AjustementStockRepository repo;
    public AjustementStockService(AjustementStockRepository repo) { this.repo = repo; }
    public AjustementStock save(AjustementStock e) { return repo.save(e); }
    public List<AjustementStock> findAll() { return repo.findAll(); }
    public Optional<AjustementStock> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
