package com.nextyu.demo.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 2017-10-28 17:56
 *
 * @author nextyu
 */
@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.nextyu.demo.web.controller.*.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("time aspect start");

        // 获取当前连接点（join point）的参数值，这里就是 HelloController.sayHello(String name) 方法参数 name 的值
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("arg is " + arg);
        }

        long startTime = System.currentTimeMillis();

        Object object = pjp.proceed();

        long endTime = System.currentTimeMillis();
        System.out.println("time aspect consume " + (endTime - startTime) + " ms");

        System.out.println("time aspect end");

        return object;
    }

}
