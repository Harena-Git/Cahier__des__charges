
package cahier.de.charge.controller;

import cahier.de.charge.model.BonReception;
import cahier.de.charge.service.BonReceptionService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/bonreceptions")
public class BonReceptionController {
    private final BonReceptionService service;
    public BonReceptionController(BonReceptionService service) { this.service = service; }

    @PostMapping
    public BonReception create(@RequestBody BonReception e) { return service.save(e); }

    @GetMapping
    public List<BonReception> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public BonReception get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public BonReception update(@PathVariable Long id, @RequestBody BonReception e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
