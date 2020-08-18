package edu.tul.beautyscanner.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRegistration {
    private String nick;
    private String email;
    private String password;
}
