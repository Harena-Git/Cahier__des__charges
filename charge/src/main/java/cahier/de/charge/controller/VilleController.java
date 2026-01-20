
package cahier.de.charge.controller;

import cahier.de.charge.model.Ville;
import cahier.de.charge.service.VilleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/villes")
public class VilleController {
    private final VilleService service;

    public VilleController(VilleService service) {
        this.service = service;
    }

    @PostMapping
    public Ville create(@RequestBody Ville e) { return service.save(e); }

    @GetMapping
    public List<Ville> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public Ville getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public Ville update(@PathVariable Long id, @RequestBody Ville e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
