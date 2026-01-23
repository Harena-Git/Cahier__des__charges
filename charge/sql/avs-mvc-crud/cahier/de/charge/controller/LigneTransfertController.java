
package cahier.de.charge.controller;

import cahier.de.charge.model.LigneTransfert;
import cahier.de.charge.service.LigneTransfertService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/lignetransferts")
public class LigneTransfertController {
    private final LigneTransfertService service;
    public LigneTransfertController(LigneTransfertService service) { this.service = service; }

    @PostMapping
    public LigneTransfert create(@RequestBody LigneTransfert e) { return service.save(e); }

    @GetMapping
    public List<LigneTransfert> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public LigneTransfert get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public LigneTransfert update(@PathVariable Long id, @RequestBody LigneTransfert e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
