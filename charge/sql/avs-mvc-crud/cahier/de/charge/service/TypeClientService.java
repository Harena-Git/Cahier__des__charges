
package cahier.de.charge.service;

import cahier.de.charge.model.TypeClient;
import cahier.de.charge.repository.TypeClientRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TypeClientService {
    private final TypeClientRepository repo;
    public TypeClientService(TypeClientRepository repo) { this.repo = repo; }
    public TypeClient save(TypeClient e) { return repo.save(e); }
    public List<TypeClient> findAll() { return repo.findAll(); }
    public Optional<TypeClient> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
