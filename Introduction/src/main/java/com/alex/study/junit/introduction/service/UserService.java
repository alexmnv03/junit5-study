package com.alex.study.junit.introduction.service;

import com.alex.study.junit.introduction.service.dto.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserService {

    private List<User> users = new ArrayList<>();

    public List<User> getAll() {
        return users;
    }

    public boolean add(User user) {
        return users.add(user);
    }
}
