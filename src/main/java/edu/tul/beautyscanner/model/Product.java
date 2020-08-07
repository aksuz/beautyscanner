package edu.tul.beautyscanner.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long id;

    @Column(nullable = false)
    private String barcode;

    @Column(nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Producer producer;

    private String description;

    @ManyToOne
    private Category category;

//    @Column(name = "ingredient_list")
    @ManyToMany
    @JoinTable(name = "product_ingredient")
    private List<Ingredient> ingredients;

    private String url;
    private String picture;
    private double rating;


}