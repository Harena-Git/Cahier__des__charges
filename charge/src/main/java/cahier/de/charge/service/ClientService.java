
package cahier.de.charge.service;

import cahier.de.charge.model.Client;
import cahier.de.charge.repository.ClientRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ClientService {
    private final ClientRepository repo;
    public ClientService(ClientRepository repo) { this.repo = repo; }
    public Client save(Client e) { return repo.save(e); }
    public List<Client> findAll() { return repo.findAll(); }
    public Optional<Client> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
