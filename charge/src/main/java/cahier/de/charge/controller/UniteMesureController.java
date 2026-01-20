
package cahier.de.charge.controller;

import cahier.de.charge.model.UniteMesure;
import cahier.de.charge.service.UniteMesureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unitemesures")
public class UniteMesureController {
    private final UniteMesureService service;

    public UniteMesureController(UniteMesureService service) {
        this.service = service;
    }

    @PostMapping
    public UniteMesure create(@RequestBody UniteMesure e) { return service.save(e); }

    @GetMapping
    public List<UniteMesure> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public UniteMesure getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public UniteMesure update(@PathVariable Long id, @RequestBody UniteMesure e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
