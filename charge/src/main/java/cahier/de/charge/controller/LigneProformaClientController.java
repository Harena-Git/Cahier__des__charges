
package cahier.de.charge.controller;

import cahier.de.charge.model.LigneProformaClient;
import cahier.de.charge.service.LigneProformaClientService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/ligneproformaclients")
public class LigneProformaClientController {
    private final LigneProformaClientService service;
    public LigneProformaClientController(LigneProformaClientService service) { this.service = service; }

    @PostMapping
    public LigneProformaClient create(@RequestBody LigneProformaClient e) { return service.save(e); }

    @GetMapping
    public List<LigneProformaClient> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public LigneProformaClient get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public LigneProformaClient update(@PathVariable Long id, @RequestBody LigneProformaClient e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
