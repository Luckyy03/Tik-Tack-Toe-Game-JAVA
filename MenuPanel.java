import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {
    public MenuPanel(GameFrame frame) {
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);

        JButton playButton = new JButton("Play");
        playButton.setPreferredSize(new Dimension(300,120));
        playButton.addActionListener(e -> frame.startGame());
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        add(playButton, gbc);
        
       JButton settingsButton = new JButton("Settings");
        
        settingsButton.setPreferredSize(new Dimension(300,120));
        settingsButton.addActionListener(e ->{
    JFrame settingsFrame = new JFrame("Settings");
    settingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    settingsFrame.add(new SettingsPanel());
    settingsFrame.pack();
    settingsFrame.setVisible(true);
     });
gbc.gridy = 1;
add(settingsButton, gbc);
        JButton helpButton = new JButton("Help");
helpButton.setPreferredSize(new Dimension(300,120));
helpButton.addActionListener(e -> {
    JFrame helpFrame = new JFrame("Help");
    helpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    helpFrame.add(new HelpPanel());
    helpFrame.pack();
    helpFrame.setVisible(true);
});
gbc.gridy = 2;
add(helpButton, gbc);

        JButton quitButton = new JButton("Quit");
        quitButton.setPreferredSize(new Dimension(300,120));
        quitButton.addActionListener(e -> System.exit(0));
        gbc.gridy = 3;
        add(quitButton, gbc);
    }
}
