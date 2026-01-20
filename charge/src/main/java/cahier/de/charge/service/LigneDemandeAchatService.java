
package cahier.de.charge.service;

import cahier.de.charge.model.LigneDemandeAchat;
import cahier.de.charge.repository.LigneDemandeAchatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LigneDemandeAchatService {
    private final LigneDemandeAchatRepository repository;

    public LigneDemandeAchatService(LigneDemandeAchatRepository repository) {
        this.repository = repository;
    }

    public LigneDemandeAchat save(LigneDemandeAchat e) { return repository.save(e); }
    public List<LigneDemandeAchat> findAll() { return repository.findAll(); }
    public Optional<LigneDemandeAchat> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
