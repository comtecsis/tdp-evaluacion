package pe.com.tdp.catalogue.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
public class DemoControllerAop {

    private static final Logger logger = LogManager.getLogger();

    @Before(value = "execution(* pe.com.tdp.catalogue.controller.*.*(..))")
    public void before(JoinPoint joinPoint) {
        logger.info("after execution of {}", joinPoint);
    }

    @Around("execution(* pe.com.tdp.catalogue.controller.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long timeTaken = System.currentTimeMillis() - startTime;
        logger.info("Time Taken by {} is {} ms", joinPoint, timeTaken);
        return proceed;
    }

    @After(value = "execution(* pe.com.tdp.catalogue.controller.*.*(..))")
    public void after(JoinPoint joinPoint) {
        logger.info("after execution of {}", joinPoint);
    }

    @AfterReturning(value = "execution(* pe.com.tdp.catalogue.controller.*.*(..))",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("{} returned with value {}", joinPoint, result);
    }

}
