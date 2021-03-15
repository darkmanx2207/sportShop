package com.jdriven.ng2boot.service;

import com.jdriven.ng2boot.dao.UserDao;
import com.jdriven.ng2boot.entity.Protein;
import com.jdriven.ng2boot.entity.ProteinType;
import com.jdriven.ng2boot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Long createUser(User user) {
        return userDao.createUser(user);
    }

    public User findUserById(Long id) {
        return userDao.findUserById(id)
                .orElseThrow(() -> new NoSuchElementException("Chair not found, id: " + id));
    }

    public List<User> showAllUsers() {
        return userDao.showAllUsers();
    }

    public User getUser(String login, String password) {
        return userDao.getUser(login, password);
    }
}
