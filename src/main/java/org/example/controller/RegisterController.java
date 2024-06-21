package org.example.controller;


import org.example.model.User;

public class RegisterController {
    public static boolean register(String name, String email, String password) {
        return User.register(name, email, password);
    }
}