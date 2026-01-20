
package cahier.de.charge.service;

import cahier.de.charge.model.Client;
import cahier.de.charge.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public Client save(Client e) { return repository.save(e); }
    public List<Client> findAll() { return repository.findAll(); }
    public Optional<Client> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
