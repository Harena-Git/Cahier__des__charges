
package cahier.de.charge.controller;

import cahier.de.charge.model.Departement;
import cahier.de.charge.service.DepartementService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/departements")
public class DepartementController {
    private final DepartementService service;
    public DepartementController(DepartementService service) { this.service = service; }

    @PostMapping
    public Departement create(@RequestBody Departement e) { return service.save(e); }

    @GetMapping
    public List<Departement> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public Departement get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public Departement update(@PathVariable Long id, @RequestBody Departement e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
