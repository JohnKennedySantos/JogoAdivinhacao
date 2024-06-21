

import org.example.view.Janela;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Janela janela = new Janela();
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janela.setSize(400, 300);
                janela.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao iniciar a aplicação.");
            }
        });
    }
}
