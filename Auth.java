
import java.util.ArrayList;

public class Auth {

    private final ArrayList<User> users = new ArrayList<>();

    public void register(User user) {
        users.add(user);
    }

    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getName().equals(username)
                    && user.checkPassword(password)) {
                return true;
            }
        }
        return false;
    }

}
