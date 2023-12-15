package test;

import com.sinner.demo.config.SpringConfiguration;
import com.sinner.demo.service.anno.impl.UserServiceAnno;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)//这是 JUnit 框架的一个扩展，用于在测试过程中启动 Spring 的应用上下文。
                                        // 它告诉 JUnit 使用 Spring 的测试运行器来执行测试。
@ContextConfiguration(classes = SpringConfiguration.class)
//如果你的 Spring 应用使用了注解配置（例如使用 @Configuration 和 @ComponentScan），
// 而不是使用 XML 配置文件，那么在测试中使用 @ContextConfiguration("classpath:applicationContext.xml") 可能并不是必需的,
// 也可以是@ContextConfiguration(classes = SpringConfiguration.class)

//上述注解是为了解决        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        UserServiceAnn us = (UserServiceAnn) ac.getBean("userServiceAnno");一直重复的问题
public class SpringTest {
    @Autowired
    private UserServiceAnno userServiceAnno;

    @Autowired
    private DataSource dataSource;
//    @Autowired 注解注入了一个名为 dataSource 的 DataSource 实例。这个实例应该是通过 Spring 容器进行管理的，
    //    并且 Spring 容器会负责为它注入合适的实现。
    //
    //关于你提到的没有 DataSourceFactory，这可能涉及到 Spring 的默认配置和自动配置机制。
    // 在许多情况下，Spring Boot 提供了默认的数据源配置，
    // 例如 org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration。
    //
    //Spring Boot 会尝试根据 classpath 中的类来选择一个默认的 DataSource 实现。
    // 如果你没有显式地提供自定义的数据源配置，Spring Boot 会尝试根据项目中的依赖自动配置一个数据源。
    // 这包括检查 classpath 中是否有支持的数据库驱动。
    //
    //因此，如果你的项目符合默认的数据源配置，并且 classpath 中有支持的数据库驱动，
    // Spring Boot 会自动创建并配置一个数据源，你就可以通过 @Autowired 注入 dataSource，并使用它获取连接。
    //
    //这是 Spring Boot 的一种便捷机制，使得应用程序的配置更为简单。
    // 如果你想要更多的控制，你可以显式地提供自己的数据源配置，覆盖默认的配置。

    @Test
    public void testService() throws SQLException {
        userServiceAnno.show();
        System.out.println(dataSource.getConnection());
    }
}
