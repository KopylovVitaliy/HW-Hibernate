import userRole.UserRoleDAO;
import userRole.UserRoleDAOImpl;
import users.LogPasUser;
import users.User;
import users.UserDAO;
import users.UserDAOImpl;

public class Application {
    public static void main(String[] args) {
        UserRoleDAO userRoleDAO = new UserRoleDAOImpl();
        UserDAO userDAO = new UserDAOImpl();
        LogPasUser logPasUser = new LogPasUser("Garry", "12345");
        User user = new User(logPasUser, "Potter", 1);
        userDAO.createUser(user);
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

    }
}
