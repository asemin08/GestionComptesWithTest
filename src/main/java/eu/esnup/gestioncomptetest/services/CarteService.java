package eu.esnup.gestioncomptetest.services;

import eu.esnup.gestioncomptetest.entities.Carte;
import eu.esnup.gestioncomptetest.repository.CarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarteService {

    private CarteRepository carteRepository;

    @Autowired
    public CarteService(CarteRepository carteRepository) {
        this.carteRepository = carteRepository;
    }

    public Carte create(Carte carte){
        return carteRepository.save(carte);
    }

    public Carte update(Carte carte){
        return carteRepository.save(carte);
    }

    public void delete(Long id) {
        carteRepository.deleteById(id);
    }

    public Optional<Carte> get(Long id){
        return carteRepository.findById(id);
    }

    public List<Carte> getAll(){
        return new ArrayList<>(carteRepository.findAll());
    }
}
