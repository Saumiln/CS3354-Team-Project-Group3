import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CalorieEntryPage {
    private JFrame frame;
    private Dashboard dashboard;
    private String meal;

    public CalorieEntryPage(Dashboard dashboard, String meal) {
        this.dashboard = dashboard;
        this.meal = meal;

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

        ImageIcon logoIcon = new ImageIcon("v147_81.png");
        Image logoImage = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon scaledLogoIcon = new ImageIcon(logoImage);

        JLabel logoLabel = new JLabel(scaledLogoIcon);
        logoLabel.setBounds(10, 10, 100, 100);
        panel.add(logoLabel);
        
        if(meal.equals("Breakfast")) {
        JLabel promptLabel = new JLabel("Enter Breakfast Calories:");
        promptLabel.setBounds(10, 110, 150, 25);
        panel.add(promptLabel);
        }
        
        if(meal.equals("Lunch")) {
        JLabel promptLabel = new JLabel("Enter Lunch Calories:");
        promptLabel.setBounds(10, 110, 150, 25);
        panel.add(promptLabel);
        }
        
        if(meal.equals("Dinner")) {
        JLabel promptLabel = new JLabel("Enter Dinner Calories:");
        promptLabel.setBounds(10, 110, 150, 25);
        panel.add(promptLabel);
        }

        JTextField caloriesField = new JTextField(20);
        caloriesField.setBounds(160, 110, 100, 25);
        panel.add(caloriesField);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(10, 140, 80, 25);
        panel.add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int enteredCalories = Integer.parseInt(caloriesField.getText());
                // Update the dashboard with the entered calories
                if(meal.equals("Breakfast")) {
                dashboard.updateBCalories(enteredCalories);
                }
                
                if(meal.equals("Lunch")) {
                dashboard.updateLCalories(enteredCalories);
                }
                
                if(meal.equals("Dinner")) {
                dashboard.updateDCalories(enteredCalories);
                }
                
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