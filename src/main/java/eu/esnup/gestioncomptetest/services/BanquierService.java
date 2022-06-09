package eu.esnup.gestioncomptetest.services;

import eu.esnup.gestioncomptetest.domaine.Banquier;
import eu.esnup.gestioncomptetest.repository.BanquierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<Banquier> get(Long id){
        return banquierRepository.findById(id);
    }

    public List<Banquier> getAll(){
        return new ArrayList<>(banquierRepository.findAll());
    }
}
