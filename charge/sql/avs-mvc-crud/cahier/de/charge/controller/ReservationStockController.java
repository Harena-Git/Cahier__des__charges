
package cahier.de.charge.controller;

import cahier.de.charge.model.ReservationStock;
import cahier.de.charge.service.ReservationStockService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/reservationstocks")
public class ReservationStockController {
    private final ReservationStockService service;
    public ReservationStockController(ReservationStockService service) { this.service = service; }

    @PostMapping
    public ReservationStock create(@RequestBody ReservationStock e) { return service.save(e); }

    @GetMapping
    public List<ReservationStock> getAll() { return service.findAll(); }

    @GetMapping("/<built-in function id>")
    public ReservationStock get(@PathVariable Long id) {
        return service.findById(id).orElse(null);
    }

    @PutMapping("/<built-in function id>")
    public ReservationStock update(@PathVariable Long id, @RequestBody ReservationStock e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
