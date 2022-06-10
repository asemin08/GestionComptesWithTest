package eu.esnup.gestioncomptetest.services;

import eu.esnup.gestioncomptetest.domaine.Client;
import eu.esnup.gestioncomptetest.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Client service.
 */
@Service
public class ClientService {

    private ClientRepository clientRepository;

    /**
     * Instantiates a new Client service.
     *
     * @param clientRepository the client repository
     */
    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * Create client.
     *
     * @param client the client
     * @return the client
     */
    public Client create(Client client){
        return clientRepository.save(client);
    }

    /**
     * Update client.
     *
     * @param client the client
     * @return the client
     */
    public Client update(Client client){
        return clientRepository.save(client);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    /**
     * Get optional.
     *
     * @param id the id
     * @return the optional
     */
    public Optional<Client> get(Long id){
        return clientRepository.findById(id);
    }

    /**
     * Get all list.
     *
     * @return the list
     */
    public List<Client> getAll(){
        return new ArrayList<>(clientRepository.findAll());
    }

}
