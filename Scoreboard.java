import javax.swing.*;
import java.awt.*;

public class Scoreboard extends JPanel {
    private int playerXWins = 0;
    private int playerYWins = 0;

    private JLabel playerXLabel;
    private JLabel playerYLabel;

    public Scoreboard() {
        setLayout(new GridLayout(2, 1));

        playerXLabel = new JLabel("Player X wins: 0");
        add(playerXLabel);

        playerYLabel = new JLabel("Player Y wins: 0");
        add(playerYLabel);
    }

    public void updateScore(char player) {
        if (player == 'X') {
            playerXWins++;
            playerXLabel.setText("Player X wins: " + playerXWins);
        } else if (player == 'Y') {
            playerYWins++;
            playerYLabel.setText("Player Y wins: " + playerYWins);
        }
    }

    public int getPlayerXWins() {
        return playerXWins;
    }

    public int getPlayerYWins() {
        return playerYWins;
    }
}