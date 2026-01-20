
package cahier.de.charge.service;

import cahier.de.charge.model.ProformaClient;
import cahier.de.charge.repository.ProformaClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProformaClientService {
    private final ProformaClientRepository repository;

    public ProformaClientService(ProformaClientRepository repository) {
        this.repository = repository;
    }

    public ProformaClient save(ProformaClient e) { return repository.save(e); }
    public List<ProformaClient> findAll() { return repository.findAll(); }
    public Optional<ProformaClient> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
