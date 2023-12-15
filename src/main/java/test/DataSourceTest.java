package test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class DataSourceTest {



//    @Test
//    public void testDruid() throws Exception {
//
//        Properties pro = new Properties();
//        InputStream rs = DataSourceTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
//        pro.load(rs);
//
//        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
//
//        Connection connection = ds.getConnection();
//        System.out.println(connection);
//        System.out.println("--------------------------------");
//
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
////        druidDataSource.setUsername("root");
////        druidDataSource.setPassword("4ay6V638");
//        druidDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/travel?useUnicode=true&characterEncoding=utf8&username=root&password=4ay6V638");
//
//        DruidPooledConnection connection1 = druidDataSource.getConnection();
//        System.out.println(connection1);
//
//    }

    @Test
    public void testResourcebundle() throws SQLException {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String username = bundle.getString("user");
        String password = bundle.getString("password");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setUrl(url);
        DruidPooledConnection connection = druidDataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void testResourceXml() throws SQLException {
        ClassPathXmlApplicationContext capp = new ClassPathXmlApplicationContext("applicationContext1.xml");
        DruidDataSource dds = (DruidDataSource)capp.getBean("DDS");

        DruidPooledConnection conn = dds.getConnection();
        System.out.println(conn);
    }


    @Test
    public void testLoadProperties() throws SQLException {
        ClassPathXmlApplicationContext cap = new ClassPathXmlApplicationContext("applicationContext2.xml");
        System.out.println(cap);




        DruidDataSource ds = (DruidDataSource)cap.getBean("dS");
        String username = ds.getUsername();
        System.out.println(username);
        String password = ds.getPassword();
        System.out.println(password);
        String url = ds.getUrl();
        System.out.println(url);
        DruidPooledConnection conn = ds.getConnection();
        System.out.println(conn);
    }
}
