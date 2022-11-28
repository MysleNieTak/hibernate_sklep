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
        private String kategoria;


        @ToString.Exclude
        @EqualsAndHashCode.Exclude
        @OneToMany(mappedBy = "produkcik")
        private Set<Sprzedaz> sprzedaze;


}
