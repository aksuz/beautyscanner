package edu.tul.beautyscanner.repository;

import edu.tul.beautyscanner.model.MyProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyProductRepository extends JpaRepository<MyProduct, Long> {
}
