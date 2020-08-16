package edu.tul.beautyscanner.repository;

import edu.tul.beautyscanner.model.User;
import edu.tul.beautyscanner.model.UserAllergen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAllergenRepository extends JpaRepository<UserAllergen, Long> {

    @Query("SELECT p FROM UserAllergen p WHERE p.user = :user")
    UserAllergen findAllergensByUser(User user);
}
