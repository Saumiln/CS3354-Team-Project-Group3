import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CalorieEntryPage {
    private JFrame frame;
    private Dashboard dashboard;

    public CalorieEntryPage(Dashboard dashboard) {
        this.dashboard = dashboard;

        frame = new JFrame("Calorie Entry");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        centerFrame(frame);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Placeholder for logo
        JLabel logoLabel = new JLabel("Your Logo");
        logoLabel.setBounds(10, 10, 100, 50);
        panel.add(logoLabel);

        JLabel promptLabel = new JLabel("Enter Daily Calories:");
        promptLabel.setBounds(10, 80, 150, 25);
        panel.add(promptLabel);

        JTextField caloriesField = new JTextField(20);
        caloriesField.setBounds(160, 80, 100, 25);
        panel.add(caloriesField);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(10, 110, 80, 25);
        panel.add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int enteredCalories = Integer.parseInt(caloriesField.getText());
                // Update the dashboard with the entered calories
                dashboard.updateCalories(enteredCalories);
                frame.dispose(); // Close the calorie entry page
            }
        });
    }

    private void centerFrame(JFrame frame) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - frame.getWidth()) / 2;
        int y = (dim.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
    }
}