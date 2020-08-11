package edu.tul.beautyscanner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAllergen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_allergen")
    private Long id;

    @ManyToMany
    @JoinTable(name = "user_allergens")
    private List<Ingredient> allergens;

    @OneToOne
    private User user;
}
