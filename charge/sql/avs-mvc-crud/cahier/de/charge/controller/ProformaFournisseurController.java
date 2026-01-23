
package cahier.de.charge.controller;

import cahier.de.charge.model.ProformaFournisseur;
import cahier.de.charge.service.ProformaFournisseurService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/proformafournisseurs")
public class ProformaFournisseurController {
    private final ProformaFournisseurService service;
    public ProformaFournisseurController(ProformaFournisseurService service) { this.service = service; }

    @PostMapping
    public ProformaFournisseur create(@RequestBody ProformaFournisseur e) { return service.save(e); }

    @GetMapping
    public List<ProformaFournisseur> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public ProformaFournisseur get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public ProformaFournisseur update(@PathVariable Long id, @RequestBody ProformaFournisseur e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
