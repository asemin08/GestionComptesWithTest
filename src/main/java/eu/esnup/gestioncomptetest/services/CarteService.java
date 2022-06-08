package eu.esnup.gestioncomptetest.services;

import eu.esnup.gestioncomptetest.entities.Carte;
import eu.esnup.gestioncomptetest.repository.BanquierRepository;
import eu.esnup.gestioncomptetest.repository.CarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Set;

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

    public Carte get(Long id){
        return carteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Set<Carte> getAll(){
        return new HashSet<>(carteRepository.findAll());
    }
}
