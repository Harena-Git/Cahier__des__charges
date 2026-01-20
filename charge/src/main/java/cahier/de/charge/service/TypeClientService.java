
package cahier.de.charge.service;

import cahier.de.charge.model.TypeClient;
import cahier.de.charge.repository.TypeClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeClientService {
    private final TypeClientRepository repository;

    public TypeClientService(TypeClientRepository repository) {
        this.repository = repository;
    }

    public TypeClient save(TypeClient e) { return repository.save(e); }
    public List<TypeClient> findAll() { return repository.findAll(); }
    public Optional<TypeClient> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
