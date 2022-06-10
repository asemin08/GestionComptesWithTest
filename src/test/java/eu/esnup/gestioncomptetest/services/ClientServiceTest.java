package eu.esnup.gestioncomptetest.services;

import eu.esnup.gestioncomptetest.domaine.Client;
import eu.esnup.gestioncomptetest.domaine.Carte;
import eu.esnup.gestioncomptetest.domaine.Compte;
import eu.esnup.gestioncomptetest.enums.TypeCarte;
import eu.esnup.gestioncomptetest.enums.TypeCompte;
import eu.esnup.gestioncomptetest.repository.ClientRepository;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@SpringBootTest
public class ClientServiceTest {

    public LocalDateTime localDateTime = LocalDateTime.now();
    public Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
    public Date date = Date.from(instant);

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;
    public Set<Compte> compteSet1 = new HashSet<>();
    public Carte carteJeune;
    public Carte carteClassique;
    public Carte cartePrenium;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        compteSet1.add(Compte.builder().codeCompte((long) 1).type(TypeCompte.COURANT).solde(20000.00).dateCreation(date).build());
        compteSet1.add(Compte.builder().codeCompte((long) 2).type(TypeCompte.EPARGNE).solde(54000.00).dateCreation(date).build());
        compteSet1.add(Compte.builder().codeCompte((long) 3).type(TypeCompte.EPARGNE).solde(6000.00).dateCreation(date).build());
        carteJeune = Carte.builder().codeCarte((long) 1).typeCarte(TypeCarte.JEUNE).build();
        carteClassique = Carte.builder().codeCarte((long) 2).typeCarte(TypeCarte.CLASSIQUE).build();
        cartePrenium = Carte.builder().codeCarte((long) 3).typeCarte(TypeCarte.PRENIUM).build();

    }

    @Test
    @DisplayName("Recupéres tous les Clients")
    public void getAllClients(){
        List<Client> clientList = new ArrayList<>();
        
        clientList.add(Client.builder().codeClient((long)1).nom("Joly").prenom("Maffi").carte(carteClassique).comptes(compteSet1).build());
        clientList.add(Client.builder().codeClient((long)2).nom("Blisse").prenom("Trott").carte(carteJeune).comptes(compteSet1).build());
        clientList.add(Client.builder().codeClient((long)3).nom("Flo").prenom("Iozefovich").carte(cartePrenium).comptes(compteSet1).build());

        int clientListSize = 3;

        Mockito.when(clientRepository.findAll()).thenReturn(clientList);

        List<Client> Clients = clientService.getAll();
        MatcherAssert.assertThat(Clients.size(), Matchers.equalTo(4));
        Mockito.verify(clientRepository).findAll();
    }

    @Test
    @DisplayName("Recupéres un client")
    public void getClient(){

        Long codeClient = 1L;

        Optional<Client> clientInitital = Optional.ofNullable(Client.builder().codeClient((long)1).nom("Joly").prenom("Maffi").carte(carteClassique).comptes(compteSet1).build());

        Mockito.when(clientRepository.findById(codeClient)).thenReturn(clientInitital);
        Optional<Client> client = clientService.get(codeClient);

        MatcherAssert.assertThat(client.get().getNom(), Matchers.hasToString("Joly"));
        Mockito.verify(clientRepository).findById(codeClient);
    }

    @Test
    @DisplayName("Ajouter un client")
    public void createBanquier(){
        Client clientInitital = Client.builder().nom("Joly").prenom("Maffi").carte(carteClassique).comptes(compteSet1).build();
        Client clientFinal = Client.builder().codeClient((long)1).nom("Joly").prenom("Maffi").carte(carteClassique).comptes(compteSet1).build();

        Mockito.when(clientRepository.save(clientInitital)).thenReturn(clientFinal);
        Client client = clientService.create(clientInitital);

        MatcherAssert.assertThat(client.getCodeClient(), Matchers.equalTo(clientFinal.getCodeClient()));
        Mockito.verify(clientRepository).save(clientInitital);

    }

    @Test
    @DisplayName("Modifier un Client")
    public void updateBanquier(){


        Client clientInitital = Client.builder().codeClient((long)3).nom("Flo").prenom("Iozefovich").carte(cartePrenium).comptes(compteSet1).build();

        Mockito.when(clientRepository.save(clientInitital)).thenReturn(clientInitital);
        Client client = clientService.update(clientInitital);

        MatcherAssert.assertThat(client.getCodeClient(), Matchers.equalTo(clientInitital.getCodeClient()));
        Mockito.verify(clientRepository).save(clientInitital);
    }

    @Test
    @DisplayName("Supprimer un Client")
    public void deteleBanquier(){

        Long deleteId = 1L;
        Mockito.doNothing().when(clientRepository).deleteById(deleteId);
        clientService.delete(deleteId);
        Mockito.verify(clientRepository).deleteById(deleteId);
    }

}
