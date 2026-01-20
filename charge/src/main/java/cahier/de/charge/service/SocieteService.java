
package cahier.de.charge.service;

import cahier.de.charge.model.Societe;
import cahier.de.charge.repository.SocieteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocieteService {
    private final SocieteRepository repository;

    public SocieteService(SocieteRepository repository) {
        this.repository = repository;
    }

    public Societe save(Societe e) { return repository.save(e); }
    public List<Societe> findAll() { return repository.findAll(); }
    public Optional<Societe> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
