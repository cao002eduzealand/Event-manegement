import java.util.ArrayList;
import java.util.List;
//Klasse
public class UserManager {
    //private kontruktør til at forhindre instantiation
    private static UserManager instance;
    private List<User> users = new ArrayList<>();
    private UserManager() {

    }
//metode instance
    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }
    //metode til at registrer en bruger
    public void registerUser(String username, String email) {
        User user = new User(username, email);
        users.add(user);
        System.out.println("User registered: " + username);
    }
//metode til at fjerne en bruger
    public void deleteUser(String username) {
        users.removeIf(user -> user.getUsername().equals(username));
        System.out.println("User removed: " + username);
    }
//arraylist
    public List<User> getUsers() {
        return users;

    }

}