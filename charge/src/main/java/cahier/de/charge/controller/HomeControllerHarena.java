package cahier.de.charge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControllerHarena {

    @GetMapping("/")
    public String home() {
        return "redirect:/auth/login";
    }
}
