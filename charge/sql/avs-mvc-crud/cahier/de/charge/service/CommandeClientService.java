
package cahier.de.charge.service;

import cahier.de.charge.model.CommandeClient;
import cahier.de.charge.repository.CommandeClientRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CommandeClientService {
    private final CommandeClientRepository repo;
    public CommandeClientService(CommandeClientRepository repo) { this.repo = repo; }
    public CommandeClient save(CommandeClient e) { return repo.save(e); }
    public List<CommandeClient> findAll() { return repo.findAll(); }
    public Optional<CommandeClient> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
