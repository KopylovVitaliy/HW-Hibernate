package userRole;

import userRole.UserRole;

import java.util.List;

public interface UserRoleDAO {
    List<UserRole> getAllCity();
    UserRole getCityByID(int id);
    void createUserRole(UserRole userRole);
    void updateUserRole(UserRole userRole);
    void deleteUserRole(UserRole userRole);
}
