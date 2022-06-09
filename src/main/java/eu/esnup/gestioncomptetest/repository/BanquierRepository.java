package eu.esnup.gestioncomptetest.repository;

import eu.esnup.gestioncomptetest.domaine.Banquier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BanquierRepository extends JpaRepository<Banquier, Long> {
}
