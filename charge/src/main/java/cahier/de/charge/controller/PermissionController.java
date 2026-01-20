
package cahier.de.charge.controller;

import cahier.de.charge.model.Permission;
import cahier.de.charge.service.PermissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
public class PermissionController {
    private final PermissionService service;

    public PermissionController(PermissionService service) {
        this.service = service;
    }

    @PostMapping
    public Permission create(@RequestBody Permission e) { return service.save(e); }

    @GetMapping
    public List<Permission> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public Permission getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public Permission update(@PathVariable Long id, @RequestBody Permission e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
