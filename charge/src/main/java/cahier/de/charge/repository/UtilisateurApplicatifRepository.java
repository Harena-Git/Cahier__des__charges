
package cahier.de.charge.repository;

import cahier.de.charge.model.UtilisateurApplicatif;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurApplicatifRepository extends JpaRepository<UtilisateurApplicatif, Long> {
    Optional<UtilisateurApplicatif> findByUtilisateurEmailAndMotDePasse(String email, String motDePasse);
}
