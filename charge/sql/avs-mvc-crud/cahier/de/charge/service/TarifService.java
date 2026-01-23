
package cahier.de.charge.service;

import cahier.de.charge.model.Tarif;
import cahier.de.charge.repository.TarifRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TarifService {
    private final TarifRepository repo;
    public TarifService(TarifRepository repo) { this.repo = repo; }
    public Tarif save(Tarif e) { return repo.save(e); }
    public List<Tarif> findAll() { return repo.findAll(); }
    public Optional<Tarif> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
