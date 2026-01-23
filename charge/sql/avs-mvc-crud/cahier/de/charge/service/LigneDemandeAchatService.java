
package cahier.de.charge.service;

import cahier.de.charge.model.LigneDemandeAchat;
import cahier.de.charge.repository.LigneDemandeAchatRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class LigneDemandeAchatService {
    private final LigneDemandeAchatRepository repo;
    public LigneDemandeAchatService(LigneDemandeAchatRepository repo) { this.repo = repo; }
    public LigneDemandeAchat save(LigneDemandeAchat e) { return repo.save(e); }
    public List<LigneDemandeAchat> findAll() { return repo.findAll(); }
    public Optional<LigneDemandeAchat> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
