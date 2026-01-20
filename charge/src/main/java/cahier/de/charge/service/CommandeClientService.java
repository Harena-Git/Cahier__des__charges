
package cahier.de.charge.service;

import cahier.de.charge.model.CommandeClient;
import cahier.de.charge.repository.CommandeClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeClientService {
    private final CommandeClientRepository repository;

    public CommandeClientService(CommandeClientRepository repository) {
        this.repository = repository;
    }

    public CommandeClient save(CommandeClient e) { return repository.save(e); }
    public List<CommandeClient> findAll() { return repository.findAll(); }
    public Optional<CommandeClient> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
