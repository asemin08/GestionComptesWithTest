package eu.esnup.gestioncomptetest.services;

import eu.esnup.gestioncomptetest.domaine.Carte;
import eu.esnup.gestioncomptetest.repository.CarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Carte service.
 */
@Service
public class CarteService {

    private CarteRepository carteRepository;

    /**
     * Instantiates a new Carte service.
     *
     * @param carteRepository the carte repository
     */
    @Autowired
    public CarteService(CarteRepository carteRepository) {
        this.carteRepository = carteRepository;
    }

    /**
     * Create carte.
     *
     * @param carte the carte
     * @return the carte
     */
    public Carte create(Carte carte){
        return carteRepository.save(carte);
    }

    /**
     * Update carte.
     *
     * @param carte the carte
     * @return the carte
     */
    public Carte update(Carte carte){
        return carteRepository.save(carte);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(Long id) {
        carteRepository.deleteById(id);
    }

    /**
     * Get optional.
     *
     * @param id the id
     * @return the optional
     */
    public Optional<Carte> get(Long id){
        return carteRepository.findById(id);
    }

    /**
     * Get all list.
     *
     * @return the list
     */
    public List<Carte> getAll(){
        return new ArrayList<>(carteRepository.findAll());
    }
}
