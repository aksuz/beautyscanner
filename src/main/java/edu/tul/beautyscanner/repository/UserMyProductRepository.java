package edu.tul.beautyscanner.repository;

import edu.tul.beautyscanner.model.User;
import edu.tul.beautyscanner.model.UserMyProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMyProductRepository extends JpaRepository<UserMyProduct, Long> {

    UserMyProduct findByUser(User user);
}
