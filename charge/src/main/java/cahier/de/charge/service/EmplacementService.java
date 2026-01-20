
package cahier.de.charge.service;

import cahier.de.charge.model.Emplacement;
import cahier.de.charge.repository.EmplacementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmplacementService {
    private final EmplacementRepository repository;

    public EmplacementService(EmplacementRepository repository) {
        this.repository = repository;
    }

    public Emplacement save(Emplacement e) { return repository.save(e); }
    public List<Emplacement> findAll() { return repository.findAll(); }
    public Optional<Emplacement> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
