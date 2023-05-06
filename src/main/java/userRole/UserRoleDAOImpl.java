package userRole;

import userRole.UserRole;
import userRole.UserRoleDAO;
import util.EntityUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserRoleDAOImpl implements UserRoleDAO {
    @Override
    public List<UserRole> getAllCity() {
        List<UserRole> userRoles;
        EntityManager manager = EntityUtil.getEm();
        manager.getTransaction().begin();
        TypedQuery<UserRole> query = manager.createQuery("SELECT u FROM UserRole u", UserRole.class);
        userRoles = query.getResultList();
        manager.getTransaction().commit();
        manager.close();
        userRoles.forEach(System.out::println);
        return userRoles;
    }

    @Override
    public UserRole getCityByID(int id) {
        return null;
    }

    @Override
    public void createUserRole(UserRole userRole) {
        EntityManager manager = EntityUtil.getEm();
        manager.getTransaction().begin();
        manager.persist(userRole);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void updateUserRole(UserRole userRole) {

    }

    @Override
    public void deleteUserRole(UserRole userRole) {

    }
}
