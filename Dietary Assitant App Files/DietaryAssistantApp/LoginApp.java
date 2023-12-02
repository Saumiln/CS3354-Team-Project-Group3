import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class User {

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class AuthManager {
    public List<User> users;

    public AuthManager() {
        users = new ArrayList<>();
        // Add some sample users
        users.add(new User("user1", "password1"));
        users.add(new User("user2", "password2"));
    }

    public boolean authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean addUser(String username, String password) {
        // Check if the username already exists
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false; // Username already taken
            }
        }
        // Add the new user
        users.add(new User(username, password));
        return true;
    }
}

public class LoginApp {

    public static AuthManager authManager = new AuthManager();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        centerFrame(frame);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(new GridLayout(4, 2));

        JLabel userLabel = new JLabel("Username:");
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        panel.add(loginButton);

        JButton signUpButton = new JButton("Sign Up");
        panel.add(signUpButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                if (authManager.authenticate(username, password)) {
                    JOptionPane.showMessageDialog(panel, "Login successful!");
                    // Do something after successful login
                    new Dashboard();
                    userText.setText("");
                    passwordText.setText("");
                } else {
                    JOptionPane.showMessageDialog(panel, "Login failed. Invalid credentials.");
                }
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignUp();
            }
        });
    }

    private static void centerFrame(JFrame frame) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - frame.getWidth()) / 2;
        int y = (dim.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
    }
}