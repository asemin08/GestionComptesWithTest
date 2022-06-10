package eu.esnup.gestioncomptetest.repository;

import eu.esnup.gestioncomptetest.domaine.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * The interface Compte repository.
 */
@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long> {

}
