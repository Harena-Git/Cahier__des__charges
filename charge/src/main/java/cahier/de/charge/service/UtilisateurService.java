
package cahier.de.charge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cahier.de.charge.model.Utilisateur;
import cahier.de.charge.repository.UtilisateurRepository;

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

    public Utilisateur authenticate(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }
}
