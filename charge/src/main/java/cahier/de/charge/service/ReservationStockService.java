
package cahier.de.charge.service;

import cahier.de.charge.model.ReservationStock;
import cahier.de.charge.repository.ReservationStockRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ReservationStockService {
    private final ReservationStockRepository repo;
    public ReservationStockService(ReservationStockRepository repo) { this.repo = repo; }
    public ReservationStock save(ReservationStock e) { return repo.save(e); }
    public List<ReservationStock> findAll() { return repo.findAll(); }
    public Optional<ReservationStock> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
