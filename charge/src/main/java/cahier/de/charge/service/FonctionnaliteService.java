
package cahier.de.charge.service;

import cahier.de.charge.model.Fonctionnalite;
import cahier.de.charge.repository.FonctionnaliteRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class FonctionnaliteService {
    private final FonctionnaliteRepository repo;
    public FonctionnaliteService(FonctionnaliteRepository repo) { this.repo = repo; }
    public Fonctionnalite save(Fonctionnalite e) { return repo.save(e); }
    public List<Fonctionnalite> findAll() { return repo.findAll(); }
    public Optional<Fonctionnalite> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
