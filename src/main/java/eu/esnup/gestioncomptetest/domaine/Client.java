package eu.esnup.gestioncomptetest.domaine;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * The type Client.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeClient;
    private String nom;
    private String prenom;

    @OneToMany
    private Set<Compte> comptes;

    @OneToOne
    private Carte carte;

}
