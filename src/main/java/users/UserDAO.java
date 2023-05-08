package users;

import userRole.UserRole;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    User getUserByID(String login);
    void createUser(User user);
    void updateUserPass(User user, String password);
    void updateUserRoles(User user, Integer roleId);
    void deleteUser(User user);
    void getUserByRole(UserRole userRole);
}
