package com.dmitryshulga.spring.mvc_hibernate_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
// аспект, в котором есть эдвайс для всех методов из пакета дао
public class MyLoggingAspect {
    @Around("execution(* com.dmitryshulga.spring.mvc_hibernate_aop.dao.*.*(..))")
    public Object aroundAllRepositoryMethodAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // из джоинпоинта получаем сигнатуру метода, на котором вызвался эдвайс
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        System.out.println("Begin of " + methodName);// логируем начало работы таргет метода выводом мэсседжа в терминал
        Object targetMethodResult = proceedingJoinPoint.proceed();// выполняем таргет метод
        System.out.println("End of " + methodName);// логируем конец работы таргет метода выводом мэсседжа в терминал
        return targetMethodResult;// возвращаем резалт таргет метода в точку его вызова
    }
}
