
package cahier.de.charge.service;

import cahier.de.charge.model.ModePaiement;
import cahier.de.charge.repository.ModePaiementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModePaiementService {
    private final ModePaiementRepository repository;

    public ModePaiementService(ModePaiementRepository repository) {
        this.repository = repository;
    }

    public ModePaiement save(ModePaiement e) { return repository.save(e); }
    public List<ModePaiement> findAll() { return repository.findAll(); }
    public Optional<ModePaiement> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
