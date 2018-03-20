package com.tsystems.javaschoolshop.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {
    private Logger logger = Logger.getLogger(Logging.class);

    @Pointcut("within(com.tsystems.javaschoolshop.service..*) ||" +
            "within(com.tsystems.javaschoolshop.model..*) ||" +
            "within(com.tsystems.javaschoolshop.controller..*) ||" +
            "within(com.tsystems.javaschoolshop.dao..*)")
    public void witch()  {
        // pointcut for log
    }

    @Before(value = "witch()")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("###### Requested class : {" + joinPoint.getTarget().getClass().getName() + "} ; Method : {" + joinPoint.getSignature().getName() + "} ");
        Object[] signatureArgs = joinPoint.getArgs();
        for (Object signatureArg : signatureArgs) {
            logger.info("###### Arguments: {" + signatureArg.toString() + "} ");
        }
    }

    @AfterReturning(pointcut = "witch()")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("###### Success return for method :{"+ joinPoint.getSignature().getName()+"}");
        return;
    }

    @AfterThrowing(pointcut = "witch()", throwing = "ex")
    public void exceptionError(Throwable ex) {
        logger.error("Fatal Error:", ex);
        return;
    }

}
