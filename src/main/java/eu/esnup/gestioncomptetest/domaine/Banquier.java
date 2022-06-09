package eu.esnup.gestioncomptetest.domaine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Banquier {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeBanquier;
    private String nom;
    private String prenom;

    @OneToMany(mappedBy = "codeClient")
    private Set<Client> clients;

}
