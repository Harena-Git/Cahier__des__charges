
package cahier.de.charge.service;

import cahier.de.charge.model.MethodeGestion;
import cahier.de.charge.repository.MethodeGestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MethodeGestionService {
    private final MethodeGestionRepository repository;

    public MethodeGestionService(MethodeGestionRepository repository) {
        this.repository = repository;
    }

    public MethodeGestion save(MethodeGestion e) { return repository.save(e); }
    public List<MethodeGestion> findAll() { return repository.findAll(); }
    public Optional<MethodeGestion> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
