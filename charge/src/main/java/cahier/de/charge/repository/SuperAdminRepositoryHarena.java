package cahier.de.charge.repository;

import cahier.de.charge.model.SuperAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SuperAdminRepositoryHarena extends JpaRepository<SuperAdmin, Integer> {
    
    Optional<SuperAdmin> findByNom(String nom);
    
    boolean existsByNom(String nom);
}
