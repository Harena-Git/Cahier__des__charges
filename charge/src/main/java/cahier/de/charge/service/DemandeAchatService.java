
package cahier.de.charge.service;

import cahier.de.charge.model.DemandeAchat;
import cahier.de.charge.repository.DemandeAchatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeAchatService {
    private final DemandeAchatRepository repository;

    public DemandeAchatService(DemandeAchatRepository repository) {
        this.repository = repository;
    }

    public DemandeAchat save(DemandeAchat e) { return repository.save(e); }
    public List<DemandeAchat> findAll() { return repository.findAll(); }
    public Optional<DemandeAchat> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
