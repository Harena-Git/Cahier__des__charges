
package cahier.de.charge.controller;

import cahier.de.charge.model.LigneCommandeClient;
import cahier.de.charge.service.LigneCommandeClientService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/lignecommandeclients")
public class LigneCommandeClientController {
    private final LigneCommandeClientService service;
    public LigneCommandeClientController(LigneCommandeClientService service) { this.service = service; }

    @PostMapping
    public LigneCommandeClient create(@RequestBody LigneCommandeClient e) { return service.save(e); }

    @GetMapping
    public List<LigneCommandeClient> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public LigneCommandeClient get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public LigneCommandeClient update(@PathVariable Long id, @RequestBody LigneCommandeClient e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
