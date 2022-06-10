package eu.esnup.gestioncomptetest.domaine;

import eu.esnup.gestioncomptetest.enums.TypeCarte;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * The type Carte.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Carte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeCarte;

    @Enumerated(EnumType.STRING)
    private TypeCarte typeCarte;
}
