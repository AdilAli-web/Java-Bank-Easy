
public class User {

    private final String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        if (!password.contains("@")) {
            throw new IllegalArgumentException("Password must contain '@'");

        }
        this.password = password;
    }

    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);

    }

}
