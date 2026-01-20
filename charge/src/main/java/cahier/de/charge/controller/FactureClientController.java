
package cahier.de.charge.controller;

import cahier.de.charge.model.FactureClient;
import cahier.de.charge.service.FactureClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factureclients")
public class FactureClientController {
    private final FactureClientService service;

    public FactureClientController(FactureClientService service) {
        this.service = service;
    }

    @PostMapping
    public FactureClient create(@RequestBody FactureClient e) { return service.save(e); }

    @GetMapping
    public List<FactureClient> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public FactureClient getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public FactureClient update(@PathVariable Long id, @RequestBody FactureClient e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
