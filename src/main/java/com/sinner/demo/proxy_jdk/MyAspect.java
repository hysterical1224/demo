package com.sinner.demo.proxy_jdk;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;


@Component("myAspect")
public class MyAspect {
    public void afterReturning(){
        System.out.println("报错了就不执行，后置增强，afterReturning...");
    }

    public void after(){
        System.out.println("报错了执行，后置增强，after...");
    }

    public void before(){
        System.out.println("前置增强,before...");
    }

    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around前增强...");
        Object proceed = pjp.proceed();
        //切点方法
        System.out.println("around后增强...");
        return proceed;
    }


    public void afterThrowing(){
        //用于配置异常抛出通知。指定增强的方法在出现异常时执行
        System.out.println("异常出现时，指定增强的方法...");
    }
}
