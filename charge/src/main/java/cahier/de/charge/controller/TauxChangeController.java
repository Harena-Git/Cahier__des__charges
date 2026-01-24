
package cahier.de.charge.controller;

import cahier.de.charge.model.TauxChange;
import cahier.de.charge.service.TauxChangeService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/tauxchanges")
public class TauxChangeController {
    private final TauxChangeService service;
    public TauxChangeController(TauxChangeService service) { this.service = service; }

    @PostMapping
    public TauxChange create(@RequestBody TauxChange e) { return service.save(e); }

    @GetMapping
    public List<TauxChange> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public TauxChange get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public TauxChange update(@PathVariable Long id, @RequestBody TauxChange e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
