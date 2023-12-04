import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Dashboard {
    private JFrame frame;
    private JLabel caloriesLabel;
    private JLabel userLabel;
    private JLabel tcaloriesLabel;
    private User user;

    public Dashboard(User user) {
        this.user = user;
        frame = new JFrame("Dashboard - " + user.getUsername());
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
        
        ImageIcon logoIcon = new ImageIcon("v147_81.png");
        Image logoImage = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon scaledLogoIcon = new ImageIcon(logoImage);

        JLabel logoLabel = new JLabel(scaledLogoIcon);
        logoLabel.setBounds(10, 10, 100, 100);
        panel.add(logoLabel);

        userLabel = new JLabel("Logged in as: " + user.getUsername());
        userLabel.setBounds(10, 110, 200, 25);
        panel.add(userLabel);

        caloriesLabel = new JLabel("Breakfast Calories: " + user.getBCals() + " Lunch Calories: " + user.getLCals() + " Dinner Calories: " + user.getDCals());
        caloriesLabel.setBounds(10, 140, 800, 25);
        panel.add(caloriesLabel);
        
        tcaloriesLabel = new JLabel("Total Calories: " + (user.getBCals() + user.getLCals() + user.getDCals()));
        tcaloriesLabel.setBounds(10, 170, 800, 25);
        panel.add(tcaloriesLabel);

        JButton enterCaloriesButton = new JButton("Enter Calories");
        enterCaloriesButton.setBounds(10, 200, 150, 25);
        panel.add(enterCaloriesButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(175, 200, 150, 25);
        panel.add(logoutButton);

        enterCaloriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current dashboard
                new ChooseMeal(Dashboard.this); // Open the calorie entry page
            }
        });
        
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the current dashboard
            }
        });
    }

    public void updateBCalories(int newCalories) {
        user.addBCals(newCalories);
        caloriesLabel.setText("Breakfast Calories: " + user.getBCals() + " Lunch Calories: " + user.getLCals() + " Dinner Calories: " + user.getDCals());
        tcaloriesLabel.setText("Total Calories: " + (user.getBCals() + user.getLCals() + user.getDCals()));
        frame.setVisible(true);
    }
    
    public void updateLCalories(int newCalories) {
        user.addLCals(newCalories);
        caloriesLabel.setText("Breakfast Calories: " + user.getBCals() + " Lunch Calories: " + user.getLCals() + " Dinner Calories: " + user.getDCals());
        tcaloriesLabel.setText("Total Calories: " + (user.getBCals() + user.getLCals() + user.getDCals()));
        frame.setVisible(true);
    }

    public void updateDCalories(int newCalories) {
        user.addDCals(newCalories);
        caloriesLabel.setText("Breakfast Calories: " + user.getBCals() + " Lunch Calories: " + user.getLCals() + " Dinner Calories: " + user.getDCals());
        tcaloriesLabel.setText("Total Calories: " + (user.getBCals() + user.getLCals() + user.getDCals()));
        frame.setVisible(true);
    }

    private void centerFrame(JFrame frame) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - frame.getWidth()) / 2;
        int y = (dim.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
    }
}