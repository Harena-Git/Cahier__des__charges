
package cahier.de.charge.controller;

import cahier.de.charge.model.Utilisateur;
import cahier.de.charge.service.UtilisateurService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {
    private final UtilisateurService service;

    public UtilisateurController(UtilisateurService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public ModelAndView loginForm(@RequestParam(value = "error", required = false) String error) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("error", error);
        return mav;
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String email, @RequestParam String password) {
        Utilisateur user = service.authenticate(email, password);
        if (user != null) {
            return new ModelAndView("bienvenue");
        } else {
            ModelAndView mav = new ModelAndView("login");
            mav.addObject("error", "Email ou mot de passe incorrect.");
            return mav;
        }
    }

    @PostMapping
    public Utilisateur create(@RequestBody Utilisateur e) { return service.save(e); }

    @GetMapping
    public List<Utilisateur> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public Utilisateur getById(@PathVariable Long id) {
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
