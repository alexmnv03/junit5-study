package com.alex.study.junit.introduction.dao;

import lombok.SneakyThrows;

import java.sql.DriverManager;

public class UserDao {

    // Пробросим исключение
    @SneakyThrows
    public boolean delete(Integer userId){
        try (var connection = DriverManager.getConnection("url", "userName", "password")) {
            return true;
        }
    }

}
