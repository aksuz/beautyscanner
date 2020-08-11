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
public class UserMyProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_myproduct")
    private Long id;

    @ManyToMany
    @JoinTable(name = "user_myproducts")
    private List<MyProduct> myProducts;

    @OneToOne
    private User user;
}
