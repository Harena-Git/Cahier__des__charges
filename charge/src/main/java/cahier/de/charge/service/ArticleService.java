
package cahier.de.charge.service;

import cahier.de.charge.model.Article;
import cahier.de.charge.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository repository;

    public ArticleService(ArticleRepository repository) {
        this.repository = repository;
    }

    public Article save(Article e) { return repository.save(e); }
    public List<Article> findAll() { return repository.findAll(); }
    public Optional<Article> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
