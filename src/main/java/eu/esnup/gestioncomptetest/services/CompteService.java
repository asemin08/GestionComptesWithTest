package eu.esnup.gestioncomptetest.services;

import eu.esnup.gestioncomptetest.entities.Compte;
import eu.esnup.gestioncomptetest.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompteService {

    private CompteRepository compteRepository;

    @Autowired
    public CompteService(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    public Compte create(Compte compte){
        return compteRepository.save(compte);
    }

    public Compte update(Compte compte){
        return compteRepository.save(compte);
    }

    public void delete(Long id) {
        compteRepository.deleteById(id);
    }

    public Optional<Compte> get(Long id){
        return compteRepository.findById(id);
    }

    public List<Compte> getAll(){
        return new ArrayList<>(compteRepository.findAll());
    }

}
