
package cahier.de.charge.controller;

import cahier.de.charge.model.MouvementStock;
import cahier.de.charge.service.MouvementStockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mouvementstocks")
public class MouvementStockController {
    private final MouvementStockService service;

    public MouvementStockController(MouvementStockService service) {
        this.service = service;
    }

    @PostMapping
    public MouvementStock create(@RequestBody MouvementStock e) { return service.save(e); }

    @GetMapping
    public List<MouvementStock> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public MouvementStock getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public MouvementStock update(@PathVariable Long id, @RequestBody MouvementStock e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
