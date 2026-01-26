package cahier.de.charge.service;

import cahier.de.charge.model.Utilisateur;
import cahier.de.charge.repository.UtilisateurRepositoryHarena;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurServiceHarena {

    @Autowired
    private UtilisateurRepositoryHarena utilisateurRepository;

    public Optional<Utilisateur> findByEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }

    public Utilisateur save(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public boolean authenticate(String email, String motDePasse) {
        Optional<Utilisateur> utilisateurOpt = findByEmail(email);
        if (utilisateurOpt.isPresent()) {
            Utilisateur utilisateur = utilisateurOpt.get();
            return motDePasse.equals(utilisateur.getMotDePasse());
        }
        return false;
    }

    public Optional<Utilisateur> findById(Integer id) {
        return utilisateurRepository.findById(id);
    }

    public boolean existsByEmail(String email) {
        return utilisateurRepository.existsByEmail(email);
    }

    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    public void deleteById(Integer id) {
        utilisateurRepository.deleteById(id);
    }
}
