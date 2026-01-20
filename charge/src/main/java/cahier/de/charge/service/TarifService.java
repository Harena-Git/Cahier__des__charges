
package cahier.de.charge.service;

import cahier.de.charge.model.Tarif;
import cahier.de.charge.repository.TarifRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarifService {
    private final TarifRepository repository;

    public TarifService(TarifRepository repository) {
        this.repository = repository;
    }

    public Tarif save(Tarif e) { return repository.save(e); }
    public List<Tarif> findAll() { return repository.findAll(); }
    public Optional<Tarif> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
