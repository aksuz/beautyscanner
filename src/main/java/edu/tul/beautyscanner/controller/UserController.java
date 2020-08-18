package edu.tul.beautyscanner.controller;

import edu.tul.beautyscanner.model.*;
import edu.tul.beautyscanner.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserRepository userRepository;
    private MyProductRepository myProductRepository;
    private UserPasswordRepository userPasswordRepository;
    private UserMyProductRepository userMyProductRepository;
    private UserAllergenRepository userAllergenRepository;

    @Autowired
    public UserController(UserRepository userRepository,
                          MyProductRepository myProductRepository,
                          UserPasswordRepository userPasswordRepository,
                          UserMyProductRepository userMyProductRepository,
                          UserAllergenRepository userAllergenRepository) {
        this.userRepository = userRepository;
        this.myProductRepository = myProductRepository;
        this.userPasswordRepository = userPasswordRepository;
        this.userMyProductRepository = userMyProductRepository;
        this.userAllergenRepository = userAllergenRepository;
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
            return new ResponseEntity<>("Delete successful of userID: " + userId, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updatePassword/{userId}")
    public ResponseEntity<UserPassword> updatePassword(@PathVariable("userId") Long userId, @RequestBody String userPassword) {
        Optional<User> userData = userRepository.findById(userId);

        if (userData.isPresent()) {
            UserPassword userPasswordData = userPasswordRepository.findByUser(userData.get());
            String password = userPassword.substring(1, userPassword.length()-1);
            userPasswordData.setPassword(password);
            return new ResponseEntity<>(userPasswordRepository.save(userPasswordData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/userProducts")
    public ResponseEntity<List<MyProduct>> getMyProductUserById(@PathVariable("id") Long id) {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            UserMyProduct userMyProduct = userMyProductRepository.findProductsByUser(userData.get());

            return new ResponseEntity<>(userMyProduct.getMyProducts(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/userAllergens")
    public ResponseEntity<List<Ingredient>> getAllergenUserById(@PathVariable("id") Long id) {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            UserAllergen userAllergen = userAllergenRepository.findAllergensByUser(userData.get());
            return new ResponseEntity<>(userAllergen.getAllergens(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/login/{nick}/{password}")
    public ResponseEntity<User> loginUser(@PathVariable("nick") String nick, @PathVariable("password") String password) {
        Optional<UserPassword> userPasswordData = userPasswordRepository.findByUserNickAndPassword(nick, password);
        if (userPasswordData.isPresent()) {
            return new ResponseEntity<>(userPasswordData.get().getUser(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUserAccount(@RequestBody UserRegistration userRegistration) {
        try {
            User newUser = User.builder()
                    .nick(userRegistration.getNick())
                    .email(userRegistration.getEmail())
                    .role(Role.USER).build();
            userRepository.save(newUser);
            UserPassword newUserPassword = UserPassword.builder()
                    .user(newUser)
                    .password(userRegistration.getPassword())
                    .build();
            userPasswordRepository.save(newUserPassword);
            System.out.println("yeah");
            return new ResponseEntity<>(newUser, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    //todo
    //dodawanie/usuwanie allergenow
    //dodawanie/usuwanie produktow (myproduct)
    //update produktow (myproduct)
    //wswietl wszytskie z kategorii
}
