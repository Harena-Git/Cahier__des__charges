
package cahier.de.charge.service;

import cahier.de.charge.model.LigneBonReception;
import cahier.de.charge.repository.LigneBonReceptionRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class LigneBonReceptionService {
    private final LigneBonReceptionRepository repo;
    public LigneBonReceptionService(LigneBonReceptionRepository repo) { this.repo = repo; }
    public LigneBonReception save(LigneBonReception e) { return repo.save(e); }
    public List<LigneBonReception> findAll() { return repo.findAll(); }
    public Optional<LigneBonReception> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
