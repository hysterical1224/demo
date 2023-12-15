// -*- coding: utf-8 -*-
package test;


import com.sinner.demo.dao.UserDao;
import com.sinner.demo.dao.impl.UserDaoImpl1;
import com.sinner.demo.service.anno.impl.UserServiceAnno;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sinner.demo.service.UserService;
import com.sinner.demo.service.anno.UserServiceAnn;


public class UseDaoTest {
    ApplicationContext  appc = new ClassPathXmlApplicationContext("applicationContext.xml");
    @Test
    public void testUserDao(){

        UserDao userDao1 = (UserDao) appc.getBean("UserDao");
        UserDao userDao2 = (UserDao) appc.getBean("UserDao");
        System.out.println(userDao1);
        System.out.println(userDao2);
        userDao1.save();
        UserDao userDao3 = (UserDao) appc.getBean("UserDao1");
        UserDao userDao4 = (UserDao) appc.getBean("UserDao1");
        System.out.println(userDao3);
        System.out.println(userDao4);

    }

    @Test
    public void testFactory(){
        UserDao userFactory = (UserDao)appc.getBean("UserDaoFactory");
        userFactory.save();

    }

    @Test
    public void testDynamicFactory(){
        UserDao userFactory = (UserDao)appc.getBean("UD");
        userFactory.save();

    }

    @Test
    public void testService(){
//        UserServiceImpl usi = new UserServiceImpl();
//        usi.save();
        UserService us = (UserService)appc.getBean("US");
        us.save();
    }


    @Test
    public void testServiceConstructor(){
        //        UserServiceImpl usi = new UserServiceImpl();
        //        usi.save();
        UserService us = (UserService)appc.getBean("USC");
        us.save();
    }
    @Test
    public void testServiceSet(){
        UserService uss = (UserService) appc.getBean("USS");
        uss.save();
    }

    @Test
    public void testServiceConName(){
        UserService uss = (UserService) appc.getBean("USCN");
        uss.save();
    }

    @Test
    public void testUserDaoImpl(){
        UserDaoImpl1 ud1 = (UserDaoImpl1) appc.getBean("DaoImpl1");
        ud1.save();
    }

    @Test
    public void testUserDaoAnn(){
        UserServiceAnn usa = appc.getBean(UserServiceAnno.class);
        usa.save();
        usa.show();

    }


}
