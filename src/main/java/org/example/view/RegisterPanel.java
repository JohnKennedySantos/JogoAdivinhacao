package org.example.view;


import org.example.controller.RegisterController;

import javax.swing.*;
import java.awt.*;

public class RegisterPanel extends JPanel {
    private Janela parent;
    private JTextField nameField, emailField;
    private JPasswordField passwordField;

    public RegisterPanel(Janela parent) {
        this.parent = parent;

        setLayout(new GridLayout(4, 2));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(e -> register());
        add(registerButton);
    }

    private void register() {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        if (RegisterController.register(name, email, password)) {
            JOptionPane.showMessageDialog(this, "Registration Successful!");
            parent.showCard("login");
        } else {
            JOptionPane.showMessageDialog(this, "Registration Failed.");
        }
    }
}