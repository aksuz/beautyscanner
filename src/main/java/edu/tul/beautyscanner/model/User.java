package edu.tul.beautyscanner.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private long id;

    @Column(nullable = false)
    private String nick;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @ColumnDefault("'USER'")
    @Enumerated(EnumType.STRING)
    private Role role;

//    @Column(name = "allergen_list")
    @ManyToMany
    @JoinTable(name = "user_allergens")
    private List<Ingredient> allergens;

//    @Column(name = "my_product_list")
    @ManyToMany
    @JoinTable(name = "user_my_product")
    private List<MyProduct> myProducts;


}
