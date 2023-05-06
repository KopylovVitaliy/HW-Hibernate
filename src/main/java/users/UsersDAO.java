package users;

import java.util.List;

public interface UsersDAO {
    List<User> getAllCity();
    User getCityByID(int id);
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
}
