package eu.esnup.gestioncomptetest.services;

import eu.esnup.gestioncomptetest.domaine.Carte;
import eu.esnup.gestioncomptetest.enums.TypeCarte;
import eu.esnup.gestioncomptetest.repository.CarteRepository;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CarteServiceTest {

    @Mock
    private CarteRepository carteRepository;

    @InjectMocks
    private CarteService carteService;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Recupéres toutes les cartes")
    public void getAllCartes(){
        List<Carte> carteList = new ArrayList<>();
        carteList.add(Carte.builder().codeCarte((long) 1).typeCarte(TypeCarte.JEUNE).build());
        carteList.add(Carte.builder().codeCarte((long) 2).typeCarte(TypeCarte.CLASSIQUE).build());
        carteList.add(Carte.builder().codeCarte((long) 3).typeCarte(TypeCarte.PRENIUM).build());

        int carteListSize = 3;

        Mockito.when(carteRepository.findAll()).thenReturn(carteList);

        List<Carte> cartes = carteService.getAll();
        MatcherAssert.assertThat(cartes.size(), Matchers.equalTo(carteListSize));
        Mockito.verify(carteRepository).findAll();
    }

    @Test
    @DisplayName("Recupéres une cartes")
    public void getCarte(){

        Long codeCarte = 1L;

        Optional<Carte> carteInitial = Optional.ofNullable(Carte.builder().codeCarte(codeCarte).typeCarte(TypeCarte.CLASSIQUE).build());

        Mockito.when(carteRepository.findById(codeCarte)).thenReturn(carteInitial);
        Optional<Carte> carte = carteService.get(codeCarte);

        MatcherAssert.assertThat(carte.get().getTypeCarte(), Matchers.hasToString("CLASSIQUE"));
        Mockito.verify(carteRepository).findById(codeCarte);
    }

    @Test
    @DisplayName("Ajouter une cartes")
    public void createCarte(){
        Carte carteInitial = Carte.builder().typeCarte(TypeCarte.PRENIUM).build();
        Carte carteFinal = Carte.builder().codeCarte((long) 1).typeCarte(TypeCarte.PRENIUM).build();

        Mockito.when(carteRepository.save(carteInitial)).thenReturn(carteFinal);
        Carte carte = carteService.create(carteInitial);

        MatcherAssert.assertThat(carte.getCodeCarte(), Matchers.equalTo(carteFinal.getCodeCarte()));
        Mockito.verify(carteRepository).save(carteInitial);

    }

    @Test
    @DisplayName("Modifier une carte")
    public void updateCarte(){


        Carte carteInitial = Carte.builder().codeCarte(1L).typeCarte(TypeCarte.PRENIUM).build();

        Mockito.when(carteRepository.save(carteInitial)).thenReturn(carteInitial);
        Carte carte = carteService.update(carteInitial);

        MatcherAssert.assertThat(carte.getCodeCarte(), Matchers.equalTo(carteInitial.getCodeCarte()));
        Mockito.verify(carteRepository).save(carteInitial);
    }

    @Test
    @DisplayName("Supprimer une carte")
    public void deteleCarte(){

        Long deleteId = 1L;
        Mockito.doNothing().when(carteRepository).deleteById(deleteId);
        carteService.delete(deleteId);
        Mockito.verify(carteRepository).deleteById(deleteId);
    }

}
