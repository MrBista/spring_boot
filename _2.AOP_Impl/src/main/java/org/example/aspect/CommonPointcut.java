package org.example.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CommonPointcut {
    @Pointcut("execution(* org.example.service.*.*(..))")
    public void serviceLayer() {}
}
