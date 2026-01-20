
package cahier.de.charge.service;

import cahier.de.charge.model.Utilisateur;
import cahier.de.charge.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {
    private final UtilisateurRepository repository;

    public UtilisateurService(UtilisateurRepository repository) {
        this.repository = repository;
    }

    public Utilisateur save(Utilisateur e) { return repository.save(e); }
    public List<Utilisateur> findAll() { return repository.findAll(); }
    public Optional<Utilisateur> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
