
package cahier.de.charge.controller;

import cahier.de.charge.model.UtilisateurApplicatif;
import cahier.de.charge.service.UtilisateurApplicatifService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurapplicatifs")
public class UtilisateurApplicatifController {
    private final UtilisateurApplicatifService service;

    public UtilisateurApplicatifController(UtilisateurApplicatifService service) {
        this.service = service;
    }

    @PostMapping
    public UtilisateurApplicatif create(@RequestBody UtilisateurApplicatif e) { return service.save(e); }

    @GetMapping
    public List<UtilisateurApplicatif> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public UtilisateurApplicatif getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public UtilisateurApplicatif update(@PathVariable Long id, @RequestBody UtilisateurApplicatif e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
