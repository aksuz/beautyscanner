package edu.tul.beautyscanner.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producer")
    private Long id;

    @Column(name = "producer_name", nullable = false)
    private String name;

//    @Column(name = "id_country", nullable = false)
    @ManyToOne
    private Country countryId;

    @OneToMany(mappedBy = "producer")
    private List<Product> products;
}
