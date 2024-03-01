import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class frame extends JFrame implements ActionListener {
    private JLabel imageLabel;
    private ButtonGroup buttonGroup;
    private JPanel radioPanel;
    private String lastSelectedAnimal;

    public frame() {
        setTitle("Animal Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
        radioPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        buttonGroup = new ButtonGroup();
        addRadioButton("Bird", radioPanel);
        addRadioButton("Cat", radioPanel);
        addRadioButton("Dog", radioPanel);
        addRadioButton("Rabbit", radioPanel);
        addRadioButton("Pig", radioPanel);

        add(radioPanel, BorderLayout.WEST);

        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(200, 200));
        imageLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(imageLabel, BorderLayout.CENTER);

        setSize(500, 400);
        setResizable(false);
        setVisible(true);
    }

    private void addRadioButton(String text, JPanel panel) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setActionCommand(text.toLowerCase());
        radioButton.addActionListener(this);
        buttonGroup.add(radioButton);
        panel.add(radioButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (lastSelectedAnimal != null) {
            ImageIcon emptyIcon = new ImageIcon();
            buttonGroup.getSelection().getActionCommand();
            lastSelectedAnimal = command;
        }
        ImageIcon icon = new ImageIcon(getClass().getResource(command + ".jpg"));
        imageLabel.setIcon(icon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new frame());
    }
}

