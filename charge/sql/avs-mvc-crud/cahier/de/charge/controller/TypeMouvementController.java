
package cahier.de.charge.controller;

import cahier.de.charge.model.TypeMouvement;
import cahier.de.charge.service.TypeMouvementService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/typemouvements")
public class TypeMouvementController {
    private final TypeMouvementService service;
    public TypeMouvementController(TypeMouvementService service) { this.service = service; }

    @PostMapping
    public TypeMouvement create(@RequestBody TypeMouvement e) { return service.save(e); }

    @GetMapping
    public List<TypeMouvement> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public TypeMouvement get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public TypeMouvement update(@PathVariable Long id, @RequestBody TypeMouvement e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
