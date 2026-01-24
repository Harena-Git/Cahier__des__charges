
package cahier.de.charge.service;

import cahier.de.charge.model.Departement;
import cahier.de.charge.repository.DepartementRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DepartementService {
    private final DepartementRepository repo;
    public DepartementService(DepartementRepository repo) { this.repo = repo; }
    public Departement save(Departement e) { return repo.save(e); }
    public List<Departement> findAll() { return repo.findAll(); }
    public Optional<Departement> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
