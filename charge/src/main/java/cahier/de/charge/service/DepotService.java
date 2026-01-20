
package cahier.de.charge.service;

import cahier.de.charge.model.Depot;
import cahier.de.charge.repository.DepotRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepotService {
    private final DepotRepository repository;

    public DepotService(DepotRepository repository) {
        this.repository = repository;
    }

    public Depot save(Depot e) { return repository.save(e); }
    public List<Depot> findAll() { return repository.findAll(); }
    public Optional<Depot> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
