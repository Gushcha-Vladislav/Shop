package com.tsystems.javaschoolshop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import javax.annotation.Resource;
import java.util.Properties;


@Configuration
@PropertySource(value = { "classpath:mail.properties" })
public class MailConfig {

    @Resource
    private Environment environment;

    @Value("${email.subject}")
    private String subject;

    @Bean
    public JavaMailSender javaMailService() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(environment.getRequiredProperty("mail.host"));
        javaMailSender.setUsername(environment.getRequiredProperty("mail.username"));
        javaMailSender.setPassword(environment.getRequiredProperty("mail.password"));
        javaMailSender.setPort(new Integer(environment.getRequiredProperty("mail.port")));

        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.ssl.trust",environment.getRequiredProperty("mail.host"));
        properties.setProperty("mail.debug", "true");
        javaMailSender.setJavaMailProperties(properties);

        return javaMailSender;
    }
}
