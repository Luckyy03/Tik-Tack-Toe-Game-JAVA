import javax.swing.*;
import java.awt.*;

public class HelpPanel extends JPanel {

    public HelpPanel() {
        setLayout(new BorderLayout());

        JLabel helpLabel = new JLabel("Help");
        helpLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(helpLabel, BorderLayout.NORTH);

        JTextArea helpText = new JTextArea();
        helpText.setEditable(false);
        helpText.setLineWrap(true);
        helpText.setWrapStyleWord(true);
        helpText.setFont(new Font("Arial", Font.PLAIN, 18));

        String helpMessage = "Welcome to our game!\n\n"
                + "Here are some guidelines to get you started:\n\n"
                + "1. To play the game, simply click on the buttons to perform actions.\n"
                + "2. You can access the settings by clicking on the 'Settings' button.\n"
                + "3. If you need help or have any questions, click on the 'Help' button.\n\n"
                + "Good luck and have fun!";
        helpText.setText(helpMessage);

        JScrollPane scrollPane = new JScrollPane(helpText);
        add(scrollPane, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            frame.dispose();
        });
        add(closeButton, BorderLayout.SOUTH);
    }
}