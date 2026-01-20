
package cahier.de.charge.service;

import cahier.de.charge.model.FactureClient;
import cahier.de.charge.repository.FactureClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FactureClientService {
    private final FactureClientRepository repository;

    public FactureClientService(FactureClientRepository repository) {
        this.repository = repository;
    }

    public FactureClient save(FactureClient e) { return repository.save(e); }
    public List<FactureClient> findAll() { return repository.findAll(); }
    public Optional<FactureClient> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
