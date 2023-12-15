package com.sinner.demo.service.anno.impl;



import com.sinner.demo.dao.anno.UserDaoAnn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import com.sinner.demo.service.anno.UserServiceAnn;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


//@Component

@PropertySource(value={"classpath:tmp.properties"})
@Service("userServiceAnno")
public class UserServiceAnno implements UserServiceAnn {

//    @Autowired
//    @Qualifier("userDaoAnno")
    @Resource(name = "userDaoAnno")
    private UserDaoAnn userDaoAnn;

    @Value("${user}")
    public String username;

    @Value("${password}")
    public String password;

//    public void setUserDao(UserDaoAnn userDaoAnn) {
//        this.userDaoAnn = userDaoAnn;
//    }

    @Override
    public void save() {
        userDaoAnn.save();

    }

    @Override
    public void show(){
        System.out.println(username);
        System.out.println(password);
    }
}
