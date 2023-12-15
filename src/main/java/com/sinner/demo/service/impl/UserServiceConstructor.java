package com.sinner.demo.service.impl;

import com.sinner.demo.dao.UserDao;
import com.sinner.demo.service.UserService;

public class UserServiceConstructor implements UserService {
    private UserDao userDao;

    public UserServiceConstructor(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceConstructor() {
    }

    @Override
    public void save() {

    }
}
