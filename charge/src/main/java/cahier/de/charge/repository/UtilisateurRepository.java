
package cahier.de.charge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cahier.de.charge.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	Utilisateur findByEmailAndPassword(String email, String password);
}
