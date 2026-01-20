
package cahier.de.charge.controller;

import cahier.de.charge.model.Lot;
import cahier.de.charge.service.LotService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lots")
public class LotController {
    private final LotService service;

    public LotController(LotService service) {
        this.service = service;
    }

    @PostMapping
    public Lot create(@RequestBody Lot e) { return service.save(e); }

    @GetMapping
    public List<Lot> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public Lot getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public Lot update(@PathVariable Long id, @RequestBody Lot e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
