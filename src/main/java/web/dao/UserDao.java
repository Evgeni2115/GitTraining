package web.dao;

import web.model.User;
import java.util.List;

public interface UserDao {
    void addUser(User user);

    List<User> getAllUsers();

    User getUser(Long id);

    void editUser(Long id, User user);

    void removeUser(Long id);
}
