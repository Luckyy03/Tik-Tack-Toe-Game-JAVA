import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsPanel extends JPanel {
    private JCheckBox soundCheckBox;
    private ButtonGroup colorButtonGroup;

    public SettingsPanel() {
        setLayout(new GridLayout(2, 1));

        JPanel soundPanel = new JPanel();
        soundCheckBox = new JCheckBox("Sound");
        soundCheckBox.setSelected(true);
        soundPanel.add(soundCheckBox);

        JPanel colorPanel = new JPanel();
        colorButtonGroup = new ButtonGroup();

        JRadioButton redRadioButton = new JRadioButton("Red");
        redRadioButton.setSelected(true);
        colorButtonGroup.add(redRadioButton);
        colorPanel.add(redRadioButton);

        JRadioButton blueRadioButton = new JRadioButton("Blue");
        colorButtonGroup.add(blueRadioButton);
        colorPanel.add(blueRadioButton);

        JRadioButton greenRadioButton = new JRadioButton("Green");
        colorButtonGroup.add(greenRadioButton);
        colorPanel.add(greenRadioButton);

        add(soundPanel);
        add(colorPanel);
    }

    public boolean isSoundOn() {
        return soundCheckBox.isSelected();
    }

    public String getColor() {
        if (colorButtonGroup.getSelection() != null) {
            return colorButtonGroup.getSelection().getActionCommand();
        } else {
            return "Red";
        }
    }

    public void saveSettings() {
        // Save the settings to a file or database
        // For this example, we'll just print the settings
        System.out.println("Sound: " + (isSoundOn() ? "On" : "Off"));
        System.out.println("Color: " + getColor());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Settings");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SettingsPanel());
        frame.pack();
        frame.setVisible(true);
    }
}