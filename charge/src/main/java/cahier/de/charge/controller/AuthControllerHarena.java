package cahier.de.charge.controller;

import cahier.de.charge.model.Utilisateur;
import cahier.de.charge.service.UtilisateurServiceHarena;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthControllerHarena {

    @Autowired
    private UtilisateurServiceHarena utilisateurService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest loginRequest, HttpSession session, Model model) {
        if (utilisateurService.authenticate(loginRequest.getEmail(), loginRequest.getMotDePasse())) {
            Utilisateur utilisateur = utilisateurService.findByEmail(loginRequest.getEmail()).orElse(null);
            session.setAttribute("utilisateur", utilisateur);
            return "redirect:/admin/dashboard";
        } else {
            model.addAttribute("error", "Email ou mot de passe incorrect");
            return "admin/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }

    public static class LoginRequest {
        private String email;
        private String motDePasse;

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getMotDePasse() { return motDePasse; }
        public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }
    }
}
