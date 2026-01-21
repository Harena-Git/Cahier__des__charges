
package cahier.de.charge.service;

import cahier.de.charge.model.UtilisateurApplicatif;
import cahier.de.charge.repository.UtilisateurApplicatifRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtilisateurApplicatifService {

    private final UtilisateurApplicatifRepository utilisateurApplicatifRepository;

    public UtilisateurApplicatifService(UtilisateurApplicatifRepository utilisateurApplicatifRepository) {
        this.utilisateurApplicatifRepository = utilisateurApplicatifRepository;
    }

    public Optional<UtilisateurApplicatif> login(String email, String motDePasse) {
        return utilisateurApplicatifRepository.findByUtilisateurEmailAndMotDePasse(email, motDePasse);
    }
}
