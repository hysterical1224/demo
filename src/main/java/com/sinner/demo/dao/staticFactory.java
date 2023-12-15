package com.sinner.demo.dao;

import com.sinner.demo.dao.impl.UserDaoImpl;

public class staticFactory {

    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }


}
