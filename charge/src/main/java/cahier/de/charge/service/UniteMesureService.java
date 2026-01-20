
package cahier.de.charge.service;

import cahier.de.charge.model.UniteMesure;
import cahier.de.charge.repository.UniteMesureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniteMesureService {
    private final UniteMesureRepository repository;

    public UniteMesureService(UniteMesureRepository repository) {
        this.repository = repository;
    }

    public UniteMesure save(UniteMesure e) { return repository.save(e); }
    public List<UniteMesure> findAll() { return repository.findAll(); }
    public Optional<UniteMesure> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
