package edu.tul.beautyscanner.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @Column(nullable = false)
    private String nick;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @ColumnDefault("'USER'")
    @Enumerated(EnumType.STRING)
    private Role role;

//    @ManyToMany
//    @JoinTable(name = "user_allergens")
//    private List<Ingredient> allergens;
//
//    @ManyToMany
//    @JoinTable(name = "user_my_product")
//    private List<MyProduct> myProducts;


}
