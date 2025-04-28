package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {



    @Before("org.example.aspect.CommonPointcut.serviceLayer()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("Sebelum memanggil: " + joinPoint.getSignature().getName());
    }

    @After("org.example.aspect.CommonPointcut.serviceLayer()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("Setelah memanggil: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "org.example.aspect.CommonPointcut.serviceLayer()", returning = "resut")
    public void logAfterReturning(JoinPoint joinPoint, Object result){
        System.out.println("Method " + joinPoint.getSignature().getName() + " Mengembalikan " + result);
    }

    @AfterThrowing(pointcut = "org.example.aspect.CommonPointcut.serviceLayer()", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable th){
        System.out.println("Method " + joinPoint.getSignature().getName() + " melempar " + th);
    }
}
