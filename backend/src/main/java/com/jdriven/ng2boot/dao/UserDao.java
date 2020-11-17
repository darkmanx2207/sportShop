package com.jdriven.ng2boot.dao;

import com.jdriven.ng2boot.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    Optional<User> findUserById(Long id);

    List<User> showAllUsers();

    public User getUser(String login, String password);

    public Long createUser(User user);
}
