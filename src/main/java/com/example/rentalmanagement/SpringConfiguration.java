package com.example.rentalmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "repository")
@PropertySource({"classpath:application.properties"})
public class SpringConfiguration {
    @Autowired
    private Environment environment;

    @Bean(name = "entityManagerFactory")
    LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean localFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localFactoryBean.setDataSource(dataSource());
        localFactoryBean.setPackagesToScan("com.example.rentalmanagement.model");
        localFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        localFactoryBean.setJpaProperties(hibernateProperties());

        return localFactoryBean;
    }

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("datasource.driver"));
        dataSource.setUrl(environment.getProperty("datasource.url"));
        dataSource.setUsername(environment.getProperty("datasource.user"));
        dataSource.setPassword(environment.getProperty("datasource.password"));

        return dataSource;
    }

    public Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.show_sql", this.environment.getProperty("hibernate.show-sql"));
        hibernateProperties.setProperty("hibernate.ddl-auto", this.environment.getProperty("hibernate.ddl-auto"));
        hibernateProperties.setProperty("hibernate.dialect", this.environment.getProperty("hibernate.dialect"));

        return hibernateProperties;
    }

    @Bean
    JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        transactionManager.afterPropertiesSet();

        return transactionManager;
    }
}
