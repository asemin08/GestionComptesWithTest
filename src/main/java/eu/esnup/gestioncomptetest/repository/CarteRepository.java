package eu.esnup.gestioncomptetest.repository;

import eu.esnup.gestioncomptetest.entities.Carte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteRepository  extends JpaRepository<Carte, Long> {
}
