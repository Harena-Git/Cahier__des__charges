
package cahier.de.charge.service;

import cahier.de.charge.model.Utilisateur;
import cahier.de.charge.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UtilisateurService {
    private final UtilisateurRepository repo;
    public UtilisateurService(UtilisateurRepository repo) { this.repo = repo; }
    public Utilisateur save(Utilisateur e) { return repo.save(e); }
    public List<Utilisateur> findAll() { return repo.findAll(); }
    public Optional<Utilisateur> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
