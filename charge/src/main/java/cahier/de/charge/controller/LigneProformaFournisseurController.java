
package cahier.de.charge.controller;

import cahier.de.charge.model.LigneProformaFournisseur;
import cahier.de.charge.service.LigneProformaFournisseurService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/ligneproformafournisseurs")
public class LigneProformaFournisseurController {
    private final LigneProformaFournisseurService service;
    public LigneProformaFournisseurController(LigneProformaFournisseurService service) { this.service = service; }

    @PostMapping
    public LigneProformaFournisseur create(@RequestBody LigneProformaFournisseur e) { return service.save(e); }

    @GetMapping
    public List<LigneProformaFournisseur> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public LigneProformaFournisseur get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public LigneProformaFournisseur update(@PathVariable Long id, @RequestBody LigneProformaFournisseur e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
