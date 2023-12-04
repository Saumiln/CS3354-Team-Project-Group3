import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class User {

   private String username;
   private String password;
   private int Bcals;
   private int Lcals;
   private int Dcals;

   public User(String username, String password) {
      this.username = username;
      this.password = password;
      this.Bcals = 0;
      this.Lcals = 0;
      this.Dcals = 0;
   }

   public String getUsername() {
      return username;
   }

   public String getPassword() {
      return password;
   }
    
   public int getBCals() {
      return Bcals;
   }
    
   public void addBCals(int Bcals) {
      this.Bcals += Bcals;
   }
   
   public int getLCals() {
      return Lcals;
   }
    
   public void addLCals(int Lcals) {
      this.Lcals += Lcals;
   }

   public int getDCals() {
      return Dcals;
   }
    
   public void addDCals(int Dcals) {
      this.Dcals += Dcals;
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
    
   public User returnUser(String username) {
      for(User user : users) {
         if(user.getUsername().equals(username)) {
            return user;
         }
      }
      return null;
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
      JFrame frame = new JFrame("Login");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(300, 400);
      centerFrame(frame);
   
      JPanel panel = new JPanel();
      frame.add(panel);
      placeComponents(panel);
   
      frame.setVisible(true);
   }

   private static void placeComponents(JPanel panel) {
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
   
      ImageIcon logoIcon = new ImageIcon("v147_81.png");
      Image logoImage = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
      ImageIcon scaledLogoIcon = new ImageIcon(logoImage);
   
      JLabel logoLabel = new JLabel(scaledLogoIcon);
      logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
      panel.add(logoLabel);
   
      JLabel userLabel = new JLabel("Username:");
      userLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
      panel.add(userLabel);
   
      JTextField userText = new JTextField(20);
      userText.setAlignmentX(Component.CENTER_ALIGNMENT);
      userText.setMaximumSize(new Dimension(150, 25));
      panel.add(userText);
   
      JLabel passwordLabel = new JLabel("Password:");
      passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
      panel.add(passwordLabel);
   
      JPasswordField passwordText = new JPasswordField(20);
      passwordText.setAlignmentX(Component.CENTER_ALIGNMENT);
      passwordText.setMaximumSize(new Dimension(150, 25));
      panel.add(passwordText);
   
      JButton loginButton = new JButton("Login");
      loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
      panel.add(loginButton);
   
      JButton signUpButton = new JButton("Sign Up");
      signUpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
      panel.add(signUpButton);
   
      loginButton.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String username = userText.getText();
               String password = new String(passwordText.getPassword());
            
               if (authManager.authenticate(username, password)) {
                  JOptionPane.showMessageDialog(panel, "Login successful!");
                    // Do something after successful login
                  new Dashboard(authManager.returnUser(username));
                  userText.setText("");
                  passwordText.setText("");
               } else {
                  JOptionPane.showMessageDialog(panel, "Login failed. Invalid credentials.");
               }
            }
         });
   
      signUpButton.addActionListener(
         new ActionListener() {
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