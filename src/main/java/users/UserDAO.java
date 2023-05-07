package users;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    User getUserByID(int id);
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
}
