
package cahier.de.charge.service;

import cahier.de.charge.model.CategorieArticle;
import cahier.de.charge.repository.CategorieArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieArticleService {
    private final CategorieArticleRepository repository;

    public CategorieArticleService(CategorieArticleRepository repository) {
        this.repository = repository;
    }

    public CategorieArticle save(CategorieArticle e) { return repository.save(e); }
    public List<CategorieArticle> findAll() { return repository.findAll(); }
    public Optional<CategorieArticle> findById(Long id) { return repository.findById(id); }
    public void delete(Long id) { repository.deleteById(id); }
}
