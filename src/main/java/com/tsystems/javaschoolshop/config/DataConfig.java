package com.tsystems.javaschoolshop.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * As we see from class name, it set some database configs
 */
@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.tsystems.javaschoolshop" })
@PropertySource(value = { "classpath:application.properties" })
public class DataConfig {

    @Resource
    private Environment environment;

    /**
     * Method register entityMangerFactory bean for us in spring context.
     * It provides us entity manager which uses in all dao classes to work with
     * our database
     * @return
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(environment.getRequiredProperty("db.entity.package"));
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(additionalProperties());
        return em;
    }

    /**
     * Method register dataSource bean in spring context. Data source provide us a possibility
     * to connect with database using our settings. In particular, settings stores in resource folder.
     * @return data source (our database)
     */
    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));

        //there we set some settings to work with java database connection pool
        dataSource.setInitialSize(Integer.valueOf(environment.getRequiredProperty("jdbc.initialSize")));
        dataSource.setMinIdle(Integer.valueOf(environment.getRequiredProperty("jdbc.minIdle")));
        dataSource.setMaxIdle(Integer.valueOf(environment.getRequiredProperty("jdbc.maxIdle")));
        dataSource.setTimeBetweenEvictionRunsMillis(Long.valueOf(environment.getRequiredProperty("jdbc.timeBetweenEvictionRunsMillis")));
        dataSource.setMinEvictableIdleTimeMillis(Long.valueOf(environment.getRequiredProperty("jdbc.minEvictableIdleTimeMillis")));
        dataSource.setTestOnBorrow(Boolean.valueOf(environment.getRequiredProperty("jdbc.testOnBorrow")));
        dataSource.setValidationQuery(environment.getRequiredProperty("jdbc.validationQuery"));

        return dataSource;
    }

    /**
     * Method register transactionManager bean in spring context.
     * It is obvious that the bean is used for transaction support
     * @return some transaction manager which includes exemplar of
     * our entityManagerFactory bean
     */
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    /**
     * Method create hibernate properties
     */
    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }
}
