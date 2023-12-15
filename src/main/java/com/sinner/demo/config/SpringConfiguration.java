package com.sinner.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.sql.SQLException;
//标志该类是Spring的核心配置类
@Configuration
@ComponentScan("com.sinner.demo")
//<context:component-scan base-package="com.sinner.demo"/>
@Import({DataSourceConfiguration.class})
public class SpringConfiguration {





}

