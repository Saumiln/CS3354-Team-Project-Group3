import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Dashboard {
    private JFrame frame;
    private JLabel caloriesLabel;
    private int cals = 0;

    public Dashboard() {
        frame = new JFrame("Dashboard");
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

        caloriesLabel = new JLabel("Daily Calories: " + cals); // You can update this dynamically
        caloriesLabel.setBounds(10, 80, 200, 25);
        panel.add(caloriesLabel);

        JButton enterCaloriesButton = new JButton("Enter Calories");
        enterCaloriesButton.setBounds(10, 110, 150, 25);
        panel.add(enterCaloriesButton);
        
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(175, 110, 150, 25);
        panel.add(logoutButton);

        enterCaloriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current dashboard
                new CalorieEntryPage(Dashboard.this); // Open the calorie entry page
            }
        });
        
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current dashboard
            }
        });
    }

    public void updateCalories(int newCalories) {
        cals += newCalories;
        caloriesLabel.setText("Daily Calories: " + cals);
        frame.setVisible(true);
    }

    private void centerFrame(JFrame frame) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - frame.getWidth()) / 2;
        int y = (dim.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
    }
}