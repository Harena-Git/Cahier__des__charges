
package cahier.de.charge.service;

import cahier.de.charge.model.UtilisateurDepot;
import cahier.de.charge.repository.UtilisateurDepotRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurDepotService {
    private final UtilisateurDepotRepository repository;

    public UtilisateurDepotService(UtilisateurDepotRepository repository) {
        this.repository = repository;
    }

    public UtilisateurDepot save(UtilisateurDepot e) { return repository.save(e); }
    public List<UtilisateurDepot> findAll() { return repository.findAll(); }
    public Optional<UtilisateurDepot> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
