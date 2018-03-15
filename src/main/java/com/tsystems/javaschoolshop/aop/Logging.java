package com.tsystems.javaschoolshop.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component("Logging")
public class Logging {
    private Logger logger = Logger.getLogger(Logging.class);

    @Pointcut("@annotation(jdk.nashorn.internal.runtime.logging.Logger)")
    public void checkPermission() {
        return ;
    }

    @Before("checkPermission()")
    public void logBefore(){
        logger.info("Before...");
        return;
    }
    @After("checkPermission()")
    public void logAfter(){
        logger.info("After...");
        return;
    }
}
