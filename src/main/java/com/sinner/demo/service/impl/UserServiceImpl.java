package com.sinner.demo.service.impl;

import com.sinner.demo.dao.UserDao;
import com.sinner.demo.service.UserService;

public class UserServiceImpl implements UserService {
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
        userDao.save();
    }


    //    public void save(){
//        ClassPathXmlApplicationContext userService = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserDao userService1 = (UserDao)userService.getBean("UserDao");
//        userService1.save();
//
//    }

}
