
package cahier.de.charge.service;

import cahier.de.charge.model.Societe;
import cahier.de.charge.repository.SocieteRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SocieteService {
    private final SocieteRepository repo;
    public SocieteService(SocieteRepository repo) { this.repo = repo; }
    public Societe save(Societe e) { return repo.save(e); }
    public List<Societe> findAll() { return repo.findAll(); }
    public Optional<Societe> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
