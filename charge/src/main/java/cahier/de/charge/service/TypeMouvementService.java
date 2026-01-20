
package cahier.de.charge.service;

import cahier.de.charge.model.TypeMouvement;
import cahier.de.charge.repository.TypeMouvementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeMouvementService {
    private final TypeMouvementRepository repository;

    public TypeMouvementService(TypeMouvementRepository repository) {
        this.repository = repository;
    }

    public TypeMouvement save(TypeMouvement e) { return repository.save(e); }
    public List<TypeMouvement> findAll() { return repository.findAll(); }
    public Optional<TypeMouvement> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
