
package cahier.de.charge.controller;

import cahier.de.charge.model.Fonctionnalite;
import cahier.de.charge.service.FonctionnaliteService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/fonctionnalites")
public class FonctionnaliteController {
    private final FonctionnaliteService service;
    public FonctionnaliteController(FonctionnaliteService service) { this.service = service; }

    @PostMapping
    public Fonctionnalite create(@RequestBody Fonctionnalite e) { return service.save(e); }

    @GetMapping
    public List<Fonctionnalite> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public Fonctionnalite get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public Fonctionnalite update(@PathVariable Long id, @RequestBody Fonctionnalite e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
