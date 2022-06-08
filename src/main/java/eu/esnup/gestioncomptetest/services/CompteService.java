package eu.esnup.gestioncomptetest.services;

import eu.esnup.gestioncomptetest.entities.Compte;
import eu.esnup.gestioncomptetest.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Set;

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

    public Compte get(Long id){
        return compteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Set<Compte> getAll(){
        return new HashSet<>(compteRepository.findAll());
    }

}
