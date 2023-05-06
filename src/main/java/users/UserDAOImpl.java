package users;

import util.EntityUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> getAllCity() {
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
        EntityManager manager = EntityUtil.getEm();
        manager.getTransaction().begin();
        manager.persist(user);
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
