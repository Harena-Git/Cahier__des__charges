package cahier.de.charge.controller;

import cahier.de.charge.service.UtilisateurApplicatifService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final UtilisateurApplicatifService utilisateurApplicatifService;

    public LoginController(UtilisateurApplicatifService utilisateurApplicatifService) {
        this.utilisateurApplicatifService = utilisateurApplicatifService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String email, @RequestParam String password, Model model) {
        if (utilisateurApplicatifService.login(email, password).isPresent()) {
            return "redirect:/bienvenue";
        } else {
            model.addAttribute("error", "Email ou mot de passe incorrect.");
            return "login";
        }
    }

    @GetMapping("/bienvenue")
    public String showWelcomePage() {
        return "bienvenue";
    }
}
