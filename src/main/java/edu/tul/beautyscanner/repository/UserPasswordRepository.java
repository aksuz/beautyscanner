package edu.tul.beautyscanner.repository;

import edu.tul.beautyscanner.model.User;
import edu.tul.beautyscanner.model.UserPassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserPasswordRepository extends JpaRepository<UserPassword, Long> {

    UserPassword findByUser(User user);

    @Query("SELECT p FROM UserPassword p WHERE p.user.nick = :nick AND p.password = :password")
    Optional<UserPassword> findByUserNickAndPassword(String nick, String password);
}
