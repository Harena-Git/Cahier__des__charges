
package cahier.de.charge.controller;

import cahier.de.charge.model.UtilisateurDepot;
import cahier.de.charge.service.UtilisateurDepotService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurdepots")
public class UtilisateurDepotController {
    private final UtilisateurDepotService service;

    public UtilisateurDepotController(UtilisateurDepotService service) {
        this.service = service;
    }

    @PostMapping
    public UtilisateurDepot create(@RequestBody UtilisateurDepot e) { return service.save(e); }

    @GetMapping
    public List<UtilisateurDepot> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public UtilisateurDepot getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public UtilisateurDepot update(@PathVariable Long id, @RequestBody UtilisateurDepot e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
