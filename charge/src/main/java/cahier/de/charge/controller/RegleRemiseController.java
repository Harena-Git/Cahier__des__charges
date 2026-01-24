
package cahier.de.charge.controller;

import cahier.de.charge.model.RegleRemise;
import cahier.de.charge.service.RegleRemiseService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/regleremises")
public class RegleRemiseController {
    private final RegleRemiseService service;
    public RegleRemiseController(RegleRemiseService service) { this.service = service; }

    @PostMapping
    public RegleRemise create(@RequestBody RegleRemise e) { return service.save(e); }

    @GetMapping
    public List<RegleRemise> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public RegleRemise get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public RegleRemise update(@PathVariable Long id, @RequestBody RegleRemise e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
