
package cahier.de.charge.controller;

import cahier.de.charge.model.Utilisateur;
import cahier.de.charge.service.UtilisateurService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {
    private final UtilisateurService service;
    public UtilisateurController(UtilisateurService service) { this.service = service; }

    @PostMapping
    public Utilisateur create(@RequestBody Utilisateur e) { return service.save(e); }

    @GetMapping
    public List<Utilisateur> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public Utilisateur get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public Utilisateur update(@PathVariable Long id, @RequestBody Utilisateur e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
