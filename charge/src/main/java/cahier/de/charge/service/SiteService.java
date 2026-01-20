
package cahier.de.charge.service;

import cahier.de.charge.model.Site;
import cahier.de.charge.repository.SiteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiteService {
    private final SiteRepository repository;

    public SiteService(SiteRepository repository) {
        this.repository = repository;
    }

    public Site save(Site e) { return repository.save(e); }
    public List<Site> findAll() { return repository.findAll(); }
    public Optional<Site> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
