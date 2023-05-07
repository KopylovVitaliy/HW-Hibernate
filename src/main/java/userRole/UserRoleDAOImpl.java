package userRole;

import userRole.UserRole;
import userRole.UserRoleDAO;
import util.EntityUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserRoleDAOImpl implements UserRoleDAO {
    @Override
    public List<UserRole> getAllRoles() {
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
    public UserRole getUserRoleByID(int id) {
        EntityManager manager = EntityUtil.getEm();
        manager.getTransaction().begin();
        UserRole userRole = manager.find(UserRole.class, id);
        manager.getTransaction().commit();
        manager.close();
        return userRole;
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
    public void deleteUserRole(UserRole userRole) {
        EntityManager manager = EntityUtil.getEm();
        manager.getTransaction().begin();
        UserRole userRole1 = manager.find(UserRole.class, userRole.getUser_role_id());
        manager.remove(userRole1);
        manager.getTransaction().commit();
        manager.close();

    }
}
