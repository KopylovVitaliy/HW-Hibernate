package users;

import userRole.UserRole;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    User getUserByID(String login);
    void createUser(User user);
    void updateUserPass(User user);
    void updateUserRoles(User user);
    void deleteUser(User user);
    void getUserByRole(UserRole userRole);
}
