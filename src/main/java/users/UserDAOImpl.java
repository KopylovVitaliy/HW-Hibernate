package users;
import userRole.UserRole;
import userRole.UserRoleDAO;
import userRole.UserRoleDAOImpl;

import util.EntityUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> getAllUsers() {
        List<User> users;
        EntityManager manager = EntityUtil.getEm();
        manager.getTransaction().begin();
        TypedQuery<User> query = manager.createQuery("SELECT s FROM User s", User.class);
        users = query.getResultList();
        manager.getTransaction().commit();
        manager.close();
        users.forEach(System.out::println);
        return users;
    }

    @Override
    public User getUserByID(int id) {
        EntityManager manager = EntityUtil.getEm();
        manager.getTransaction().begin();
        User user = manager.find(User.class, id);
        manager.getTransaction().commit();
        manager.close();
        return user;
    }

    @Override
    public void createUser(User user) {
        UserRoleDAO userRoleDAO = new UserRoleDAOImpl();
        List<UserRole> userRoles = new ArrayList<>();
        userRoles.add(userRoleDAO.getUserRoleByID(1));
        EntityManager manager = EntityUtil.getEm();
        manager.getTransaction().begin();
        manager.persist(user);
        user.setUserRoles(userRoles);
        manager.merge(user);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {
        EntityManager manager = EntityUtil.getEm();
        manager.getTransaction().begin();
        User user1 = manager.find(User.class, user);
        manager.remove(user1);
        manager.getTransaction().commit();
        manager.close();
    }
}
