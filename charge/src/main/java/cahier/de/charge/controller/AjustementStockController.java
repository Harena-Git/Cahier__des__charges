
package cahier.de.charge.controller;

import cahier.de.charge.model.AjustementStock;
import cahier.de.charge.service.AjustementStockService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/ajustementstocks")
public class AjustementStockController {
    private final AjustementStockService service;
    public AjustementStockController(AjustementStockService service) { this.service = service; }

    @PostMapping
    public AjustementStock create(@RequestBody AjustementStock e) { return service.save(e); }

    @GetMapping
    public List<AjustementStock> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public AjustementStock get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public AjustementStock update(@PathVariable Long id, @RequestBody AjustementStock e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
