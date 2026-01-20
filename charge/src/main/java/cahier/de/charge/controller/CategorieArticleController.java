
package cahier.de.charge.controller;

import cahier.de.charge.model.CategorieArticle;
import cahier.de.charge.service.CategorieArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoriearticles")
public class CategorieArticleController {
    private final CategorieArticleService service;

    public CategorieArticleController(CategorieArticleService service) {
        this.service = service;
    }

    @PostMapping
    public CategorieArticle create(@RequestBody CategorieArticle e) { return service.save(e); }

    @GetMapping
    public List<CategorieArticle> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public CategorieArticle getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public CategorieArticle update(@PathVariable Long id, @RequestBody CategorieArticle e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
