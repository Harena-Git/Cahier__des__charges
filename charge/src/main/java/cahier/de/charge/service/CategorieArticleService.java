
package cahier.de.charge.service;

import cahier.de.charge.model.CategorieArticle;
import cahier.de.charge.repository.CategorieArticleRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CategorieArticleService {
    private final CategorieArticleRepository repo;
    public CategorieArticleService(CategorieArticleRepository repo) { this.repo = repo; }
    public CategorieArticle save(CategorieArticle e) { return repo.save(e); }
    public List<CategorieArticle> findAll() { return repo.findAll(); }
    public Optional<CategorieArticle> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
