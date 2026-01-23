
package cahier.de.charge.controller;

import cahier.de.charge.model.BonCommande;
import cahier.de.charge.service.BonCommandeService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/boncommandes")
public class BonCommandeController {
    private final BonCommandeService service;
    public BonCommandeController(BonCommandeService service) { this.service = service; }

    @PostMapping
    public BonCommande create(@RequestBody BonCommande e) { return service.save(e); }

    @GetMapping
    public List<BonCommande> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public BonCommande get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public BonCommande update(@PathVariable Long id, @RequestBody BonCommande e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
