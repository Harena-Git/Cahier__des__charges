
package cahier.de.charge.service;

import cahier.de.charge.model.BonReception;
import cahier.de.charge.repository.BonReceptionRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BonReceptionService {
    private final BonReceptionRepository repo;
    public BonReceptionService(BonReceptionRepository repo) { this.repo = repo; }
    public BonReception save(BonReception e) { return repo.save(e); }
    public List<BonReception> findAll() { return repo.findAll(); }
    public Optional<BonReception> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
