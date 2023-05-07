package userRole;

import java.util.List;

public interface UserRoleDAO {
    List<UserRole> getAllRoles();
    UserRole getUserRoleByID(int id);
    void createUserRole(UserRole userRole);
    void deleteUserRole(UserRole userRole);

}
