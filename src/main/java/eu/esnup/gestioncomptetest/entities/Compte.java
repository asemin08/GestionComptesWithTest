package eu.esnup.gestioncomptetest.entities;

import eu.esnup.gestioncomptetest.enums.TypeCompte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeCompte;
    private double solde;
    private Date dateCreation;

    @Enumerated(EnumType.STRING)
    private TypeCompte type;

}
