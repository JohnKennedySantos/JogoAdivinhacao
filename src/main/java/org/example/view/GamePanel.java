package org.example.view;

import org.example.controller.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    private Janela parent;
    private JTextField guessField;
    private JLabel feedbackLabel;
    private GameController gameController;

    public GamePanel(Janela parent, String userName) {
        this.parent = parent;
        this.gameController = new GameController(userName);

        setLayout(new GridLayout(4, 2));

        add(new JLabel("Adivinhe o número:"));
        guessField = new JTextField();
        add(guessField);

        JButton guessButton = new JButton("Adivinhar");
        guessButton.addActionListener(new GuessListener());
        add(guessButton);

        feedbackLabel = new JLabel("Entre com um número entre 1 e 100.");
        add(feedbackLabel);

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(new BackListener());
        add(backButton);
    }

    private class GuessListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int guess = Integer.parseInt(guessField.getText());
                String feedback = gameController.checkGuess(guess);
                feedbackLabel.setText(feedback);
            } catch (NumberFormatException ex) {
                feedbackLabel.setText("Por favor, insira um número válido.");
            }
        }
    }

    private class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            parent.showCard("login");
        }
    }
}
