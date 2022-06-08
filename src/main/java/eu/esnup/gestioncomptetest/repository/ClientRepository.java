package eu.esnup.gestioncomptetest.repository;

import eu.esnup.gestioncomptetest.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
