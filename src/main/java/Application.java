import userRole.UserRole;
import userRole.UserRoleDAO;
import userRole.UserRoleDAOImpl;
import users.User;
import users.UserDAO;
import users.UserDAOImpl;

public class Application {
    public static void main(String[] args) {
        UserRoleDAO userRoleDAO = new UserRoleDAOImpl();
        UserDAO userDAO = new UserDAOImpl();
//        UserRole userRole1 = new UserRole("По умолчанию");
//        UserRole userRole2 = new UserRole("Разработчик");
//        UserRole userRole3 = new UserRole("Аналитик");
//        UserRole userRole4 = new UserRole("Тестировщик");
//        UserRole userRole5 = new UserRole("Менеджер");
//        UserRole userRole6 = new UserRole("Дизайнер");
//
//        userRoleDAO.createUserRole(userRole1);
//        userRoleDAO.createUserRole(userRole2);
//        userRoleDAO.createUserRole(userRole3);
//        userRoleDAO.createUserRole(userRole4);
//        userRoleDAO.createUserRole(userRole5);
//        userRoleDAO.createUserRole(userRole6);


//        User user = new User( "Daz", "Bazy", "11234");
//        userDAO.createUser(user);
//        EntityManager manager = EntityUtil.getEm();
//        manager.getTransaction().begin();
//        User user1 = manager.find(User.class, 1);
//        List<UserRole> userRoles = new ArrayList<>();
//        userRoles.add(userRoleDAO.getUserRoleByID(1));
//        userRoles.add(userRoleDAO.getUserRoleByID(2));
//        user1.setUserRoles(userRoles);
//        manager.merge(user1);
//        manager.getTransaction().commit();
//        manager.close();
        //userDAO.updateUserRoles(userDAO.getUserByID("Dazy"));
//      userDAO.getAllUsers();
//        userDAO.getUserByRole(userRoleDAO.getUserRoleByID(4));
        userDAO.deleteUser(userDAO.getUserByID("Daz"));

    }
}
