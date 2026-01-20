
package cahier.de.charge.controller;

import cahier.de.charge.model.Fournisseur;
import cahier.de.charge.service.FournisseurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fournisseurs")
public class FournisseurController {
    private final FournisseurService service;

    public FournisseurController(FournisseurService service) {
        this.service = service;
    }

    @PostMapping
    public Fournisseur create(@RequestBody Fournisseur e) { return service.save(e); }

    @GetMapping
    public List<Fournisseur> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public Fournisseur getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public Fournisseur update(@PathVariable Long id, @RequestBody Fournisseur e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
