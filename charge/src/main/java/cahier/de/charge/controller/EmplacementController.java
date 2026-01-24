
package cahier.de.charge.controller;

import cahier.de.charge.model.Emplacement;
import cahier.de.charge.service.EmplacementService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/emplacements")
public class EmplacementController {
    private final EmplacementService service;
    public EmplacementController(EmplacementService service) { this.service = service; }

    @PostMapping
    public Emplacement create(@RequestBody Emplacement e) { return service.save(e); }

    @GetMapping
    public List<Emplacement> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public Emplacement get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public Emplacement update(@PathVariable Long id, @RequestBody Emplacement e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
