
package cahier.de.charge.controller;

import cahier.de.charge.model.LigneDemandeAchat;
import cahier.de.charge.service.LigneDemandeAchatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lignedemandeachats")
public class LigneDemandeAchatController {
    private final LigneDemandeAchatService service;

    public LigneDemandeAchatController(LigneDemandeAchatService service) {
        this.service = service;
    }

    @PostMapping
    public LigneDemandeAchat create(@RequestBody LigneDemandeAchat e) { return service.save(e); }

    @GetMapping
    public List<LigneDemandeAchat> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public LigneDemandeAchat getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public LigneDemandeAchat update(@PathVariable Long id, @RequestBody LigneDemandeAchat e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
