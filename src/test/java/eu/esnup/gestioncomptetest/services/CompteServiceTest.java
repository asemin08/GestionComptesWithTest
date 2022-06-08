package eu.esnup.gestioncomptetest.services;

import eu.esnup.gestioncomptetest.entities.Compte;
import eu.esnup.gestioncomptetest.enums.TypeCompte;
import eu.esnup.gestioncomptetest.repository.CompteRepository;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class CompteServiceTest {

    @Mock
    private CompteRepository compteRepository;

    @InjectMocks
    private CompteService compteService;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
    }

    public LocalDateTime localDateTime = LocalDateTime.now();
    public Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
    public Date date = Date.from(instant);

    @Test
    @DisplayName("Recupéres tous les comptes")
    public void getAllCartes(){
        List<Compte> compteList = new ArrayList<>();
        compteList.add(Compte.builder().codeCompte((long) 1).type(TypeCompte.COURANT).solde(20000.00).dateCreation(date).build());
        compteList.add(Compte.builder().codeCompte((long) 2).type(TypeCompte.EPARGNE).solde(40000.00).dateCreation(date).build());
        compteList.add(Compte.builder().codeCompte((long) 3).type(TypeCompte.EPARGNE).solde(40000.00).dateCreation(date).build());

        int carteListSize = 3;

        Mockito.when(compteRepository.findAll()).thenReturn(compteList);

        Set<Compte> comptes = compteService.getAll();
        MatcherAssert.assertThat(comptes.size(), Matchers.equalTo(carteListSize));
        Mockito.verify(compteRepository).findAll();
    }

    @Test
    @DisplayName("Recupéres un compte")
    public void getCarte(){

        Long codeCompte = 1L;

        Optional<Compte> compteInitial = Optional.ofNullable(Compte.builder().codeCompte(codeCompte).type(TypeCompte.EPARGNE).solde(20000.0).dateCreation(date).build());

        Mockito.when(compteRepository.findById(codeCompte)).thenReturn(compteInitial);
        Compte compte = compteService.get(codeCompte);

        MatcherAssert.assertThat(compte, Matchers.hasToString("Compte(codeCompte=1, solde=20000.0, dateCreation=" + date + ", type=EPARGNE)"));
        Mockito.verify(compteRepository).findById(codeCompte);
    }

    @Test
    @DisplayName("Ajouter un compte")
    public void createCarte(){
        Compte compteInitial = Compte.builder().type(TypeCompte.COURANT).solde(20000.00).dateCreation(date).build();
        Compte compteFinal = Compte.builder().codeCompte((long) 1).type(TypeCompte.COURANT).solde(20000.00).dateCreation(date).build();

        Mockito.when(compteRepository.save(compteInitial)).thenReturn(compteFinal);
        Compte compte = compteService.create(compteInitial);

        MatcherAssert.assertThat(compte.getCodeCompte(), Matchers.equalTo(compteFinal.getCodeCompte()));
        Mockito.verify(compteRepository).save(compteInitial);

    }

    @Test
    @DisplayName("Modifier un compte")
    public void updateCarte(){


        Compte compteInitial = Compte.builder().codeCompte((long) 1).type(TypeCompte.EPARGNE).solde(2008444800.00).dateCreation(date).build();

        Mockito.when(compteRepository.save(compteInitial)).thenReturn(compteInitial);
        Compte compte = compteService.update(compteInitial);

        MatcherAssert.assertThat(compte.getCodeCompte(), Matchers.equalTo(compteInitial.getCodeCompte()));
        Mockito.verify(compteRepository).save(compteInitial);
    }

    @Test
    @DisplayName("Supprimer une compte")
    public void deteleCarte(){

        Long deleteId = 1L;
        Mockito.doNothing().when(compteRepository).deleteById(deleteId);
        compteService.delete(deleteId);
        Mockito.verify(compteRepository).deleteById(deleteId);
    }

}
