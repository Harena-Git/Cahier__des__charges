
package cahier.de.charge.controller;

import cahier.de.charge.model.Role;
import cahier.de.charge.service.RoleService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleService service;
    public RoleController(RoleService service) { this.service = service; }

    @PostMapping
    public Role create(@RequestBody Role e) { return service.save(e); }

    @GetMapping
    public List<Role> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public Role get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public Role update(@PathVariable Long id, @RequestBody Role e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
