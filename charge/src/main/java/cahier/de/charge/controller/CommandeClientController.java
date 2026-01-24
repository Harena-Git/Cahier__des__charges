
package cahier.de.charge.controller;

import cahier.de.charge.model.CommandeClient;
import cahier.de.charge.service.CommandeClientService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/commandeclients")
public class CommandeClientController {
    private final CommandeClientService service;
    public CommandeClientController(CommandeClientService service) { this.service = service; }

    @PostMapping
    public CommandeClient create(@RequestBody CommandeClient e) { return service.save(e); }

    @GetMapping
    public List<CommandeClient> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public CommandeClient get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public CommandeClient update(@PathVariable Long id, @RequestBody CommandeClient e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
