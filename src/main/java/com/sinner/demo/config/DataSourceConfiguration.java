package com.sinner.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.sql.SQLException;
//标志该类是Spring的核心配置类
@Configuration
@ComponentScan("com.sinner.demo")
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfiguration {
    @Value("${user}")
    private String username;

    @Value("${password}")
    private String password;

    @Value("${driver}")
    private String driverClassName;

    @Value("${url}")
    private String url;


    @Bean("dataSource")//spring会将当前方法的返回值以指定名称存储到Spring容器中
    public DataSource getDataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setUrl(url);
        DruidPooledConnection connection = druidDataSource.getConnection();
        System.out.println(connection);
        return druidDataSource;
    }
}
