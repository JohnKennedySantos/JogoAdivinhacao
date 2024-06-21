package org.example.view;

import org.example.controller.LoginController;
import org.example.dto.UserDto;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    private Janela parent;
    private JTextField emailField;
    private JPasswordField passwordField;

    public LoginPanel(Janela parent) {
        this.parent = parent;

        setLayout(new GridLayout(3, 2));

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> login());
        add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(e -> parent.showCard("register"));
        add(registerButton);
    }

    private void login() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        UserDto user = LoginController.authenticate(email, password);
        if (user != null) {
            JOptionPane.showMessageDialog(this, "Login Successful!");
            parent.startGame(user.getName());
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials.");
        }
    }
}
