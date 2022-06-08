package eu.esnup.gestioncomptetest;

import eu.esnup.gestioncomptetest.entities.Banquier;
import eu.esnup.gestioncomptetest.entities.Compte;
import eu.esnup.gestioncomptetest.enums.TypeCompte;
import eu.esnup.gestioncomptetest.repository.BanquierRepository;
import eu.esnup.gestioncomptetest.repository.CarteRepository;
import eu.esnup.gestioncomptetest.repository.ClientRepository;
import eu.esnup.gestioncomptetest.repository.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class GestionCompteTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionCompteTestApplication.class, args);
    }

}
