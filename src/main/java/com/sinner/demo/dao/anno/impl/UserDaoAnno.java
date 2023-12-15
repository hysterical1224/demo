package com.sinner.demo.dao.anno.impl;


import com.sinner.demo.dao.anno.UserDaoAnn;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//在 Spring 容器初始化时，如果扫描到了这个类，它将被注册为一个名为 "uda" 的 bean。
//通常情况下，如果不显式指定 @Component 的 value 属性，Spring 会使用默认的 bean 名称，
// 即类名的首字母小写。但通过显式指定名称，你可以自定义 bean 的名称，使其更具有描述性，同时也可以避免类名变更导致的问题。
//<bean id="uda" class="com.sinner.demo.dao.anno.impl.UserDaoAnno"/>
@Repository
public class UserDaoAnno implements UserDaoAnn {


    @Override
    public void save() {
        System.out.println("UserDaoAnno is running...");

    }
}
