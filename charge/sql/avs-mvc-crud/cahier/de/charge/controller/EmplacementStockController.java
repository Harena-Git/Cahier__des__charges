
package cahier.de.charge.controller;

import cahier.de.charge.model.EmplacementStock;
import cahier.de.charge.service.EmplacementStockService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/emplacementstocks")
public class EmplacementStockController {
    private final EmplacementStockService service;
    public EmplacementStockController(EmplacementStockService service) { this.service = service; }

    @PostMapping
    public EmplacementStock create(@RequestBody EmplacementStock e) { return service.save(e); }

    @GetMapping
    public List<EmplacementStock> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public EmplacementStock get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public EmplacementStock update(@PathVariable Long id, @RequestBody EmplacementStock e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
