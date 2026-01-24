
package cahier.de.charge.controller;

import cahier.de.charge.model.LigneBonLivraison;
import cahier.de.charge.service.LigneBonLivraisonService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/lignebonlivraisons")
public class LigneBonLivraisonController {
    private final LigneBonLivraisonService service;
    public LigneBonLivraisonController(LigneBonLivraisonService service) { this.service = service; }

    @PostMapping
    public LigneBonLivraison create(@RequestBody LigneBonLivraison e) { return service.save(e); }

    @GetMapping
    public List<LigneBonLivraison> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public LigneBonLivraison get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public LigneBonLivraison update(@PathVariable Long id, @RequestBody LigneBonLivraison e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
