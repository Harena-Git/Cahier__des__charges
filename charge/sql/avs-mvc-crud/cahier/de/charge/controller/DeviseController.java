
package cahier.de.charge.controller;

import cahier.de.charge.model.Devise;
import cahier.de.charge.service.DeviseService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/devises")
public class DeviseController {
    private final DeviseService service;
    public DeviseController(DeviseService service) { this.service = service; }

    @PostMapping
    public Devise create(@RequestBody Devise e) { return service.save(e); }

    @GetMapping
    public List<Devise> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public Devise get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public Devise update(@PathVariable Long id, @RequestBody Devise e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
