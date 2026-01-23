
package cahier.de.charge.service;

import cahier.de.charge.model.Article;
import cahier.de.charge.repository.ArticleRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ArticleService {
    private final ArticleRepository repo;
    public ArticleService(ArticleRepository repo) { this.repo = repo; }
    public Article save(Article e) { return repo.save(e); }
    public List<Article> findAll() { return repo.findAll(); }
    public Optional<Article> findById(Long id) { return repo.findById(id); }
    public void delete(Long id) { repo.deleteById(id); }
}
