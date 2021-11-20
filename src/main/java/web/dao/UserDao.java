package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> listUsers();

    User getUserById(Long id);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);
}
