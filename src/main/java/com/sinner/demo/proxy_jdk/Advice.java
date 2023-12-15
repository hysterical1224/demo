package com.sinner.demo.proxy_jdk;

import org.springframework.stereotype.Component;

@Component("advice")
public class Advice {

    public void before(){
        System.out.println("前置增强...");
    }


    public void after(){
        System.out.println("后置增强...");
    }
}
