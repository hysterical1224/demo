package com.sinner.demo.dao;

import com.sinner.demo.dao.impl.UserDaoImpl;

public class factory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }

}
