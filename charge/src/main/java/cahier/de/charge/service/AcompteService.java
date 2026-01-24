
package cahier.de.charge.service;

import cahier.de.charge.model.Acompte;
import cahier.de.charge.repository.AcompteRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AcompteService {
    private final AcompteRepository repo;
    public AcompteService(AcompteRepository repo) { this.repo = repo; }
    public Acompte save(Acompte e) { return repo.save(e); }
    public List<Acompte> findAll() { return repo.findAll(); }
    public Optional<Acompte> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
