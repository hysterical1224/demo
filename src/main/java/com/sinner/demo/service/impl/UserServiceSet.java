package com.sinner.demo.service.impl;

import com.sinner.demo.dao.UserDao;
import com.sinner.demo.service.UserService;

public class UserServiceSet implements UserService {
    private UserDao userDao;
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println(username);
        userDao.save();
    }
}
