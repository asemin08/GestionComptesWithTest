package eu.esnup.gestioncomptetest.repository;

import eu.esnup.gestioncomptetest.domaine.Banquier;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Banquier repository.
 */
public interface BanquierRepository extends JpaRepository<Banquier, Long> {
}
