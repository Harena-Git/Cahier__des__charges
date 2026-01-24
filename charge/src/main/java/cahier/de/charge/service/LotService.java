
package cahier.de.charge.service;

import cahier.de.charge.model.Lot;
import cahier.de.charge.repository.LotRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class LotService {
    private final LotRepository repo;
    public LotService(LotRepository repo) { this.repo = repo; }
    public Lot save(Lot e) { return repo.save(e); }
    public List<Lot> findAll() { return repo.findAll(); }
    public Optional<Lot> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
