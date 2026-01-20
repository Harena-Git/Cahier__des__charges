
package cahier.de.charge.service;

import cahier.de.charge.model.EncaissementClient;
import cahier.de.charge.repository.EncaissementClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EncaissementClientService {
    private final EncaissementClientRepository repository;

    public EncaissementClientService(EncaissementClientRepository repository) {
        this.repository = repository;
    }

    public EncaissementClient save(EncaissementClient e) { return repository.save(e); }
    public List<EncaissementClient> findAll() { return repository.findAll(); }
    public Optional<EncaissementClient> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
