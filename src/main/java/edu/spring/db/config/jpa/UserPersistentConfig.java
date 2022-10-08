package edu.spring.db.config.jpa;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
    basePackages = "edu.spring.db.dao.mysql", 
    entityManagerFactoryRef = "userEntityManager", 
    transactionManagerRef = "userTransactionManager"
)
public class UserPersistentConfig {

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean userEntityManager() {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(userDataSource());
        localContainerEntityManagerFactoryBean.setPackagesToScan(new String[] { "edu.spring.db.entity" });

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.ddl-auto", "update");
        properties.put("properties.hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.put("show-sql", true);

        localContainerEntityManagerFactoryBean.setJpaPropertyMap(properties);

        return localContainerEntityManagerFactoryBean;
    }

    @Primary
    @Bean
    public DataSource userDataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost:3307/sb?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("root1234");

        return dataSourceBuilder.build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager userTransactionManager() {

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(userEntityManager().getObject());
        return transactionManager;
    }

}
