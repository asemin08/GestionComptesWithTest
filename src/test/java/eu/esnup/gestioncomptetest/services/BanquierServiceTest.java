package eu.esnup.gestioncomptetest.services;

import eu.esnup.gestioncomptetest.entities.Banquier;
import eu.esnup.gestioncomptetest.entities.Client;
import eu.esnup.gestioncomptetest.repository.BanquierRepository;
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

import java.util.*;

@SpringBootTest
public class BanquierServiceTest {

    @Mock
    private BanquierRepository banquierRepository;

    @InjectMocks
    private BanquierService banquierService;
    public Set<Client> clientSet1 = new HashSet<>();
    public Set<Client> clientSet2 = new HashSet<>();
    public Set<Client> clientSet3 = new HashSet<>();


    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        clientSet1.add(Client.builder().codeClient((long)1).nom("Joly").prenom("Maffi").build());
        clientSet1.add(Client.builder().codeClient((long)2).nom("Blisse").prenom("Trott").build());
        clientSet1.add(Client.builder().codeClient((long)3).nom("Flo").prenom("Iozefovich").build());

        clientSet2.add(Client.builder().codeClient((long)1).nom("Sheree").prenom("Verling").build());
        clientSet2.add(Client.builder().codeClient((long)2).nom("Harri").prenom("Bottjer").build());
        clientSet2.add(Client.builder().codeClient((long)3).nom("Dorita").prenom("Duckett").build());

        clientSet3.add(Client.builder().codeClient((long)1).nom("Herminia").prenom("Slaight").build());
        clientSet3.add(Client.builder().codeClient((long)2).nom("Felecia").prenom("Piggot").build());
        clientSet3.add(Client.builder().codeClient((long)3).nom("Wallis").prenom("Matushevich").build());
    }



    @Test
    @DisplayName("Recupéres tous les banquiers")
    public void getAllBanquiers(){
        List<Banquier> banquierList = new ArrayList<>();

        banquierList.add(Banquier.builder().codeBanquier((long) 1).nom("Kase").prenom("Odele").clients(clientSet3).build());
        banquierList.add(Banquier.builder().codeBanquier((long) 2).nom("Broady").prenom("Jeane").clients(clientSet1).build());
        banquierList.add(Banquier.builder().codeBanquier((long) 3).nom("Minifie").prenom("Hope").clients(clientSet2).build());

        int banquierListSize = 3;

        Mockito.when(banquierRepository.findAll()).thenReturn(banquierList);

        List<Banquier> banquiers = banquierService.getAll();
        MatcherAssert.assertThat(banquiers.size(), Matchers.equalTo(banquierListSize));
        Mockito.verify(banquierRepository).findAll();
    }

    @Test
    @DisplayName("Recupéres un banquier")
    public void getBanquier(){

        Long codeBanquier = 1L;

        Optional<Banquier> banquierInitital = Optional.ofNullable(Banquier.builder().codeBanquier((long) 1).nom("Kase").prenom("Odele").clients(clientSet3).build());

        Mockito.when(banquierRepository.findById(codeBanquier)).thenReturn(banquierInitital);
        Optional<Banquier> banquier = banquierService.get(codeBanquier);

        MatcherAssert.assertThat(banquier.get().getNom(), Matchers.hasToString("Kase"));
        Mockito.verify(banquierRepository).findById(codeBanquier);
    }

    @Test
    @DisplayName("Ajouter un banquier")
    public void createBanquier(){
        Banquier banquierInitital = Banquier.builder().nom("Broady").prenom("Jeane").clients(clientSet1).build();
        Banquier banquierFinal = Banquier.builder().codeBanquier((long) 1).nom("Broady").prenom("Jeane").clients(clientSet1).build();

        Mockito.when(banquierRepository.save(banquierInitital)).thenReturn(banquierFinal);
        Banquier banquier = banquierService.create(banquierInitital);

        MatcherAssert.assertThat(banquier.getCodeBanquier(), Matchers.equalTo(banquierFinal.getCodeBanquier()));
        Mockito.verify(banquierRepository).save(banquierInitital);

    }

    @Test
    @DisplayName("Modifier un Banquier")
    public void updateBanquier(){


        Banquier banquierInitital = Banquier.builder().codeBanquier((long) 3).nom("Minifie").prenom("Hope").clients(clientSet2).build();

        Mockito.when(banquierRepository.save(banquierInitital)).thenReturn(banquierInitital);
        Banquier banquier = banquierService.update(banquierInitital);

        MatcherAssert.assertThat(banquier.getCodeBanquier(), Matchers.equalTo(banquierInitital.getCodeBanquier()));
        Mockito.verify(banquierRepository).save(banquierInitital);
    }

    @Test
    @DisplayName("Supprimer un Banquier")
    public void deteleBanquier(){

        Long deleteId = 1L;
        Mockito.doNothing().when(banquierRepository).deleteById(deleteId);
        banquierService.delete(deleteId);
        Mockito.verify(banquierRepository).deleteById(deleteId);
    }
}
