import javax.swing.JButton;

public class WinnerCheck {

    public static boolean checkWinner(JButton[][] board) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2]) ||
                    checkRowCol(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }

        // Check diagonals
        if (checkRowCol(board[0][0], board[1][1], board[2][2]) ||
                checkRowCol(board[0][2], board[1][1], board[2][0])) {
            return true;
        }

        return false;
    }

    private static boolean checkRowCol(JButton b1, JButton b2, JButton b3) {
        return !b1.getText().isEmpty() && b1.getText().equals(b2.getText()) && b2.getText().equals(b3.getText());
    }
}
