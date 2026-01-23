
package cahier.de.charge.service;

import cahier.de.charge.model.DelegationTemporaire;
import cahier.de.charge.repository.DelegationTemporaireRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DelegationTemporaireService {
    private final DelegationTemporaireRepository repo;
    public DelegationTemporaireService(DelegationTemporaireRepository repo) { this.repo = repo; }
    public DelegationTemporaire save(DelegationTemporaire e) { return repo.save(e); }
    public List<DelegationTemporaire> findAll() { return repo.findAll(); }
    public Optional<DelegationTemporaire> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
