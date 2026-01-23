
package cahier.de.charge.service;

import cahier.de.charge.model.ProformaClient;
import cahier.de.charge.repository.ProformaClientRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProformaClientService {
    private final ProformaClientRepository repo;
    public ProformaClientService(ProformaClientRepository repo) { this.repo = repo; }
    public ProformaClient save(ProformaClient e) { return repo.save(e); }
    public List<ProformaClient> findAll() { return repo.findAll(); }
    public Optional<ProformaClient> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
