
package cahier.de.charge.service;

import cahier.de.charge.model.Fonctionnalite;
import cahier.de.charge.repository.FonctionnaliteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FonctionnaliteService {
    private final FonctionnaliteRepository repository;

    public FonctionnaliteService(FonctionnaliteRepository repository) {
        this.repository = repository;
    }

    public Fonctionnalite save(Fonctionnalite e) { return repository.save(e); }
    public List<Fonctionnalite> findAll() { return repository.findAll(); }
    public Optional<Fonctionnalite> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
