package eu.esnup.gestioncomptetest.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Banquier {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeBanquier;
    private String nom;
    private String prenom;

    @OneToMany
    private Set<Client> clients;

}
