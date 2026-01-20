
package cahier.de.charge.controller;

import cahier.de.charge.model.Depot;
import cahier.de.charge.service.DepotService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depots")
public class DepotController {
    private final DepotService service;

    public DepotController(DepotService service) {
        this.service = service;
    }

    @PostMapping
    public Depot create(@RequestBody Depot e) { return service.save(e); }

    @GetMapping
    public List<Depot> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public Depot getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public Depot update(@PathVariable Long id, @RequestBody Depot e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
