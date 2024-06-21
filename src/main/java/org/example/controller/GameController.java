package org.example.controller;

import org.example.model.GameHistory;

public class GameController {
    private int numeroSecreto;
    private int tentativas;
    private int acertos;
    private int misses;
    private String nomeUsuario;

    public GameController(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
        resetGame();
    }

    public String checkGuess(int guess) {
        tentativas++;
        if (guess == numeroSecreto) {
            acertos++;
            GameHistory.saveGameHistory(new GameHistory(nomeUsuario, tentativas, acertos, misses));
            resetGame();
            return "PARABÉNS, VOCÊ ACERTOU!!!!";
        } else {
            misses++;
            return guess < numeroSecreto ? "Muito baixo!" : "Muito alto!";
        }
    }

    private void resetGame() {
        this.numeroSecreto = (int) (Math.random() * 100 + 1);
        this.tentativas = 0;
        this.acertos = 0;
        this.misses = 0;
    }
}
