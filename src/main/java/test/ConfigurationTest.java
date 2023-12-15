package test;

import com.sinner.demo.config.SpringConfiguration;
import com.sinner.demo.service.UserService;
import com.sinner.demo.service.anno.UserServiceAnn;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationTest {


    @Test
    public void testSpringConf(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserServiceAnn us = (UserServiceAnn) ac.getBean("userServiceAnno");
        us.save();
    }
}
