package com.alex.study.junit.introduction.service;

import com.alex.study.junit.introduction.dao.UserDao;
import com.alex.study.junit.introduction.service.dto.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserService {

    private UserDao userDao;

    public UserService() {
    }

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    private List<User> users = new ArrayList<>();

    public List<User> getAll() {
        return users;
    }

    public boolean delete(Integer userId) {
        return userDao.delete(userId);
    }

    public boolean add(User user) {
        return users.add(user);
    }

    public Optional<User> login(String userName, String password) {
        if (userName == null || password == null) {
            throw new IllegalArgumentException("userName or password is Null");
        }
        return users.stream()
                .filter(user -> user.getUserName().equals(userName))
                .filter(user -> user.getPassword().equals(password))
                .findFirst();
    }
}
