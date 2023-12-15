package com.sinner.demo.dao.impl;

import com.sinner.demo.dao.UserDao;
import com.sinner.demo.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl1 implements UserDao {
    private List<String> stringList;
    private Map<String, User> userMap;
    private Properties properties;

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void save() {
        System.out.println(stringList);
        System.out.println(userMap);
        System.out.println(properties);

    }
}
