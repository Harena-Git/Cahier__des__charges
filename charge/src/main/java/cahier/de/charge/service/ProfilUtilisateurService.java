
package cahier.de.charge.service;

import cahier.de.charge.model.ProfilUtilisateur;
import cahier.de.charge.repository.ProfilUtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfilUtilisateurService {
    private final ProfilUtilisateurRepository repository;

    public ProfilUtilisateurService(ProfilUtilisateurRepository repository) {
        this.repository = repository;
    }

    public ProfilUtilisateur save(ProfilUtilisateur e) { return repository.save(e); }
    public List<ProfilUtilisateur> findAll() { return repository.findAll(); }
    public Optional<ProfilUtilisateur> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
