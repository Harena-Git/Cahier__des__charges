
package cahier.de.charge.controller;

import cahier.de.charge.model.PaiementFournisseur;
import cahier.de.charge.service.PaiementFournisseurService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/paiementfournisseurs")
public class PaiementFournisseurController {
    private final PaiementFournisseurService service;
    public PaiementFournisseurController(PaiementFournisseurService service) { this.service = service; }

    @PostMapping
    public PaiementFournisseur create(@RequestBody PaiementFournisseur e) { return service.save(e); }

    @GetMapping
    public List<PaiementFournisseur> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public PaiementFournisseur get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public PaiementFournisseur update(@PathVariable Long id, @RequestBody PaiementFournisseur e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
