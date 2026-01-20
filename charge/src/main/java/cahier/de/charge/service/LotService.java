
package cahier.de.charge.service;

import cahier.de.charge.model.Lot;
import cahier.de.charge.repository.LotRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LotService {
    private final LotRepository repository;

    public LotService(LotRepository repository) {
        this.repository = repository;
    }

    public Lot save(Lot e) { return repository.save(e); }
    public List<Lot> findAll() { return repository.findAll(); }
    public Optional<Lot> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
