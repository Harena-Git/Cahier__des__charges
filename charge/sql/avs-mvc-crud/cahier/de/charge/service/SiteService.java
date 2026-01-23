
package cahier.de.charge.service;

import cahier.de.charge.model.Site;
import cahier.de.charge.repository.SiteRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SiteService {
    private final SiteRepository repo;
    public SiteService(SiteRepository repo) { this.repo = repo; }
    public Site save(Site e) { return repo.save(e); }
    public List<Site> findAll() { return repo.findAll(); }
    public Optional<Site> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
