package cahier.de.charge.repository;

import cahier.de.charge.model.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartementRepositoryHarena extends JpaRepository<Departement, Integer> {
    
    Optional<Departement> findByNom(String nom);
    
    boolean existsByNom(String nom);
}
