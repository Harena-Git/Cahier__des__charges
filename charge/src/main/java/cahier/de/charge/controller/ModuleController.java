
package cahier.de.charge.controller;

import cahier.de.charge.model.Module;
import cahier.de.charge.service.ModuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modules")
public class ModuleController {
    private final ModuleService service;

    public ModuleController(ModuleService service) {
        this.service = service;
    }

    @PostMapping
    public Module create(@RequestBody Module e) { return service.save(e); }

    @GetMapping
    public List<Module> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public Module getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public Module update(@PathVariable Long id, @RequestBody Module e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
