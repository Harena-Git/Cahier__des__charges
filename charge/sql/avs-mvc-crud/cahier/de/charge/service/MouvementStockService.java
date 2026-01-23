
package cahier.de.charge.service;

import cahier.de.charge.model.MouvementStock;
import cahier.de.charge.repository.MouvementStockRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MouvementStockService {
    private final MouvementStockRepository repo;
    public MouvementStockService(MouvementStockRepository repo) { this.repo = repo; }
    public MouvementStock save(MouvementStock e) { return repo.save(e); }
    public List<MouvementStock> findAll() { return repo.findAll(); }
    public Optional<MouvementStock> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
