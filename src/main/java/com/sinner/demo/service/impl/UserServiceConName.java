package com.sinner.demo.service.impl;

import com.sinner.demo.dao.UserDao;
import com.sinner.demo.service.UserService;

public class UserServiceConName implements UserService {
    private UserDao userDao;
    private String username;

    public UserServiceConName(String username) {
        this.userDao = userDao;
        this.username = username;
    }

    public UserServiceConName() {
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println(username);

    }
}
