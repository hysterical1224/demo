package test;

import com.sinner.demo.proxy_jdk.anno.TargetAnno;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import java.sql.SQLException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:anno.xml")
public class AnnoTest {

    @Resource(name = "targetAnno")
    TargetAnno tg;

    @Test
    public void testSave() throws SQLException {
        System.out.println("1234");
        tg.save();
        System.out.println("-------------");
    }


    @Test
    public void testError() throws SQLException {
        System.out.println("1234");
        tg.error();
        System.out.println("-------------");
    }
}
