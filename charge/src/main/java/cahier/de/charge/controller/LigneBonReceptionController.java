
package cahier.de.charge.controller;

import cahier.de.charge.model.LigneBonReception;
import cahier.de.charge.service.LigneBonReceptionService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/lignebonreceptions")
public class LigneBonReceptionController {
    private final LigneBonReceptionService service;
    public LigneBonReceptionController(LigneBonReceptionService service) { this.service = service; }

    @PostMapping
    public LigneBonReception create(@RequestBody LigneBonReception e) { return service.save(e); }

    @GetMapping
    public List<LigneBonReception> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public LigneBonReception get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public LigneBonReception update(@PathVariable Long id, @RequestBody LigneBonReception e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
