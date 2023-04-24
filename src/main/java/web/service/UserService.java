package web.service;

import web.model.User;
import java.util.List;

public interface UserService {
    void createUser(User user);

    List<User> getAllUsers();

    User getUser(Long id);

    void updateUser(Long id, User user);

    void removeUser(Long id);
}
