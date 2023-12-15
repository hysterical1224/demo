package com.sinner.demo.dao.impl;


import com.sinner.demo.dao.*;
import org.springframework.stereotype.Repository;

//@Repository("userDao")
public class UserDaoImpl implements UserDao {
    public void init(){
        System.out.println("init...");
    }

    @Override
    public void save(){
        System.out.println("save running...");
    }

    public void destroy(){
        System.out.println("destory...");
    }

}
