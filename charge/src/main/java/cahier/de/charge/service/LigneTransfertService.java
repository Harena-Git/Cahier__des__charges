
package cahier.de.charge.service;

import cahier.de.charge.model.LigneTransfert;
import cahier.de.charge.repository.LigneTransfertRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class LigneTransfertService {
    private final LigneTransfertRepository repo;
    public LigneTransfertService(LigneTransfertRepository repo) { this.repo = repo; }
    public LigneTransfert save(LigneTransfert e) { return repo.save(e); }
    public List<LigneTransfert> findAll() { return repo.findAll(); }
    public Optional<LigneTransfert> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
