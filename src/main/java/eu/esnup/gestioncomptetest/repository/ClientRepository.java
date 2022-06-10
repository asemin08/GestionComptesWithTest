package eu.esnup.gestioncomptetest.repository;

import eu.esnup.gestioncomptetest.domaine.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Client repository.
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

}
