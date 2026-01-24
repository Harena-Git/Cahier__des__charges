
package cahier.de.charge.controller;

import cahier.de.charge.model.Acompte;
import cahier.de.charge.service.AcompteService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/acomptes")
public class AcompteController {
    private final AcompteService service;
    public AcompteController(AcompteService service) { this.service = service; }

    @PostMapping
    public Acompte create(@RequestBody Acompte e) { return service.save(e); }

    @GetMapping
    public List<Acompte> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public Acompte get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public Acompte update(@PathVariable Long id, @RequestBody Acompte e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
