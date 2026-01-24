
package cahier.de.charge.controller;

import cahier.de.charge.model.Tarif;
import cahier.de.charge.service.TarifService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/tarifs")
public class TarifController {
    private final TarifService service;
    public TarifController(TarifService service) { this.service = service; }

    @PostMapping
    public Tarif create(@RequestBody Tarif e) { return service.save(e); }

    @GetMapping
    public List<Tarif> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public Tarif get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public Tarif update(@PathVariable Long id, @RequestBody Tarif e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
