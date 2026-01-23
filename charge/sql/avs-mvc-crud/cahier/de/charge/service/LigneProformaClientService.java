
package cahier.de.charge.service;

import cahier.de.charge.model.LigneProformaClient;
import cahier.de.charge.repository.LigneProformaClientRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class LigneProformaClientService {
    private final LigneProformaClientRepository repo;
    public LigneProformaClientService(LigneProformaClientRepository repo) { this.repo = repo; }
    public LigneProformaClient save(LigneProformaClient e) { return repo.save(e); }
    public List<LigneProformaClient> findAll() { return repo.findAll(); }
    public Optional<LigneProformaClient> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
