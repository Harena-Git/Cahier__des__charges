
package cahier.de.charge.controller;

import cahier.de.charge.model.MethodeGestion;
import cahier.de.charge.service.MethodeGestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/methodegestions")
public class MethodeGestionController {
    private final MethodeGestionService service;

    public MethodeGestionController(MethodeGestionService service) {
        this.service = service;
    }

    @PostMapping
    public MethodeGestion create(@RequestBody MethodeGestion e) { return service.save(e); }

    @GetMapping
    public List<MethodeGestion> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public MethodeGestion getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public MethodeGestion update(@PathVariable Long id, @RequestBody MethodeGestion e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
