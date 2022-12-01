package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Produkt {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nazwa;

        @Enumerated(value = EnumType.STRING)
        private Kategoria kategoria;


        @ToString.Exclude
        @EqualsAndHashCode.Exclude
        @OneToMany(mappedBy = "produkcik")
        private Set<Sprzedaz> sprzedaze;

}
