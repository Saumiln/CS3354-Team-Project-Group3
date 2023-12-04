import java.util.ArrayList;
import java.util.List;

public class AuthManager {
    private List<User> users;

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
}