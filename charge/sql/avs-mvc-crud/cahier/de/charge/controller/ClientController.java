
package cahier.de.charge.controller;

import cahier.de.charge.model.Client;
import cahier.de.charge.service.ClientService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService service;
    public ClientController(ClientService service) { this.service = service; }

    @PostMapping
    public Client create(@RequestBody Client e) { return service.save(e); }

    @GetMapping
    public List<Client> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public Client get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public Client update(@PathVariable Long id, @RequestBody Client e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
