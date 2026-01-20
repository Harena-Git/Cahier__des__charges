
package cahier.de.charge.controller;

import cahier.de.charge.model.DemandeAchat;
import cahier.de.charge.service.DemandeAchatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demandeachats")
public class DemandeAchatController {
    private final DemandeAchatService service;

    public DemandeAchatController(DemandeAchatService service) {
        this.service = service;
    }

    @PostMapping
    public DemandeAchat create(@RequestBody DemandeAchat e) { return service.save(e); }

    @GetMapping
    public List<DemandeAchat> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public DemandeAchat getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public DemandeAchat update(@PathVariable Long id, @RequestBody DemandeAchat e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
