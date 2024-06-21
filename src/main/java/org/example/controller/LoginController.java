package org.example.controller;


import org.example.dto.UserDto;
import org.example.model.User;

public class LoginController {
    public static UserDto authenticate(String email, String password) {
        return User.authenticate(email, password);
    }
}
