package edu.tul.beautyscanner.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Builder
public class MyProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_myproduct")
    private Long id;

//    @Column(name = "id_product", nullable = false)
    @ManyToOne
    private Product productId;

    private LocalDate openingDate;
    private int expirationTime;
    private int productRating;
}
