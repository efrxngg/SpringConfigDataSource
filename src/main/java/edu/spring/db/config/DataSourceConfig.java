package edu.spring.db.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource getDataSource()
    {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost:3307/sb?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("root1234");

        return dataSourceBuilder.build();
    }
}
