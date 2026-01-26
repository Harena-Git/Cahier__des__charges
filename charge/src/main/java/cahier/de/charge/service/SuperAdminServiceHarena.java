package cahier.de.charge.service;

import cahier.de.charge.model.SuperAdmin;
import cahier.de.charge.repository.SuperAdminRepositoryHarena;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SuperAdminServiceHarena {

    @Autowired
    private SuperAdminRepositoryHarena superAdminRepository;

    public Optional<SuperAdmin> findByNom(String nom) {
        return superAdminRepository.findByNom(nom);
    }

    public SuperAdmin save(SuperAdmin superAdmin) {
        return superAdminRepository.save(superAdmin);
    }

    public boolean authenticate(String nom, String mdp) {
        Optional<SuperAdmin> superAdminOpt = findByNom(nom);
        if (superAdminOpt.isPresent()) {
            SuperAdmin superAdmin = superAdminOpt.get();
            return mdp.equals(superAdmin.getMdp());
        }
        return false;
    }

    public Optional<SuperAdmin> findById(Integer id) {
        return superAdminRepository.findById(id);
    }

    public boolean existsByNom(String nom) {
        return superAdminRepository.existsByNom(nom);
    }

    public void deleteById(Integer id) {
        superAdminRepository.deleteById(id);
    }

    public Iterable<SuperAdmin> findAll() {
        return superAdminRepository.findAll();
    }
}
