
package cahier.de.charge.service;

import cahier.de.charge.model.Fournisseur;
import cahier.de.charge.repository.FournisseurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FournisseurService {
    private final FournisseurRepository repository;

    public FournisseurService(FournisseurRepository repository) {
        this.repository = repository;
    }

    public Fournisseur save(Fournisseur e) { return repository.save(e); }
    public List<Fournisseur> findAll() { return repository.findAll(); }
    public Optional<Fournisseur> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
