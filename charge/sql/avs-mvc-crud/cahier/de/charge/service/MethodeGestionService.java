
package cahier.de.charge.service;

import cahier.de.charge.model.MethodeGestion;
import cahier.de.charge.repository.MethodeGestionRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MethodeGestionService {
    private final MethodeGestionRepository repo;
    public MethodeGestionService(MethodeGestionRepository repo) { this.repo = repo; }
    public MethodeGestion save(MethodeGestion e) { return repo.save(e); }
    public List<MethodeGestion> findAll() { return repo.findAll(); }
    public Optional<MethodeGestion> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
