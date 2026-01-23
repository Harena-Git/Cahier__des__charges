
package cahier.de.charge.controller;

import cahier.de.charge.model.BonLivraison;
import cahier.de.charge.service.BonLivraisonService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/bonlivraisons")
public class BonLivraisonController {
    private final BonLivraisonService service;
    public BonLivraisonController(BonLivraisonService service) { this.service = service; }

    @PostMapping
    public BonLivraison create(@RequestBody BonLivraison e) { return service.save(e); }

    @GetMapping
    public List<BonLivraison> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public BonLivraison get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public BonLivraison update(@PathVariable Long id, @RequestBody BonLivraison e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
