
package cahier.de.charge.service;

import cahier.de.charge.model.DemandeAchat;
import cahier.de.charge.repository.DemandeAchatRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DemandeAchatService {
    private final DemandeAchatRepository repo;
    public DemandeAchatService(DemandeAchatRepository repo) { this.repo = repo; }
    public DemandeAchat save(DemandeAchat e) { return repo.save(e); }
    public List<DemandeAchat> findAll() { return repo.findAll(); }
    public Optional<DemandeAchat> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
