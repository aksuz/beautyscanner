package edu.tul.beautyscanner.repository;

import edu.tul.beautyscanner.model.User;
import edu.tul.beautyscanner.model.UserPassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPasswordRepository extends JpaRepository<UserPassword, Long> {

    UserPassword findByUser(User user);
}
