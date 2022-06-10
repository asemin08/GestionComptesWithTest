package eu.esnup.gestioncomptetest.services;

import eu.esnup.gestioncomptetest.domaine.Banquier;
import eu.esnup.gestioncomptetest.repository.BanquierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Banquier service.
 */
@Service
public class BanquierService {

    private BanquierRepository banquierRepository;

    /**
     * Instantiates a new Banquier service.
     *
     * @param banquierRepository the banquier repository
     */
    @Autowired
    public BanquierService(BanquierRepository banquierRepository) {
        this.banquierRepository = banquierRepository;
    }

    /**
     * Create banquier.
     *
     * @param banquier the banquier
     * @return the banquier
     */
    public Banquier create(Banquier banquier){
        return banquierRepository.save(banquier);
    }

    /**
     * Update banquier.
     *
     * @param banquier the banquier
     * @return the banquier
     */
    public Banquier update(Banquier banquier){
        return banquierRepository.save(banquier);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(Long id) {
        banquierRepository.deleteById(id);
    }

    /**
     * Get optional.
     *
     * @param id the id
     * @return the optional
     */
    public Optional<Banquier> get(Long id){
        return banquierRepository.findById(id);
    }

    /**
     * Get all list.
     *
     * @return the list
     */
    public List<Banquier> getAll(){
        return new ArrayList<>(banquierRepository.findAll());
    }
}
