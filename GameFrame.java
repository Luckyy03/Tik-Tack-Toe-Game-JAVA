import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    CardLayout cardLayout;
    JPanel mainPanel;
    MenuPanel menuPanel;
    GamePanel gamePanel;

    public GameFrame() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        menuPanel = new MenuPanel(this);
        gamePanel = new GamePanel(this);

        mainPanel.add(menuPanel, "Menu");
        mainPanel.add(gamePanel, "Game");

        add(mainPanel);

        setTitle("Tic-Tac-Toe");
        setSize(600, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void showMenu() {
        cardLayout.show(mainPanel, "Menu");
    }

    public void startGame() {
        gamePanel.startGame();
        cardLayout.show(mainPanel, "Game");
    }
}
