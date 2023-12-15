package com.sinner.demo.proxy_jdk.impl;

import com.sinner.demo.dao.anno.UserDaoAnn;
import com.sinner.demo.proxy_jdk.Target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

//@Component("targetImpl")
public class TargetImpl implements Target {

    @Autowired
    private DataSource dataSource;


    @Override
    public void save() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        System.out.println("target save running...");
    }

    @Override
    public void error() throws SQLException {
        int i = 1/0;
        System.out.println(i);
        System.out.println("error!");
    }

    public void around(){
        System.out.println("I am around!");
    }
}
