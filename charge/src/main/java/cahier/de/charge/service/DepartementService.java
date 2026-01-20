
package cahier.de.charge.service;

import cahier.de.charge.model.Departement;
import cahier.de.charge.repository.DepartementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartementService {
    private final DepartementRepository repository;

    public DepartementService(DepartementRepository repository) {
        this.repository = repository;
    }

    public Departement save(Departement e) { return repository.save(e); }
    public List<Departement> findAll() { return repository.findAll(); }
    public Optional<Departement> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
