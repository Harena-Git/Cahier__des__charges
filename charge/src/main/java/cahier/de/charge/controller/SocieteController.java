
package cahier.de.charge.controller;

import cahier.de.charge.model.Societe;
import cahier.de.charge.service.SocieteService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/societes")
public class SocieteController {
    private final SocieteService service;
    public SocieteController(SocieteService service) { this.service = service; }

    @PostMapping
    public Societe create(@RequestBody Societe e) { return service.save(e); }

    @GetMapping
    public List<Societe> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public Societe get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public Societe update(@PathVariable Long id, @RequestBody Societe e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
