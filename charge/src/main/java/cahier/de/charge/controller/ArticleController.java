
package cahier.de.charge.controller;

import cahier.de.charge.model.Article;
import cahier.de.charge.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService service;

    public ArticleController(ArticleService service) {
        this.service = service;
    }

    @PostMapping
    public Article create(@RequestBody Article e) { return service.save(e); }

    @GetMapping
    public List<Article> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public Article getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public Article update(@PathVariable Long id, @RequestBody Article e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
