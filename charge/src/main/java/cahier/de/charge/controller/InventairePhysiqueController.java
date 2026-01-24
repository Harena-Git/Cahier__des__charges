
package cahier.de.charge.controller;

import cahier.de.charge.model.InventairePhysique;
import cahier.de.charge.service.InventairePhysiqueService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/inventairephysiques")
public class InventairePhysiqueController {
    private final InventairePhysiqueService service;
    public InventairePhysiqueController(InventairePhysiqueService service) { this.service = service; }

    @PostMapping
    public InventairePhysique create(@RequestBody InventairePhysique e) { return service.save(e); }

    @GetMapping
    public List<InventairePhysique> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public InventairePhysique get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public InventairePhysique update(@PathVariable Long id, @RequestBody InventairePhysique e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
