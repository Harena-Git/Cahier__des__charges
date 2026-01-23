
package cahier.de.charge.controller;

import cahier.de.charge.model.LigneInventaire;
import cahier.de.charge.service.LigneInventaireService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/ligneinventaires")
public class LigneInventaireController {
    private final LigneInventaireService service;
    public LigneInventaireController(LigneInventaireService service) { this.service = service; }

    @PostMapping
    public LigneInventaire create(@RequestBody LigneInventaire e) { return service.save(e); }

    @GetMapping
    public List<LigneInventaire> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public LigneInventaire get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public LigneInventaire update(@PathVariable Long id, @RequestBody LigneInventaire e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
