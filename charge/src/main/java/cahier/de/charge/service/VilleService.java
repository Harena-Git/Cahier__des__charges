
package cahier.de.charge.service;

import cahier.de.charge.model.Ville;
import cahier.de.charge.repository.VilleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VilleService {
    private final VilleRepository repository;

    public VilleService(VilleRepository repository) {
        this.repository = repository;
    }

    public Ville save(Ville e) { return repository.save(e); }
    public List<Ville> findAll() { return repository.findAll(); }
    public Optional<Ville> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
