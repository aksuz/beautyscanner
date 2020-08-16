package edu.tul.beautyscanner.controller;

import edu.tul.beautyscanner.model.User;
import edu.tul.beautyscanner.model.UserMyProduct;
import edu.tul.beautyscanner.model.UserPassword;
import edu.tul.beautyscanner.repository.MyProductRepository;
import edu.tul.beautyscanner.repository.UserMyProductRepository;
import edu.tul.beautyscanner.repository.UserPasswordRepository;
import edu.tul.beautyscanner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserRepository userRepository;
    private MyProductRepository myProductRepository;
    private UserPasswordRepository userPasswordRepository;
    private UserMyProductRepository userMyProductRepository;

    @Autowired
    public UserController(UserRepository userRepository,
                          MyProductRepository myProductRepository,
                          UserPasswordRepository userPasswordRepository,
                          UserMyProductRepository userMyProductRepository) {
        this.userRepository = userRepository;
        this.myProductRepository = myProductRepository;
        this.userPasswordRepository = userPasswordRepository;
        this.userMyProductRepository = userMyProductRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") Long userId, @RequestBody User user) {
        Optional<User> userData = userRepository.findById(userId);

        if (userData.isPresent()) {
            User u = userData.get();
            u.setNick(user.getNick());
            u.setEmail(user.getEmail());
            return new ResponseEntity<>(userRepository.save(u), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable("userId") Long userId) {
        try {
            userRepository.deleteById(userId);
            return new ResponseEntity<>("Delete successful of userID: "+userId, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updatePassword/{userId}")
    public ResponseEntity<UserPassword> updatePassword(@PathVariable("userId") Long userId, @RequestBody UserPassword userPassword) {
        Optional<User> userData = userRepository.findById(userId);

        if (userData.isPresent()) {
            UserPassword userPasswordData = userPasswordRepository.findByUser(userData.get());
            userPasswordData.setPassword(userPassword.getPassword());
            return new ResponseEntity<>(userPasswordRepository.save(userPasswordData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/userProducts")
    public ResponseEntity<UserMyProduct> getMyProductUserById(@PathVariable("id") Long id) {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            UserMyProduct userMyProduct = userMyProductRepository.findByUserId(userData.get().getId());
            return new ResponseEntity<>(userMyProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    //todo
    //pobieranie allergenow
    //dodawanie/usuwanie allergenow
    //pobieranie produktow (myproduct)
    //dodawanie/usuwanie produktow (myproduct)
    //update produktow (myproduct)
    //wswietl wszytskie z kategorii
}
