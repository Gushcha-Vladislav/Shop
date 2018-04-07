package com.tsystems.javaschoolshop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AspectJ initializer class.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.tsystems.javaschoolshop.aop")
public class AspectConfig {
}
