
package cahier.de.charge.controller;

import cahier.de.charge.model.DelegationTemporaire;
import cahier.de.charge.service.DelegationTemporaireService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/delegationtemporaires")
public class DelegationTemporaireController {
    private final DelegationTemporaireService service;
    public DelegationTemporaireController(DelegationTemporaireService service) { this.service = service; }

    @PostMapping
    public DelegationTemporaire create(@RequestBody DelegationTemporaire e) { return service.save(e); }

    @GetMapping
    public List<DelegationTemporaire> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public DelegationTemporaire get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public DelegationTemporaire update(@PathVariable Long id, @RequestBody DelegationTemporaire e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
