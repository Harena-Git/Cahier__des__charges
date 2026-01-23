
package cahier.de.charge.service;

import cahier.de.charge.model.UniteMesure;
import cahier.de.charge.repository.UniteMesureRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UniteMesureService {
    private final UniteMesureRepository repo;
    public UniteMesureService(UniteMesureRepository repo) { this.repo = repo; }
    public UniteMesure save(UniteMesure e) { return repo.save(e); }
    public List<UniteMesure> findAll() { return repo.findAll(); }
    public Optional<UniteMesure> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
