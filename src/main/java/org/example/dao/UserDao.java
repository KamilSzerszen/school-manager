package org.example.dao;

import org.example.users.User;

import java.util.Optional;

public interface UserDao {
    User addUser(User user);

    User updateUser(User user);

    Optional<User> getUser(int id);

    Optional<User> deleteUser(int id);

}
