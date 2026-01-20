
package cahier.de.charge.controller;

import cahier.de.charge.model.Site;
import cahier.de.charge.service.SiteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sites")
public class SiteController {
    private final SiteService service;

    public SiteController(SiteService service) {
        this.service = service;
    }

    @PostMapping
    public Site create(@RequestBody Site e) { return service.save(e); }

    @GetMapping
    public List<Site> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public Site getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public Site update(@PathVariable Long id, @RequestBody Site e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
