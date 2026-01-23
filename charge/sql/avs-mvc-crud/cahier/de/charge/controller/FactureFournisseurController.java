
package cahier.de.charge.controller;

import cahier.de.charge.model.FactureFournisseur;
import cahier.de.charge.service.FactureFournisseurService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/facturefournisseurs")
public class FactureFournisseurController {
    private final FactureFournisseurService service;
    public FactureFournisseurController(FactureFournisseurService service) { this.service = service; }

    @PostMapping
    public FactureFournisseur create(@RequestBody FactureFournisseur e) { return service.save(e); }

    @GetMapping
    public List<FactureFournisseur> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public FactureFournisseur get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public FactureFournisseur update(@PathVariable Long id, @RequestBody FactureFournisseur e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
