
package cahier.de.charge.controller;

import cahier.de.charge.model.ProformaClient;
import cahier.de.charge.service.ProformaClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proformaclients")
public class ProformaClientController {
    private final ProformaClientService service;

    public ProformaClientController(ProformaClientService service) {
        this.service = service;
    }

    @PostMapping
    public ProformaClient create(@RequestBody ProformaClient e) { return service.save(e); }

    @GetMapping
    public List<ProformaClient> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public ProformaClient getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public ProformaClient update(@PathVariable Long id, @RequestBody ProformaClient e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
