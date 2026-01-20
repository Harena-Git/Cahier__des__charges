
package cahier.de.charge.service;

import cahier.de.charge.model.MouvementStock;
import cahier.de.charge.repository.MouvementStockRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MouvementStockService {
    private final MouvementStockRepository repository;

    public MouvementStockService(MouvementStockRepository repository) {
        this.repository = repository;
    }

    public MouvementStock save(MouvementStock e) { return repository.save(e); }
    public List<MouvementStock> findAll() { return repository.findAll(); }
    public Optional<MouvementStock> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
