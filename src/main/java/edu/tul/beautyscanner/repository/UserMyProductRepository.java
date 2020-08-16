package edu.tul.beautyscanner.repository;

import edu.tul.beautyscanner.model.User;
import edu.tul.beautyscanner.model.UserMyProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserMyProductRepository extends JpaRepository<UserMyProduct, Long> {

    @Query("SELECT p FROM UserMyProduct p WHERE p.user = :user")
    UserMyProduct findProductsByUser(User user);
}
