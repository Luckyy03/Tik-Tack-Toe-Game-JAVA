import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel {
    private GamePanel gamePanel;
    private JLabel textLabel;
    private JButton[][] board;
    private String playerX = "X";
    private String playerO = "O";
    private String currentPlayer;
    private boolean gameOver;
    private int turns;

    public Board(GamePanel gamePanel, JLabel textLabel) {
        this.gamePanel = gamePanel;
        this.textLabel = textLabel;
        setLayout(new GridLayout(3, 3));
        setBackground(Color.darkGray);

        board = new JButton[3][3];
        currentPlayer = playerX;
        gameOver = false;
        turns = 0;

        initializeBoard();
    }

    private void initializeBoard() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                JButton tile = new JButton();
                board[r][c] = tile;
                add(tile);

                tile.setBackground(Color.darkGray);
                tile.setForeground(Color.white);
                tile.setFont(new Font("Arial", Font.BOLD, 120));
                tile.setFocusable(false);

                tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (gameOver) return;
                        JButton tile = (JButton) e.getSource();
                        if (tile.getText().isEmpty()) {
                            tile.setText(currentPlayer);
                            turns++;
                            checkWinner();
                            if (!gameOver) {
                                currentPlayer = currentPlayer.equals(playerX) ? playerO : playerX;
                                textLabel.setText(currentPlayer + "'s turn.");
                            }
                        }
                    }
                });
            }
        }
    }

    void checkWinner() {
        if (WinnerCheck.checkWinner(board)) {
            textLabel.setText(currentPlayer + " is the winner!");
            gameOver = true;
            return;
        }

        if (turns == 9) {
            textLabel.setText("Tie!");
            gameOver = true;
        }
    }

    public void resetBoard() {
        currentPlayer = playerX;
        gameOver = false;
        turns = 0;
        textLabel.setText("Tic-Tac-Toe");
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c].setText("");
                board[r][c].setBackground(Color.darkGray);
                board[r][c].setForeground(Color.white);
            }
        }
    }
}
