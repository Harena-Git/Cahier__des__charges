
package cahier.de.charge.controller;

import cahier.de.charge.model.RolePermission;
import cahier.de.charge.service.RolePermissionService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/rolepermissions")
public class RolePermissionController {
    private final RolePermissionService service;
    public RolePermissionController(RolePermissionService service) { this.service = service; }

    @PostMapping
    public RolePermission create(@RequestBody RolePermission e) { return service.save(e); }

    @GetMapping
    public List<RolePermission> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public RolePermission get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public RolePermission update(@PathVariable Long id, @RequestBody RolePermission e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
