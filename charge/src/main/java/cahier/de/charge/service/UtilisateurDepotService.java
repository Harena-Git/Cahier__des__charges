
package cahier.de.charge.service;

import cahier.de.charge.model.UtilisateurDepot;
import cahier.de.charge.repository.UtilisateurDepotRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UtilisateurDepotService {
    private final UtilisateurDepotRepository repo;
    public UtilisateurDepotService(UtilisateurDepotRepository repo) { this.repo = repo; }
    public UtilisateurDepot save(UtilisateurDepot e) { return repo.save(e); }
    public List<UtilisateurDepot> findAll() { return repo.findAll(); }
    public Optional<UtilisateurDepot> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
