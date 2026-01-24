
package cahier.de.charge.controller;

import cahier.de.charge.model.LigneBonCommande;
import cahier.de.charge.service.LigneBonCommandeService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/ligneboncommandes")
public class LigneBonCommandeController {
    private final LigneBonCommandeService service;
    public LigneBonCommandeController(LigneBonCommandeService service) { this.service = service; }

    @PostMapping
    public LigneBonCommande create(@RequestBody LigneBonCommande e) { return service.save(e); }

    @GetMapping
    public List<LigneBonCommande> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public LigneBonCommande get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public LigneBonCommande update(@PathVariable Long id, @RequestBody LigneBonCommande e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
