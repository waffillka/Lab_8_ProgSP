package DAO.interfaces;

import Models.User;
import java.util.List;

public interface UsersDAO {
    Boolean insertUser(User user);

    boolean updateUser(User user);

    User selectUser(int id);

    User selectUser(String username, String password);

    List<User> selectAllUsers();

    boolean deleteUser(int id);
}
