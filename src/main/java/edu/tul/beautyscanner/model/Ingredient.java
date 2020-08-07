package edu.tul.beautyscanner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingredient")
    private Long id;

    @Column(name = "ingredient_name", nullable = false)
    private String name;

    private String url;

    @Column(columnDefinition = "boolean default false")
    private boolean isAllergen;

    @Column(columnDefinition = "boolean default false")
    private boolean isIrritant;

    @Column(columnDefinition = "boolean default false")
    private boolean isNatural;

    @Column(columnDefinition = "boolean default false")
    private boolean isForbiddenDuringPregnancy;

    @Column(columnDefinition = "boolean default false")
    private boolean isComedogenic;

    @Column(columnDefinition = "boolean default false")
    private boolean isCarcinogenic;

    public Ingredient(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
