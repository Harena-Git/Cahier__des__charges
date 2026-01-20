
package cahier.de.charge.controller;

import cahier.de.charge.model.EncaissementClient;
import cahier.de.charge.service.EncaissementClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/encaissementclients")
public class EncaissementClientController {
    private final EncaissementClientService service;

    public EncaissementClientController(EncaissementClientService service) {
        this.service = service;
    }

    @PostMapping
    public EncaissementClient create(@RequestBody EncaissementClient e) { return service.save(e); }

    @GetMapping
    public List<EncaissementClient> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public EncaissementClient getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public EncaissementClient update(@PathVariable Long id, @RequestBody EncaissementClient e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
