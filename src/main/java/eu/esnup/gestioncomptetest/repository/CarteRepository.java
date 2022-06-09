package eu.esnup.gestioncomptetest.repository;

import eu.esnup.gestioncomptetest.domaine.Carte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteRepository  extends JpaRepository<Carte, Long> {
}
