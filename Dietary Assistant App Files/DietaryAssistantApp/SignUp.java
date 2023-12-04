import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SignUp {
   private JFrame frame;

   public SignUp() {
      frame = new JFrame("Sign Up");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.setSize(300, 400);
      centerFrame(frame);
   
      JPanel panel = new JPanel();
      frame.add(panel);
      placeComponents(panel);
   
      frame.setVisible(true);
   }

   private void placeComponents(JPanel panel) {
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
   
      JButton submitButton = new JButton("Submit");
      submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
      panel.add(submitButton);
   
      submitButton.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String username = userText.getText();
               String password = new String(passwordText.getPassword());
            
               if(!password.matches("^[a-zA-Z0-9]{5,12}$")) { 
                  JOptionPane.showMessageDialog(panel, "Please make sure your password is 5-12 characters and numbers and letters only!");
               } else {
                
                  if (LoginApp.authManager.addUser(username, password)) {
                     JOptionPane.showMessageDialog(panel, "User created successfully!");
                     frame.dispose(); // Close the sign-up window
                  } else {
                     JOptionPane.showMessageDialog(panel, "Username already taken. Choose another.");
                  }    
               }
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