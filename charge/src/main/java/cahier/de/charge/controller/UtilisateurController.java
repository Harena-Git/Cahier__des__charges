
package cahier.de.charge.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cahier.de.charge.model.Utilisateur;
import cahier.de.charge.service.UtilisateurService;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {
    private final UtilisateurService service;

    public UtilisateurController(UtilisateurService service) {
        this.service = service;
    }

    @PostMapping
    public Utilisateur create(@RequestBody Utilisateur e) { return service.save(e); }

    @GetMapping
    public List<Utilisateur> getAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Utilisateur getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Utilisateur update(@PathVariable Long id, @RequestBody Utilisateur e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
