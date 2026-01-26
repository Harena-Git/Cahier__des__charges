package cahier.de.charge.controller;

import cahier.de.charge.model.Utilisateur;
import cahier.de.charge.model.SuperAdmin;
import cahier.de.charge.service.UtilisateurServiceHarena;
import cahier.de.charge.service.SuperAdminServiceHarena;
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

    @Autowired
    private SuperAdminServiceHarena superAdminService;

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

    // ====================
    // SUPER ADMIN ROUTES
    // ====================

    @GetMapping("/super-admin/login")
    public String showSuperAdminLoginForm(Model model) {
        model.addAttribute("superAdminLoginRequest", new SuperAdminLoginRequest());
        return "admin/super-admin-login";
    }

    @PostMapping("/super-admin/login")
    public String superAdminLogin(@ModelAttribute SuperAdminLoginRequest loginRequest, HttpSession session, Model model) {
        if (superAdminService.authenticate(loginRequest.getNom(), loginRequest.getMdp())) {
            SuperAdmin superAdmin = superAdminService.findByNom(loginRequest.getNom()).orElse(null);
            session.setAttribute("superAdmin", superAdmin);
            return "redirect:/admin/super-dashboard";
        } else {
            model.addAttribute("error", "Nom ou mot de passe incorrect");
            return "admin/super-admin-login";
        }
    }

    @GetMapping("/super-admin/logout")
    public String superAdminLogout(HttpSession session) {
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

    public static class SuperAdminLoginRequest {
        private String nom;
        private String mdp;

        public String getNom() { return nom; }
        public void setNom(String nom) { this.nom = nom; }

        public String getMdp() { return mdp; }
        public void setMdp(String mdp) { this.mdp = mdp; }
    }
}
