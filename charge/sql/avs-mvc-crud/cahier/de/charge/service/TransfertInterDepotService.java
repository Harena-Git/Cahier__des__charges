
package cahier.de.charge.service;

import cahier.de.charge.model.TransfertInterDepot;
import cahier.de.charge.repository.TransfertInterDepotRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TransfertInterDepotService {
    private final TransfertInterDepotRepository repo;
    public TransfertInterDepotService(TransfertInterDepotRepository repo) { this.repo = repo; }
    public TransfertInterDepot save(TransfertInterDepot e) { return repo.save(e); }
    public List<TransfertInterDepot> findAll() { return repo.findAll(); }
    public Optional<TransfertInterDepot> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
