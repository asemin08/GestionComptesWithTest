package eu.esnup.gestioncomptetest.services;

import eu.esnup.gestioncomptetest.entities.Banquier;
import eu.esnup.gestioncomptetest.entities.Client;
import eu.esnup.gestioncomptetest.repository.BanquierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Set;

@Service
public class BanquierService {

    private BanquierRepository banquierRepository;

    @Autowired
    public BanquierService(BanquierRepository banquierRepository) {
        this.banquierRepository = banquierRepository;
    }

    public Banquier create(Banquier banquier){
        return banquierRepository.save(banquier);
    }

    public Banquier update(Banquier banquier){
        return banquierRepository.save(banquier);
    }

    public void delete(Long id) {
        banquierRepository.deleteById(id);
    }

    public Banquier get(Long id){
        return banquierRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Set<Banquier> getAll(){
        return new HashSet<>(banquierRepository.findAll());
    }
}
