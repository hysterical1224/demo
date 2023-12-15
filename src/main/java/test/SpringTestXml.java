package test;


import com.sinner.demo.proxy_jdk.Target;
import com.sinner.demo.proxy_jdk.impl.TargetImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.SQLException;

//加载 Spring 配置： 根据 @ContextConfiguration 注解或其他配置，加载应用程序上下文。这可能包括加载 XML 配置文件或通过 Java 类进行配置。
//
//启动 Spring 容器： 初始化并启动 Spring 容器，准备用于测试的 bean。
//
//执行测试： 运行 JUnit 测试方法。在测试方法执行之前，会注入 Spring 管理的 bean，使测试可以利用 Spring 的功能。
//
//关闭 Spring 容器： 在测试完成后，关闭 Spring 容器，以释放资源。
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTestXml {

    @Resource(name = "targetImpl")
    TargetImpl tg;

    @Test
    public void testXml() throws SQLException {
        System.out.println("1234");
        tg.save();
    }


    @Test
    public void testAroundReturning() throws SQLException {
        System.out.println("AroundReturning被执行了...");
        tg.save();
        System.out.println("-----------------------");
        tg.error();

    }


    @Test
    public void testAround() throws SQLException {

        tg.around();
        System.out.println("-----------------------");

    }

    @Test
    public void testAfterThrowing() throws SQLException {

        tg.error();
        System.out.println("-----------------------");

    }

}
