
package cahier.de.charge.service;

import cahier.de.charge.model.TypeMouvement;
import cahier.de.charge.repository.TypeMouvementRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TypeMouvementService {
    private final TypeMouvementRepository repo;
    public TypeMouvementService(TypeMouvementRepository repo) { this.repo = repo; }
    public TypeMouvement save(TypeMouvement e) { return repo.save(e); }
    public List<TypeMouvement> findAll() { return repo.findAll(); }
    public Optional<TypeMouvement> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
