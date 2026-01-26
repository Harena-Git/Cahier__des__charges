package cahier.de.charge.controller;

import cahier.de.charge.model.Utilisateur;
import cahier.de.charge.model.SuperAdmin;
import cahier.de.charge.model.Departement;
import cahier.de.charge.service.UtilisateurServiceHarena;
import cahier.de.charge.service.SuperAdminServiceHarena;
import cahier.de.charge.service.DepartementServiceHarena;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminControllerHarena {

    @Autowired
    private UtilisateurServiceHarena utilisateurService;

    @Autowired
    private SuperAdminServiceHarena superAdminService;

    @Autowired
    private DepartementServiceHarena departementService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        return "admin/dashboard";
    }

    // ====================
    // SUPER ADMIN DASHBOARD
    // ====================

    @GetMapping("/super-dashboard")
    public String superDashboard(Model model, HttpSession session) {
        SuperAdmin superAdmin = (SuperAdmin) session.getAttribute("superAdmin");
        if (superAdmin == null) {
            return "redirect:/auth/super-admin/login";
        }
        
        model.addAttribute("superAdmin", superAdmin);
        model.addAttribute("utilisateurs", utilisateurService.findAll());
        model.addAttribute("departements", departementService.findAll());
        return "admin/super-dashboard";
    }

    // ====================
    // GESTION DES UTILISATEURS
    // ====================

    @GetMapping("/create-user")
    public String showCreateUserForm(Model model, HttpSession session) {
        SuperAdmin superAdmin = (SuperAdmin) session.getAttribute("superAdmin");
        if (superAdmin == null) {
            return "redirect:/auth/super-admin/login";
        }
        
        model.addAttribute("utilisateur", new Utilisateur());
        model.addAttribute("departements", departementService.findAll());
        return "admin/create-user";
    }

    @PostMapping("/create-user")
    public String createUser(@ModelAttribute Utilisateur utilisateur, HttpSession session, Model model) {
        SuperAdmin superAdmin = (SuperAdmin) session.getAttribute("superAdmin");
        if (superAdmin == null) {
            return "redirect:/auth/super-admin/login";
        }
        
        try {
            if (utilisateurService.existsByEmail(utilisateur.getEmail())) {
                model.addAttribute("error", "Cet email existe déjà");
                model.addAttribute("utilisateur", utilisateur);
                return "admin/create-user";
            }
            
            utilisateurService.save(utilisateur);
            return "redirect:/admin/super-dashboard?success=Utilisateur créé avec succès";
        } catch (Exception e) {
            model.addAttribute("error", "Erreur lors de la création de l'utilisateur: " + e.getMessage());
            model.addAttribute("utilisateur", utilisateur);
            return "admin/create-user";
        }
    }

    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable Integer id, HttpSession session) {
        SuperAdmin superAdmin = (SuperAdmin) session.getAttribute("superAdmin");
        if (superAdmin == null) {
            return "redirect:/auth/super-admin/login";
        }
        
        try {
            utilisateurService.deleteById(id);
        } catch (Exception e) {
            // Gérer l'erreur
        }
        
        return "redirect:/admin/super-dashboard";
    }
}
