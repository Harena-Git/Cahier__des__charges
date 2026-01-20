
package cahier.de.charge.service;

import cahier.de.charge.model.Devise;
import cahier.de.charge.repository.DeviseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviseService {
    private final DeviseRepository repository;

    public DeviseService(DeviseRepository repository) {
        this.repository = repository;
    }

    public Devise save(Devise e) { return repository.save(e); }
    public List<Devise> findAll() { return repository.findAll(); }
    public Optional<Devise> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
