package org.example.view;

import javax.swing.*;
import java.awt.*;

public class Janela extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private String userName;

    public Janela() {
        super("Guessing Game");
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        LoginPanel loginPanel = new LoginPanel(this);
        RegisterPanel registerPanel = new RegisterPanel(this);

        mainPanel.add(registerPanel, "register");
        mainPanel.add(loginPanel, "login");

        add(mainPanel);
        cardLayout.show(mainPanel, "login");
    }

    public void showCard(String card) {
        cardLayout.show(mainPanel, card);
    }

    public void startGame(String userName) {
        this.userName = userName;
        GamePanel gamePanel = new GamePanel(this, userName);
        mainPanel.add(gamePanel, "game");
        showCard("game");
    }
}
