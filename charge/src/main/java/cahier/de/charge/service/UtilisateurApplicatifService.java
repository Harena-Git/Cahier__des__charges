
package cahier.de.charge.service;

import cahier.de.charge.model.UtilisateurApplicatif;
import cahier.de.charge.repository.UtilisateurApplicatifRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurApplicatifService {
    private final UtilisateurApplicatifRepository repository;

    public UtilisateurApplicatifService(UtilisateurApplicatifRepository repository) {
        this.repository = repository;
    }

    public UtilisateurApplicatif save(UtilisateurApplicatif e) { return repository.save(e); }
    public List<UtilisateurApplicatif> findAll() { return repository.findAll(); }
    public Optional<UtilisateurApplicatif> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
