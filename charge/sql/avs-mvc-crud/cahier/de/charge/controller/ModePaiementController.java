
package cahier.de.charge.controller;

import cahier.de.charge.model.ModePaiement;
import cahier.de.charge.service.ModePaiementService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/modepaiements")
public class ModePaiementController {
    private final ModePaiementService service;
    public ModePaiementController(ModePaiementService service) { this.service = service; }

    @PostMapping
    public ModePaiement create(@RequestBody ModePaiement e) { return service.save(e); }

    @GetMapping
    public List<ModePaiement> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public ModePaiement get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public ModePaiement update(@PathVariable Long id, @RequestBody ModePaiement e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
