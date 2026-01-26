package cahier.de.charge.service;

import cahier.de.charge.model.Departement;
import cahier.de.charge.repository.DepartementRepositoryHarena;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartementServiceHarena {

    @Autowired
    private DepartementRepositoryHarena departementRepository;

    public Optional<Departement> findByNom(String nom) {
        return departementRepository.findByNom(nom);
    }

    public Departement save(Departement departement) {
        return departementRepository.save(departement);
    }

    public Optional<Departement> findById(Integer id) {
        return departementRepository.findById(id);
    }

    public boolean existsByNom(String nom) {
        return departementRepository.existsByNom(nom);
    }

    public List<Departement> findAll() {
        return departementRepository.findAll();
    }

    public void deleteById(Integer id) {
        departementRepository.deleteById(id);
    }
}
