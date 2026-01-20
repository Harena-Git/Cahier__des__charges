
package cahier.de.charge.controller;

import cahier.de.charge.model.TypeClient;
import cahier.de.charge.service.TypeClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typeclients")
public class TypeClientController {
    private final TypeClientService service;

    public TypeClientController(TypeClientService service) {
        this.service = service;
    }

    @PostMapping
    public TypeClient create(@RequestBody TypeClient e) { return service.save(e); }

    @GetMapping
    public List<TypeClient> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public TypeClient getById(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public TypeClient update(@PathVariable Long id, @RequestBody TypeClient e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
