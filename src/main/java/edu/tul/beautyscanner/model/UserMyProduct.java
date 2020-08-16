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
@Table(name = "user_products")
public class UserMyProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_products")
    private Long id;

    @ManyToMany
    @JoinTable(name = "user_myproducts",
    joinColumns={@JoinColumn(name = "user_id", referencedColumnName = "id_user_products")},
    inverseJoinColumns = {@JoinColumn(name = "my_product_id", referencedColumnName = "id_myproduct")})
    private List<MyProduct> myProducts;

    @OneToOne
    private User user;
}
