import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private GameFrame frame;
    private Board board;
    private Scoreboard scoreboard;

    public GamePanel(GameFrame frame) {
        this.frame = frame;
        setLayout(new BorderLayout());

        JLabel textLabel = new JLabel("Tic-Tac-Toe", JLabel.CENTER);
        textLabel.setBackground(Color.darkGray);
        textLabel.setForeground(Color.white);
        textLabel.setFont(new Font("Arial", Font.BOLD, 50));
        textLabel.setOpaque(true);

        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.add(textLabel, BorderLayout.CENTER);
        add(textPanel, BorderLayout.NORTH);

        board = new Board(this, textLabel);
        add(board, BorderLayout.CENTER);

        scoreboard = new Scoreboard();
        add(scoreboard, BorderLayout.SOUTH);
    }

    public void startGame() {
        board.resetBoard();
    }
}

