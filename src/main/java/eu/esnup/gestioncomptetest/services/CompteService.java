package eu.esnup.gestioncomptetest.services;

import eu.esnup.gestioncomptetest.domaine.Compte;
import eu.esnup.gestioncomptetest.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Compte service.
 */
@Service
public class CompteService {

    private CompteRepository compteRepository;

    /**
     * Instantiates a new Compte service.
     *
     * @param compteRepository the compte repository
     */
    @Autowired
    public CompteService(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    /**
     * Create compte.
     *
     * @param compte the compte
     * @return the compte
     */
    public Compte create(Compte compte){
        return compteRepository.save(compte);
    }

    /**
     * Update compte.
     *
     * @param compte the compte
     * @return the compte
     */
    public Compte update(Compte compte){
        return compteRepository.save(compte);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(Long id) {
        compteRepository.deleteById(id);
    }

    /**
     * Get optional.
     *
     * @param id the id
     * @return the optional
     */
    public Optional<Compte> get(Long id){
        return compteRepository.findById(id);
    }

    /**
     * Get all list.
     *
     * @return the list
     */
    public List<Compte> getAll(){
        return new ArrayList<>(compteRepository.findAll());
    }

}
