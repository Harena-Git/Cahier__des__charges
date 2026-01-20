
package cahier.de.charge.service;

import cahier.de.charge.model.DelegationTemporaire;
import cahier.de.charge.repository.DelegationTemporaireRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DelegationTemporaireService {
    private final DelegationTemporaireRepository repository;

    public DelegationTemporaireService(DelegationTemporaireRepository repository) {
        this.repository = repository;
    }

    public DelegationTemporaire save(DelegationTemporaire e) { return repository.save(e); }
    public List<DelegationTemporaire> findAll() { return repository.findAll(); }
    public Optional<DelegationTemporaire> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
