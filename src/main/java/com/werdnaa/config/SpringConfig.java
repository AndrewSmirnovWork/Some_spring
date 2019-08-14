package com.werdnaa.config;

import com.werdnaa.dao.UserDao;
import com.werdnaa.dao.UserDaoImpl;
import com.werdnaa.service.UserService;
import com.werdnaa.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.werdnaa.service", "com.werdnaa.dao"})
public class SpringConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/first_scheme?useSll=false");
        dataSource.setUsername("root");
        dataSource.setPassword("root123");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public UserDao getUserDao() {
        return new UserDaoImpl(getJdbcTemplate());
    }

    @Bean
    public UserService getUserService() {
        return new UserServiceImpl();
    }

}
