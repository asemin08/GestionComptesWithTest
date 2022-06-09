package eu.esnup.gestioncomptetest.services;

import eu.esnup.gestioncomptetest.entities.Client;
import eu.esnup.gestioncomptetest.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client create(Client client){
        return clientRepository.save(client);
    }

    public Client update(Client client){
        return clientRepository.save(client);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    public Optional<Client> get(Long id){
        return clientRepository.findById(id);
    }

    public List<Client> getAll(){
        return new ArrayList<>(clientRepository.findAll());
    }

}
