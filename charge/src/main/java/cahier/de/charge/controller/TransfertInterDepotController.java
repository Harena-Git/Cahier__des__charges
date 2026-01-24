
package cahier.de.charge.controller;

import cahier.de.charge.model.TransfertInterDepot;
import cahier.de.charge.service.TransfertInterDepotService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/transfertinterdepots")
public class TransfertInterDepotController {
    private final TransfertInterDepotService service;
    public TransfertInterDepotController(TransfertInterDepotService service) { this.service = service; }

    @PostMapping
    public TransfertInterDepot create(@RequestBody TransfertInterDepot e) { return service.save(e); }

    @GetMapping
    public List<TransfertInterDepot> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public TransfertInterDepot get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public TransfertInterDepot update(@PathVariable Long id, @RequestBody TransfertInterDepot e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
