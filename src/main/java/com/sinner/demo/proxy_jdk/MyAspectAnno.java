package com.sinner.demo.proxy_jdk;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.stereotype.Component;



@Component("myAspectAnno")
@Aspect
public class MyAspectAnno {

    @Pointcut(value = "execution(public void com.sinner.demo.proxy_jdk.anno.TargetAnno.error())")
    public void errorPointcut(){

    }
//    @Pointcut(value = "execution(public void com.sinner.demo.proxy_jdk.anno.TargetAnno.save())")
//    public void rightPointcut(){}

    @AfterReturning("execution(public void com.sinner.demo.proxy_jdk.anno.TargetAnno.error()) && execution(public void com.sinner.demo.proxy_jdk.anno.TargetAnno.save())")
    public void afterReturning(JoinPoint joinPoint){
        System.out.println("报错了就不执行，后置增强，afterReturning...");
        System.out.println("****LoggingAspect.logAfterAllMethods() : " + joinPoint.getSignature().getName());
    }

    @After("execution(public void com.sinner.demo.proxy_jdk.anno.TargetAnno.save())")
    public void after(){
        System.out.println("报错了也会执行，后置增强，after...");
    }


    @Before("execution(public void com.sinner.demo.proxy_jdk.anno.TargetAnno.save())")
    public void before(){
        System.out.println("前置增强,before...");
    }

//    @Around()
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around前增强...");
        Object proceed = pjp.proceed();
        //切点方法
        System.out.println("around后增强...");
        return proceed;
    }
}
