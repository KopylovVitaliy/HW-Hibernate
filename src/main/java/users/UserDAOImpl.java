package users;
import userRole.UserRole;
import userRole.UserRoleDAO;
import userRole.UserRoleDAOImpl;

import util.EntityUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDAOImpl implements UserDAO {
    Scanner scanner = new Scanner(System.in);
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
    public User getUserByID(String id) {
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
    public void updateUserPass(User user) {
        System.out.println("Введите новый пароль");
        String pass = scanner.nextLine();
        EntityManager manager = EntityUtil.getEm();
        manager.getTransaction().begin();
        user.setPassword(pass);
        manager.merge(user);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void updateUserRoles(User user) {
        UserRoleDAO userRoleDAO = new UserRoleDAOImpl();
        List<UserRole> list = new ArrayList<>(user.getUserRoles());
        while (true) {
            System.out.println("1 = Добавить роль, 0 = Отмена");
            Integer x = scanner.nextInt();
            if (x == 1) {
                System.out.println("Ведите номер роли");
                System.out.println("2 = Разработчик");
                System.out.println("3 = Аналитик ");
                System.out.println("4 = Тестировщик");
                System.out.println("5 = Менеджер");
                System.out.println("6 = Дизайнер");
                Integer num = scanner.nextInt();
                list.add(userRoleDAO.getUserRoleByID(num));

                EntityManager manager = EntityUtil.getEm();
                manager.getTransaction().begin();
                user.setUserRoles(list);
                manager.merge(user);
                manager.getTransaction().commit();
                manager.close();
            } else if (x == 2) {
                break;
            }
        }
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

    @Override
    public void getUserByRole(UserRole userRole) {
        EntityManager manager = EntityUtil.getEm();
        manager.getTransaction().begin();
        Query query = manager.createQuery(" ");
    }


}
