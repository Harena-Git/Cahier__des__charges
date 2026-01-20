
package cahier.de.charge.controller;

import cahier.de.charge.model.ProfilUtilisateur;
import cahier.de.charge.service.ProfilUtilisateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profilutilisateurs")
public class ProfilUtilisateurController {
    private final ProfilUtilisateurService service;

    public ProfilUtilisateurController(ProfilUtilisateurService service) {
        this.service = service;
    }

    @PostMapping
    public ProfilUtilisateur create(@RequestBody ProfilUtilisateur e) { return service.save(e); }

    @GetMapping
    public List<ProfilUtilisateur> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public ProfilUtilisateur getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public ProfilUtilisateur update(@PathVariable Long id, @RequestBody ProfilUtilisateur e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
