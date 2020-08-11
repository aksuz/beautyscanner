package edu.tul.beautyscanner.repository;

import edu.tul.beautyscanner.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByBarcode(String barcode);

    @Query("SELECT p FROM Product p WHERE p.category.name = :categoryName")
//    @Query("SELECT p FROM Product p JOIN Category c WHERE c.name = :categoryName")
    List<Product> findAllByCategory(String categoryName);
}
