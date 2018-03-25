package com.tsystems.javaschoolshop.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

/**
 * This class set some JMS settings
 * In our case, we use ActiveMQ as JMS implementation
 */
@Configuration
@EnableJms
@ComponentScan("com.tsystems.javaschoolshop")
@PropertySource(value = { "classpath:mail.properties" })
public class JmsConfig {

    @Autowired
    private Environment environment;

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(environment.getRequiredProperty("jms.url"));
        connectionFactory.setPassword(environment.getRequiredProperty("jms.password"));
        connectionFactory.setUserName(environment.getRequiredProperty("jms.username"));
        return connectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        return template;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setConcurrency("1-1");
        return factory;
    }
}
